package com.egoberna.tracking.states;

import com.egoberna.tracking.exceptions.InvalidStatusChangeException;

public class IncidenciaEnEntrega implements OrderState {

	public final static int ID = 3;

	public void checkStateRestrictions(int changeOrderStatusId) throws InvalidStatusChangeException {
		if (changeOrderStatusId == RecogidoEnAlmacen.ID) {
			throw new InvalidStatusChangeException("RECOGIDO EN ALMACEN es un estado inicial, no se "
					+ "puede transitar a este estado desde el resto de estados.");
		}
		
	}

}
