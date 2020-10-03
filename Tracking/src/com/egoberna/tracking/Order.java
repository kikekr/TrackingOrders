package com.egoberna.tracking;

public class Order {

	private OrderState state;
	
	public void handle() {
		this.state.handle();
	}
	
}
