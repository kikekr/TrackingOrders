package com.egoberna.tracking.states;

import com.egoberna.tracking.exceptions.InvalidStatusChangeException;

public interface OrderState {
	
	/**
	 * Interface which represents the order states
	 */

	public void checkStateRestrictions(int changeOrderStatusId) throws InvalidStatusChangeException;
	
	/**
	 * Checks that the state change is valid and does not violate any rules
	 * @param changeOrderStatusId: int
	 * @throws InvalidStatusChangeException
	 */	
	
	public int getID();
	
}
