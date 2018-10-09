/**
 * Manejador de errores
 * Permite configurar el manejo de los errores. por ejemplo al recibir una excepcion
 * 
 * Se ocupa  ControllerAdvice    para indicar que es un manejador de errores
 */
package com.udemy.backend.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorsController {

	public static final String ISE_VIEW="error/500";
	
	
	/**
	 * Al generarse una excepcion, se envia pagina de error 500
	 * @return view
	 */
	@ExceptionHandler(Exception.class)
	public String showInternalServerError() {
		return ISE_VIEW;
	}
	
}
