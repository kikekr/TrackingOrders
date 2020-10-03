package com.egoberna.tracking.states;

import com.egoberna.tracking.exceptions.InvalidStatusChangeException;

public interface OrderState {

	public void checkStateRestrictions(int changeOrderStatusId) throws InvalidStatusChangeException;
		
}
