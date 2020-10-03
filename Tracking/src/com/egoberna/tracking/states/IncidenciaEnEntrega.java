package com.egoberna.tracking.states;

import com.egoberna.tracking.exceptions.InvalidStatusChangeException;

public class IncidenciaEnEntrega implements OrderState {

	/**
	 * Class which represents the incidence state
	 */
	
	public final static int ID = 3;

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
		return "IncidenciaEnEntrega";
	}
	
	@Override
	public int getID() {
		return ID;
	}

}
