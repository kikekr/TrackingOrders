package com.egoberna.tracking.models;

import java.time.ZonedDateTime;

import com.egoberna.tracking.states.OrderState;

public class OrderStatusChangeRegister {
	
	private Order order;
	private OrderState state;
	private ZonedDateTime date;
	
	public OrderStatusChangeRegister(Order order, OrderState state, ZonedDateTime date) {
		super();
		this.order = order;
		this.state = state;
		this.date = date;
	}
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public OrderState getState() {
		return state;
	}
	public void setState(OrderState state) {
		this.state = state;
	}
	public ZonedDateTime getDate() {
		return date;
	}
	public void setDate(ZonedDateTime date) {
		this.date = date;
	}
	
	
	
	
	
}
