package com.egoberna.tracking.states;

import com.egoberna.tracking.exceptions.InvalidStatusChangeException;

public class EnReparto implements OrderState {
	
	/**
	 * Class which represents the delivery state
	 */
	
	public final static int ID = 2;
	
	public void checkStateRestrictions(int changeOrderStatusId) throws InvalidStatusChangeException {
		/**
		 * Checks that the state change is valid and does not violate any rules
		 * @param changeOrderStatusId: int
		 */
		
		if (changeOrderStatusId == RecogidoEnAlmacen.ID) {
			throw new InvalidStatusChangeException("RECOGIDO EN ALMACEN es un estado inicial, no se "
					+ "puede transitar a este estado desde el resto de estados.");
		}
	}
	
	public String toString() {
		return "EnReparto";
	}

	@Override
	public int getID() {
		return ID;
	}
	
	
 
}
