/**
 * Interfaz para el service
 */
package com.udemy.backend.service;

import java.util.List;

import com.udemy.backend.model.Person;

public interface ExampleService {

	/**
	 * Obtiene la lista de personas
	 * @return List<Person>
	 */
	public abstract List<Person> getListPeople();
	
	
}
