package com.egoberna.tracking.states;

import com.egoberna.tracking.exceptions.InvalidStatusChangeException;

public class Entregado implements OrderState {

	/**
	 * Class which represents the delivered state
	 */
	
	public static final int ID = 4;
	
	public void checkStateRestrictions(int changeOrderStatusId) throws InvalidStatusChangeException {
		/**
		 * Checks that the state change is valid and does not violate any rules
		 * @param changeOrderStatusId: int
		 */
		
		throw new InvalidStatusChangeException("El estado ENTREGADO es un estado final, una vez un "
				+ "pedido alcance ese estado se descartarán el resto de actualizaciones de "
				+ "seguimiento que recibamos.");	
	}
	
	public String toString() {
		return "Entregado";
	}
	
	@Override
	public int getID() {
		return ID;
	}
}
