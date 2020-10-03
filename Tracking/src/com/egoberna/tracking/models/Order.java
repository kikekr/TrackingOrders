package com.egoberna.tracking.models;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.egoberna.tracking.exceptions.InvalidStatusChangeException;
import com.egoberna.tracking.exceptions.InvalidStatusException;
import com.egoberna.tracking.exceptions.UnknownOrderStateException;
import com.egoberna.tracking.states.OrderState;
import com.egoberna.tracking.states.OrderStateFactory;
import com.egoberna.tracking.states.RecogidoEnAlmacen;

public class Order {
	
//	private OrderState state;
	private int orderId;
	private Date date;
	private List<OrderStatusChangeRegister> statusChangeHistory;
	
	public Order(int orderId) {
		this.orderId = orderId;
//		this.state = new RecogidoEnAlmacen();
		this.statusChangeHistory =  new ArrayList<>();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
//
//	public OrderState getState() {
//		return state;
//	}
//
//	public void setState(OrderState state) {
//		this.state = state;
//	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public OrderState getStateAt(ZonedDateTime date) {
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
	
	private void checkStateRestrictions(ZonedDateTime date, int changeOrderStatusId) throws InvalidStatusChangeException, UnknownOrderStateException {
		System.out.println("Checking state restrictions");
		OrderState state = getStateAt(date);
		System.out.println("State at " + date.toString() + ": " + state);
		System.out.println("New desired state: " + changeOrderStatusId);
		if (state == null && changeOrderStatusId != RecogidoEnAlmacen.ID) {
			throw new InvalidStatusChangeException("El estado inicial debe de ser recogido en almacén");
		}
		if (state != null) {
			state.checkStateRestrictions(changeOrderStatusId);
		}
		System.out.println("");
	}
	
	public void changeStatus(ZonedDateTime date, int changeOrderStatusId) throws InvalidStatusException {
		checkStateRestrictions(date, changeOrderStatusId);
		OrderStatusChangeRegister orderStatusChangeRegister = new OrderStatusChangeRegister(
				this, OrderStateFactory.getOrderState(changeOrderStatusId), date);
		addStatusChangeRegister(orderStatusChangeRegister);	}
	
	public void addStatusChangeRegister(OrderStatusChangeRegister orderStatusChangeRegister) {
		this.statusChangeHistory.add(orderStatusChangeRegister);
	}
	
	static class SortByDate implements Comparator<OrderStatusChangeRegister> {
	    @Override
	    public int compare(OrderStatusChangeRegister a, OrderStatusChangeRegister b) {
	        return a.getDate().compareTo(b.getDate());
	    }
	}
	
}
