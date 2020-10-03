package com.egoberna.tracking;

public class UnknownOrderStateException extends Exception {

	public UnknownOrderStateException(int orderStatusId) {
		super("Unknown order status " + orderStatusId);
	}
	
}
