package com.egoberna.tracking.exceptions;

import java.io.Serializable;

public class InvalidStatusException extends Exception implements Serializable {

	/**
	 * Class which represents an exception related to status change
	 */
	
	private static final long serialVersionUID = 1L;

	public InvalidStatusException(String errorMessage) {
		super("<?xml version=\"1.0\"?><tracking>" + errorMessage + "</tracking>");
	}
	
}
