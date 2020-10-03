package com.egoberna.tracking;

import java.util.Date;

import com.egoberna.tracking.states.RecogidoEnAlmacen;

public class Order {
	
	private OrderState state;
	private int orderId;
	private Date date;
	
	public Order(int orderId) {
		this.orderId = orderId;
		this.state = new RecogidoEnAlmacen();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
	
	private void checkStateRestrictions(int changeOrderStatusId) throws InvalidStatusChangeException, UnknownOrderStateException {
		this.state.checkStateRestrictions(changeOrderStatusId);
		System.out.println(
				"Order " + this.orderId + " changes state from " + this.state + " to " + 
		changeOrderStatusId);
	}
	
	public void changeStatus(int changeOrderStatusId) throws InvalidStatusException {
		checkStateRestrictions(changeOrderStatusId);
		setState(OrderStateFactory.getOrderState(changeOrderStatusId));
	}
	
}
