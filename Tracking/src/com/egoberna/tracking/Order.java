package com.egoberna.tracking;

import com.egoberna.tracking.states.RecogidoEnAlmacen;

public class Order {

	private OrderState state;
	private int orderId;
	
	public Order(int orderId) {
		this.orderId = orderId;
		this.state = new RecogidoEnAlmacen();
	}
	
	public void changeState(int changeOrderStatusId) {
		this.state.changeStatus(changeOrderStatusId);
	}

	public OrderState getState() {
		return state;
	}

	public void setState(OrderState state) {
		this.state = state;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	
	
}
