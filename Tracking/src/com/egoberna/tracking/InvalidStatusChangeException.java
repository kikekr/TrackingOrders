package com.egoberna.tracking;

public class InvalidStatusChangeException extends Exception {

	public InvalidStatusChangeException(String errorMessage) {
		super(errorMessage);
	}
}
