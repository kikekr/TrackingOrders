package com.egoberna.tracking.models;

import java.time.ZonedDateTime;

import com.egoberna.tracking.states.OrderState;

public class OrderStatusChangeRegister {
	
	/**
	 * Class which represents an order status change register
	 */
	
	private Order order;
	private OrderState state;
	private ZonedDateTime date;
	
	public OrderStatusChangeRegister(Order order, OrderState state, ZonedDateTime date) {
		/**
		 * Constructor method
		 * @param order: Order
		 * @param state: OrderState
		 * @param date: ZonedDateTime
		 */
		
		super();
		this.order = order;
		this.state = state;
		this.date = date;
	}
	
	public Order getOrder() {
		/**
		 * Returns the order
		 * @return Order
		 */
		
		return order;
	}
	public void setOrder(Order order) {
		/**
		 * Sets the order
		 * param Order
		 */
		
		this.order = order;
	}
	public OrderState getState() {
		/**
		 * Returns the order state
		 * @return OrderState
		 */
		
		return state;
	}
	public void setState(OrderState state) {
		/**
		 * Sets the order state
		 * @param OrderState
		 */
		
		this.state = state;
	}
	public ZonedDateTime getDate() {
		/**
		 * Returns the register date
		 * @return ZonedDateTime
		 */
		
		return date;
	}
	public void setDate(ZonedDateTime date) {
		/**
		 * Sets the register date
		 * @param ZonedDateTime
		 */
		
		this.date = date;
	}
		
	@Override
	public String toString() {
		return "State " + this.state + " at " + this.date.toString();
	}
	
	
	
	
	
}
