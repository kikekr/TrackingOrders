package com.egoberna.tracking.states;

import com.egoberna.tracking.InvalidStatusChangeException;
import com.egoberna.tracking.OrderState;

public class EnReparto implements OrderState {
	
	public final static int ID = 2;
	
	public void checkStateRestrictions(int changeOrderStatusId) throws InvalidStatusChangeException {
		if (changeOrderStatusId == RecogidoEnAlmacen.ID) {
			throw new InvalidStatusChangeException("RECOGIDO EN ALMACEN es un estado inicial, no se "
					+ "puede transitar a este estado desde el resto de estados.");
		}
	}

}
