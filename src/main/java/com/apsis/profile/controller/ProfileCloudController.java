package com.apsis.profile.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.apsis.profile.model.Counter;
import com.apsis.profile.service.CounterService;

/**
 * REST Controller class used to call the corresponding REST methods based on
 * Request.
 * 
 * @author sankar
 *
 */
@RestController
@RequestMapping("/profile")
public class ProfileCloudController {

	public static final Logger logger = LoggerFactory.getLogger(ProfileCloudController.class);

	@Autowired
	CounterService counterService;

	/**
	 * REST Method used to get the Counter Value for the Counter based on Request Input.
	 * @param counterName
	 * @return
	 */
	@GetMapping(value = "/{countername}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Counter> getCounterValue(@PathVariable("countername") String counterName) {

		Counter counter = counterService.findByName(counterName);
		if (counter == null) {
            return new ResponseEntity<Counter>(HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<Counter>(counter, HttpStatus.OK);

	}

	/**
	 * REST method used to return all the Counters and corresponding Values in a List.
	 * @return List<Counter>
	 */
	@GetMapping(value = "/counters", headers = "Accept=application/json")
	public List<Counter> getAllUser() {
		List<Counter> counters = counterService.getAllCounters();
		return counters;

	}

	/**
	 * REST Method used to create the Counter based on the Request JSON Input.
	 * @param counter
	 * @param ucBuilder
	 * @return
	 */
	@PostMapping(value = "/create", headers = "Accept=application/json")
	public ResponseEntity<Void> createCounter(@RequestBody Counter counter, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Counter " + counter.getCounterName());
		counterService.createCounter(counter);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/profile/{countername}").buildAndExpand(counter.getValue()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	/**
	 * REST Method used to update/add Counter Value for the Counter based on Request Input.
	 * @param counterName
	 * @return String - HTTP Status code
	 */
	@PutMapping(value = "/update", headers = "Accept=text/plain")
	public ResponseEntity<String> updateCounter(@RequestBody String counterName) {
		Counter existingCounter = counterService.findByName(counterName);
		if (existingCounter == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		int counterValue = existingCounter.getValue();
		existingCounter.setValue(counterValue + 1);
		counterService.updateCounter(existingCounter);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}