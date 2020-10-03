package com.egoberna.tracking;

public class InvalidStatusChangeException extends InvalidStatusException {

	public InvalidStatusChangeException(String errorMessage) {
		super(errorMessage);
	}
}
