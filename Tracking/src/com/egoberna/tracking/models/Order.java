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
			
			// Sort status change history by date
			Collections.sort(statusChangeHistory, new SortByDate());
			
			// Get the last status change before the input date
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
	
	public OrderState getNextState(ZonedDateTime date) {
		/**
		 * Returns the next order state at specific date and time
		 * @param date: ZonedDateTime
		 * @return OrderState
		 */
		
		if (statusChangeHistory.size() > 0) {
			
			// Sort status change history by date
			Collections.sort(statusChangeHistory, new SortByDate());
			
			// Get the last status change before the input date
			OrderStatusChangeRegister selectedStateRegister = statusChangeHistory.get(0);
			int i = 0;
			int selectedIndex = -1;
			for (i = 0; i < statusChangeHistory.size(); i++) {
				if (statusChangeHistory.get(i).getDate().isBefore(date)) {
					selectedStateRegister = statusChangeHistory.get(i);
					selectedIndex = i;
				}
			}
			
			if (statusChangeHistory.size() >= selectedIndex+2 && selectedIndex != -1) {
				OrderStatusChangeRegister nextStateRegister = statusChangeHistory.get(selectedIndex+1);
				if (nextStateRegister != null) {
					return nextStateRegister.getState();
				}
			}
		}
		return null;
	
	}
	
	private void checkStateRestrictions(ZonedDateTime date, int changeOrderStatusId) throws 
		InvalidStatusException {
		/**
		 * Checks that the state change is valid and does not violate any rules
		 * @param date: ZonedDateTime
		 * @param changeOrderStatusId: int
		 */
				
		// Get the order state at requested date
		OrderState currentState = getStateAt(date);
		// Get the order desired state for that date
		OrderState desiredState = OrderStateFactory.getOrderState(changeOrderStatusId);

		// If the order hadn't status, raise an exception
		if (currentState == null && changeOrderStatusId != RecogidoEnAlmacen.ID) {
			throw new InvalidStatusChangeException("El estado inicial debe de ser recogido en almacén");
		}
		
		// In other case, delegate in state pattern to check if the status change is valid and does
		// not violate any rules
		if (currentState != null) {
			currentState.checkStateRestrictions(desiredState.getID());
			
			// Get the next state from that date
			OrderState nextState = getNextState(date);

			if (nextState != null) {
				// check if the status change is valid and does not violate any rules
				desiredState.checkStateRestrictions(nextState.getID());
			}
		}
		
	}
	
	public void changeStatus(ZonedDateTime date, int changeOrderStatusId) throws 
		InvalidStatusException {
		/**
		 * Checks that the state change is valid and applies it
		 * @param date: ZonedDateTime
		 * @param changeOrderStatusId: int
		 * @throws InvalidStatusException
		 */
				
		// check if the status change is valid and does not violate any rules
		checkStateRestrictions(date, changeOrderStatusId);
		
		System.out.println("");
		
		
		// Instantiate the new order state
		OrderStatusChangeRegister orderStatusChangeRegister = new OrderStatusChangeRegister(
				this, OrderStateFactory.getOrderState(changeOrderStatusId), date);
		
		// Add the new order state register
		addStatusChangeRegister(orderStatusChangeRegister);	
	
	}
	
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
