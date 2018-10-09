/**
 * Ejemplo de FORM
 * recibe post
 * pinta un form
 * 
 * ejemplos de redirects
 * 
 * ejemplo de validacion de formularios, se necesita que el modelo tenga ciertas anotaciones en sus atributos.
 * @Min  @Size  @NotNull
 */
package com.udemy.backend.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backend.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

	
	private static final String FORM_VIEW = "form";
	private static final String RESULT_VIEW = "result";
	
	private static final Log LOG = LogFactory.getLog(Example3Controller.class);
	
	 /**
	  * REDIRECT 1
	  * @return redirect route
	 
	@GetMapping("/")
	public String redirect() {
		return "redirect:/example3/showform";
	} 
	*/
	
	/**
	 * REDIRECT 2
	 * @return RedirectView
	 */
	@GetMapping("/")
	public RedirectView redirectV() {
		return new RedirectView("/example3/showform");
	}
	
 
	/**
	 * Muestra el Form 
	 * ejemplos de LOG
	 * Ejemplos de model
	 * @param model
	 * @return
	 */
	@GetMapping("/showform")
	public String showForm(Model model) {
		//crea modelo vacio
		model.addAttribute("person", new Person()); 
		LOG.info("INFO LOOOOOG");
		LOG.warn("WARNING LOGGGGG");
		LOG.debug("DEBUG LOOOOOOOG");
		LOG.error("ERROR LOOOOOOOG");
		return FORM_VIEW;
	}
	
	
	/**
	 * Recibe POST person object
	 * se recibe el objeto dentro del POST desde el form  y se manda a una vista los valores captados
	 * Se agregara @Valid para que aplique las validaciones    y BindingResult-> en el caso que no se cumplan las reglas
	 * @param person  object
	 * @return  model
	 */
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult  ) {
		
		ModelAndView model = new ModelAndView();
		
		/** Validaciones,  si ocurre que hay errores los mete en el campo fields */
		if(bindingResult.hasErrors()){
			model.setViewName(FORM_VIEW);
		}else {		
			model.setViewName(RESULT_VIEW);
			model.addObject("person",person);
		}		
		
		
		LOG.info("METHOD: 'addPerson' -- PARAMS: '"+person+"'");
		LOG.info("TEMPLATE: '"+RESULT_VIEW+"' -- DATA: '"+person+"'");
		
		return model;
	}
	
	
}
