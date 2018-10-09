/**
 * ejemplo de HandlerInterceptor
 */

package com.udemy.backend.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * Cada peticio entrara por este Handler y se calculara el tiempo desde que abre un controlador y su funcion
 * hasta antes de mostrarlo en pantalla
 * @author Z757768
 *
 */
@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

	private static final Log LOG =  LogFactory.getLog(RequestTimeInterceptor.class);

	
	/**
	 * Se ejecuta antes de entrar al metodo del controlador
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/* Auto-generated method stub*/
		request.setAttribute("startTime", System.currentTimeMillis());
		
		return true; 
	}
	
	
	
 
	/**
	 * Se ejecuta justo antes de mandar a la vista al navegador , antes del return 
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime = (long) request.getAttribute("startTime");
		/** resta de tiempo del server */
		LOG.info("---REQUEST URL: "+ request.getRequestURL().toString() + " --TOTAL TIME: '"+
		(System.currentTimeMillis()-startTime) +"' ms");
		
	}

	
	 
}
