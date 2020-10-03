package com.egoberna.tracking;

public class UnknownOrderStateException extends InvalidStatusException {

	public UnknownOrderStateException(int orderStatusId) {
		super("Unknown order status " + orderStatusId);
	}
	
}
