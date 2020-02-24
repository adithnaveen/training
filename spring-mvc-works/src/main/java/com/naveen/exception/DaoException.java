package com.naveen.exception;

public class DaoException  extends Exception{
	private String message; 
	
	public DaoException() {
		this.message = "DAO Exception caused"; 
	}
	public DaoException(String message) {
		this.message = message; 
	}
}
