package com.egoberna.tracking.states;

public class RecogidoEnAlmacen implements OrderState {

	public static final int ID = 1;
	
	/**
	 * Class which represents the ready to deliver state
	 */
	
	public void checkStateRestrictions(int changeOrderStatusId) {
		
		/**
		 * Checks that the state change is valid and does not violate any rules
		 * @param changeOrderStatusId: int
		 * @throws InvalidStatusChangeException
		 */	
		
		// Nothing to do
		
	}

	public String toString() {
		return "RecogidoEnAlmacén";
	}
	
	@Override
	public int getID() {
		return ID;
	}
}
