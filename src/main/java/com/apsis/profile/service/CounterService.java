package com.apsis.profile.service;

import java.util.List;

import com.apsis.profile.model.Counter;

/**
 * Counter Service interface with methods.
 * 
 * @author sankar
 *
 */
public interface CounterService {

	public Counter findByName(String counterName);

	public List<Counter> getAllCounters();

	public void createCounter(Counter counter);

	public void updateCounter(Counter counter);
}
