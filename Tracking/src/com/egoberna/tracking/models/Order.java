package com.egoberna.tracking.models;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.egoberna.tracking.exceptions.InvalidStatusChangeException;
import com.egoberna.tracking.exceptions.InvalidStatusException;
import com.egoberna.tracking.exceptions.UnknownOrderStatusException;
import com.egoberna.tracking.states.OrderState;
import com.egoberna.tracking.states.OrderStateFactory;
import com.egoberna.tracking.states.RecogidoEnAlmacen;

public class Order {
	
	/**
	 * Class which represents an order
	 */
	
	// Order identifier
	private int orderId;
	
	// Status changes history
	private List<OrderStatusChangeRegister> statusChangeHistory;
	
	public Order(int orderId) {
		/**
		 * Constructor method
		 * @param orderID: int
		 */
		
		this.orderId = orderId;
		this.statusChangeHistory =  new ArrayList<>();
	}

	public int getOrderId() {
		/**
		 * Returns the order Id
		 * @return int
		 */
		
		return orderId;
	}

	public void setOrderId(int orderId) {
		/**
		 * Sets the order Id
		 * param orderId: int
		 */
		
		this.orderId = orderId;
	}
	
	public OrderState getStateAt(ZonedDateTime date) {
		/**
		 * Returns the order state at specific date and time
		 * @param date: ZonedDateTime
		 * @return OrderState
		 */
		
		if (statusChangeHistory.size() > 0) {
			Collections.sort(statusChangeHistory, new SortByDate());
			OrderStatusChangeRegister selectedStateRegister = statusChangeHistory.get(0);
			for (int i = 0; i < statusChangeHistory.size(); i++) {
				if (statusChangeHistory.get(i).getDate().isBefore(date)) {
					selectedStateRegister = statusChangeHistory.get(i);
				}
			}
			return selectedStateRegister.getState();
		}
		else {
			return null;
		}
	}
	
	private void checkStateRestrictions(ZonedDateTime date, int changeOrderStatusId) throws 
		InvalidStatusException {
		/**
		 * Checks that the state change is valid and does not violate any rules
		 * @param date: ZonedDateTime
		 * @param changeOrderStatusId: int
		 */
		
		OrderState state = getStateAt(date);
		if (state == null && changeOrderStatusId != RecogidoEnAlmacen.ID) {
			throw new InvalidStatusChangeException("El estado inicial debe de ser recogido en almacén");
		}
		if (state != null) {
			state.checkStateRestrictions(changeOrderStatusId);
		}
		System.out.println("");
	}
	
	public void changeStatus(ZonedDateTime date, int changeOrderStatusId) throws 
		InvalidStatusException {
		/**
		 * Checks that the state change is valid and applies it
		 * @param date: ZonedDateTime
		 * @param changeOrderStatusId: int
		 */
		
		checkStateRestrictions(date, changeOrderStatusId);
		OrderStatusChangeRegister orderStatusChangeRegister = new OrderStatusChangeRegister(
				this, OrderStateFactory.getOrderState(changeOrderStatusId), date);
		addStatusChangeRegister(orderStatusChangeRegister);	}
	
	public void addStatusChangeRegister(OrderStatusChangeRegister orderStatusChangeRegister) {
		/**
		 * Adds a status register
		 * @param orderStatusChangeRegister: OrderStatusChangeRegister
		 */
		
		this.statusChangeHistory.add(orderStatusChangeRegister);
	}
	
	static class SortByDate implements Comparator<OrderStatusChangeRegister> {
		
		/**
		 * Static class which represents an status change history ordering method by date.
		 */
		
	    @Override
	    public int compare(OrderStatusChangeRegister a, OrderStatusChangeRegister b) {
	        return a.getDate().compareTo(b.getDate());
	    }
	}
	
}
