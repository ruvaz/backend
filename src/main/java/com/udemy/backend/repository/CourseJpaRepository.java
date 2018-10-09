/**   
 * Ejemplo de JPA repository 
 * como se crean las consulas
 * para consultas mas complejas se emplea DSL
 * 
 */
package com.udemy.backend.repository;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.backend.entity.Course;

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course, Serializable> {

	//solo se necesita declarar la interface para crear el repository sin impl
	
	/** Hace una query automatica y devuelve resultaados por precio*/
	public abstract Course findByPrice(int price);

	/**
	 * Devuelve resultados de un query filtrado por price y name
	 * @param price
	 * @param name
	 * @return
	 */
	public abstract Course findByPriceAndName(int price, String name);
	
	/**
	 * Busca por nombre y ordena por horas
	 * @param name
	 * @return
	 */
	public abstract List<Course> findByNameOrderByHours(String name);
	
	
	/**
	 * Busca por nombre o precio
	 * @param name
	 * @param price
	 * @return
	 */
	public abstract Course findByNameOrPrice(String name, int price);
	
}
