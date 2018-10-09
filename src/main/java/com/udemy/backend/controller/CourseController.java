/**
 * 
 */
package com.udemy.backend.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backend.entity.Course;
import com.udemy.backend.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	
	private static final Log LOG = LogFactory.getLog(CourseController.class);
	private static final String COURSE_VIEW ="courses";
	
	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService; 
	
	/**
	 * Listado de los cursos en un template
	 * Obtiene el listado del service impl
	 * @return
	 */
	@GetMapping("/list")
	public ModelAndView listAllCourse() {
		LOG.info("CALL: listAllCourses()");
		ModelAndView model = new ModelAndView(COURSE_VIEW);
		model.addObject("courses",courseService.listAllCourse());
		
		/**para el formulario inferior*/
		model.addObject("course",new Course());
		
		return model; 
	}
	
	
	/**
	 * AGREGA UN CURSO4
	 * viene el obj del post como ModelAttribute
	 * usa el service para guardar los datos
	 * @param course
	 * @return string redirect 
	 */
	@PostMapping("/add")
	public String addCourse(@ModelAttribute("course") Course course) {
		LOG.info("CALL: addCourses(course)" );
		LOG.info("Course: "+course.toString());
		courseService.addCourse(course);
		//return "redirect:/list";  // 8080:/listcourse
		return "redirect:/courses/list";
	}
	
	 
	
}
