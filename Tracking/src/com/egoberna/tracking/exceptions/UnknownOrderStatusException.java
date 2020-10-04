package com.egoberna.tracking.exceptions;

public class UnknownOrderStatusException extends InvalidStatusException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Exception which represents an unknown order status code
	 */
	
	public UnknownOrderStatusException(int orderStatusId) {
		super("Unknown order status " + orderStatusId);
	}
	
}
