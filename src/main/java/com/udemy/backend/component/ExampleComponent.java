/**
 * Ejemplo de component
*/
package com.udemy.backend.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;*/
import org.springframework.stereotype.Component;

//import com.udemy.backend.repository.CourseJpaRepository;

/**
 * Ejemplo de un component
 * que puede inyectado en cualquier lugar al ser cargado en memoria de spring
 * es necesario usar autowired y qualifier para poder implementarlo
 * @author Z757768
 *
 */
@Component("exampleComponent")
public class ExampleComponent {

	private static final Log LOG =  LogFactory.getLog(ExampleComponent.class);
/*
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	
	*/
	/**
	 * funcion que despiega en el log un saludo
	 */
	public void sayHello() {
		//courseJpaRepository.findByNameOrPrice("ruben",10);
		
		LOG.info("Hello from Component");
	}
	
	
	
}
