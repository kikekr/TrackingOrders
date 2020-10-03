package com.egoberna.tracking;

public interface OrderState {

	public void checkStateRestrictions(int changeOrderStatusId) throws InvalidStatusChangeException;
		
}
