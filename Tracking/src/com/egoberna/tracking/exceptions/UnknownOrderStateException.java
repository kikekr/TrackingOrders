package com.egoberna.tracking.exceptions;

public class UnknownOrderStateException extends InvalidStatusException {

	public UnknownOrderStateException(int orderStatusId) {
		super("Unknown order status " + orderStatusId);
	}
	
}
