/**
 * Class Converter para cambiar entre model a entity
 * se tiene que crear el entity usar el model
 * para que los CONTROLLER NO UTILICEN NUNCA ENTITYS
 */

package com.udemy.backend.converter;

import org.springframework.stereotype.Component;

import com.udemy.backend.entity.Course;
import com.udemy.backend.model.CourseModel;

@Component("courseConverter")
public class CourseConverter {
 
	
	
	/**
	 * Entity -> a -> Model
	 * @param course
	 * @return
	 */
	public CourseModel entity2model(Course course) {
		CourseModel courseModel = new CourseModel();
		
		courseModel.setName(course.getName());
		courseModel.setDescription(course.getDescription());
		courseModel.setPrice(course.getPrice());
		courseModel.setHours(course.getHours());			
		
		return courseModel;
	}
	
 
	/**
	 * Model -> a -> Entity
	 * @param courseModel
	 * @return
	 */
	public Course model2entity(CourseModel courseModel) {
		Course course = new Course();
		course.setName(courseModel.getName());
		course.setDescription(courseModel.getDescription());
		course.setPrice(courseModel.getPrice());
		course.setHours(courseModel.getHours());
		
		return course;
		
	}
	
}
