package com.practicalunittesting.chp05.raceresults;

import java.util.List;

/**
 * Practical Unit Testing with JUnit and Mockito - source code for examples.
 * Visit http://practicalunittesting.com for more information.
 *
 * @author Tomek Kaczanowski
 */
public interface Client {
	void receive(Message message);
	List<ResultCategory> getCategories();
}
