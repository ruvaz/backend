/*
 * Es necesario hacer autowire y qualifier en donde se inyecte este service
 * es necesario que exista previamente la Interfaz 
 * */
package com.udemy.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.backend.model.Person;
import com.udemy.backend.service.ExampleService;


@Service("exampleService")
public class ExampleServiceImpl implements ExampleService{
	
	
	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

	@Override
	public List<Person> getListPeople() { 
		
		List<Person> people = new ArrayList<>();
		people.add(new Person("usuario1", 1));
		people.add(new Person("usuario2", 2));
		people.add(new Person("usuario3", 3));
		people.add(new Person("usuario4", 4));
		people.add(new Person("usuario5", 5));
		people.add(new Person("usuario6", 6)); 
		
		LOG.info("Hello from Service - getListPeople");
		
		return people;
	}

	 
	
	
}
