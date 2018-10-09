/**
 * Ejemplos de MVC 
 * Modelos
 * Components
 * Services
 * 
 */
package com.udemy.backend.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backend.component.ExampleComponent; 
import com.udemy.backend.service.ExampleService;

@Controller

@RequestMapping("/example")
public class ExampleController {

	public static final String EXAMPLE_VIEW = "example";

	/** inyectando component */
	//indica a spring que vamos a inyectar un componente que esta en su memoria
	@Autowired    
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComp;
	
	/** inyectando el service */
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	
	// primera forma de template
	// retorna el nombre del template
	@RequestMapping(value = "/string", method = RequestMethod.GET)
	public String exampleString(Model model) {
		model.addAttribute("people",exampleService.getListPeople());  //usando el service
		return EXAMPLE_VIEW;
	}

	// return MAV
	// @RequestMapping(value="/MAV",method=RequestMethod.GET)
	
	@GetMapping("/mav") // los dos request hacen lo mismo
	public ModelAndView exampleMAV() {
		exampleComp.sayHello();  //usando funcion del component
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people",exampleService.getListPeople());  // usando funcion del service 
		return mav;
	}

	

}
