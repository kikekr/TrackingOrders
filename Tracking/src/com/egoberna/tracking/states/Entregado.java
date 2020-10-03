package com.egoberna.tracking.states;

import com.egoberna.tracking.InvalidStatusChangeException;
import com.egoberna.tracking.OrderState;

public class Entregado implements OrderState {

	public static final int ID = 4;
	
	public void checkStateRestrictions(int changeOrderStatusId) throws InvalidStatusChangeException {
		throw new InvalidStatusChangeException("El estado ENTREGADO es un estado final, una vez un "
				+ "pedido alcance ese estado se descartarán el resto de actualizaciones de "
				+ "seguimiento que recibamos.");	
	}
}
