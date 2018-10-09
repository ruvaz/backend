package com.udemy.backend.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.backend.entity.Course;
import com.udemy.backend.repository.CourseJpaRepository;
import com.udemy.backend.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {
	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);

	/**
	 * Inyeccion del Repositorio para acceder al JPA para acceder a la BD
	 */
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Override
	public List<Course> listAllCourse() {
		LOG.info("Call: listAllCourse()");
		 return courseJpaRepository.findAll();
	}

	@Override
	public Course addCourse(Course course) {
		LOG.info("Call: addCourse()");
		/* si lo hace correctamente devuelve el objeto que se acaba de guardar*/
		return courseJpaRepository.save(course);
	}

	@Override
	public int removeCourse(int id) {
		LOG.info("Call: removeCourse(");
		courseJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		
		LOG.info("Call: updateCourse()");
		/* save busca el id y si existe lo actuliza en automatico*/
		return courseJpaRepository.save(course);
	}

}
