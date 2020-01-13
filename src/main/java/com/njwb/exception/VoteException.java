package com.njwb.exception;

public class VoteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public VoteException() {
		
	}
	
	public VoteException(String msg) {
		super(msg);
		this.message = msg;
	}
	
	public String getMessage() {
		return this.message;
	}
}
