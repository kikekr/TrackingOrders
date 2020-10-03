package com.egoberna.tracking.exceptions;

public class InvalidStatusChangeException extends InvalidStatusException {

	/**
	 * Exception which represents a violation of the state change rules
	 */
	
	public InvalidStatusChangeException(String errorMessage) {
		super(errorMessage);
	}
}
