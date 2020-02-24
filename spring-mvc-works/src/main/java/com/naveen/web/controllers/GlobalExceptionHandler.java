package com.naveen.web.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	
	@ExceptionHandler(value = Exception.class)
	public String errorHandler(Exception ex, Model model ) {
		log.error(ex.getLocalizedMessage());
		model.addAttribute("ex", ex); 
		return "err"; 
	}
}
