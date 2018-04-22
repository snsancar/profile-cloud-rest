package com.apsis.profile.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.apsis.profile.model.Counter;

/**
 * Service Class used to serve different services requested by Controller.
 * @author sankar
 *
 */
@Service
public class CounterServiceImpl implements CounterService {

	public static final Logger logger = LoggerFactory.getLogger(CounterServiceImpl.class);
	private static List<Counter> counters;
	
	static {
		counters = someInitialCounters();
    }
	
	/**
	 * This method used to return the Counter details based on Counter Name.
	 * @return Counter - 
	 */
	@Override
	public Counter findByName(String counterName) {
		for (Counter counter : counters) {
			if (counter.getCounterName().equals(counterName)) {
                return counter;
            }
		}
		return null;
	}
	
	/**
	 * This method used to return Test Counter name as["profileofshankar"] and initial value as[1].
	 * @return List<Counter>
	 */
	private static List<Counter> someInitialCounters() {
		List<Counter> listOfCounters = new ArrayList<>();
		Counter counter = new Counter();
		counter.setCounterName("profileofshankar");
		counter.setValue(1);
		listOfCounters.add(counter);
		return listOfCounters;
	}


	/**
	 * This method used to return all the Counters and Corresponding Values in a list.
	 * @return List<Counter>
	 */
	@Override
	public List<Counter> getAllCounters() {

		return counters;
	}


	/**
	 * This method used to create new Counter.
	 */
	@Override
	public void createCounter(Counter counter) {

		counters.add(counter);
	}


	/**
	 * This method used to update the Counter with the incremented Value.
	 */
	@Override
	public void updateCounter(Counter counter) {

		
	}
}
