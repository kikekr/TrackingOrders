package com.egoberna.tracking.exceptions;

import java.io.Serializable;

public class InvalidStatusException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	public InvalidStatusException(String errorMessage) {
		super(errorMessage);
	}
	
}