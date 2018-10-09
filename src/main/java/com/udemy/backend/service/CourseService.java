/**
 * Service para manejar cursos
 */
package com.udemy.backend.service;

import java.util.List;

import com.udemy.backend.entity.Course;

public interface CourseService {

	/**
	 * Listado de cursos
	 * @return List<Course>
	 */
	public abstract List<Course> listAllCourse();
	
	/**
	 * Agregar curso
	 * @param course
	 * @return Course
	 */
	public abstract Course addCourse(Course course);
	
	/**
	 * eliminar curso
	 * @param id
	 * @return int
	 */
	public abstract int removeCourse(int id);
	
	
	/**
	 * actualizar curso
	 * @param course
	 * @return Course
	 */
	public abstract Course updateCourse(Course course);
	
	
	
	
}
