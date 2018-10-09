/**
 * Controller para ejemplo de cachar por GET la información
 * por ?nm= 
 * o por   /{}  
 * 
 */
package com.udemy.backend.controller;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class Example2Controller {

	private static final String EXAMPLE_VIEW2 = "example2";

	
	//PETICIONES GET	
	/**
	 * Cacha por GET el parametro nm y permite no recibir necesariamente
	 * cacha el parametro a traves de  ?nm=
	 * http://localhost:8080/example2/request1?nm=JON
	 * @param name
	 * @return model
	 */
	@GetMapping("/request1")
	public ModelAndView request1(@RequestParam(name="nm" , required=false, defaultValue="NULL") String name) {
		ModelAndView model = new ModelAndView(EXAMPLE_VIEW2);
		
		/* Se agrega el valor al objeto que se enviara por MAV*/
		model.addObject("nm_in_model",name);
		return model;
	}
	
	/**
	 * Cacha la Variable por GET del modo en que es 
	 * cacha el valor GET dentro del URL despues del "/"  con /{nm}
	 * http://localhost:8080/example2/request2/JON
	 * @param name
	 * @return model
	 */
	@GetMapping("/request2/{nm}")   
	public ModelAndView request2(@PathVariable("nm") String name) {
		ModelAndView model = new ModelAndView(EXAMPLE_VIEW2);
		model.addObject("nm_in_model",name);		
		return model;
	}
	
}
