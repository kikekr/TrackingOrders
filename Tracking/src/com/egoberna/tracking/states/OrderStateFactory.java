package com.egoberna.tracking.states;

import com.egoberna.tracking.exceptions.UnknownOrderStatusException;

public class OrderStateFactory {
	
	/**
	 * Class which represents a factory method to instantiate OrderStates by ID.
	 */

	public static OrderState getOrderState(int orderStateId) throws UnknownOrderStatusException {
		
		/**
		 * Returns a concrete instance of OrderState by ID
		 * @param orderStateId: int
		 * @return OrderState
		 * @throws UnknownOrderStatusException
		 */
		
		if (orderStateId == RecogidoEnAlmacen.ID) {
			return new RecogidoEnAlmacen();
		}
		else if (orderStateId == EnReparto.ID) {
			return new EnReparto();
		}
		else if (orderStateId == IncidenciaEnEntrega.ID) {
			return new IncidenciaEnEntrega();
		}
		else if (orderStateId == Entregado.ID) {
			return new Entregado();
		}
		else {
			throw new UnknownOrderStatusException(orderStateId);
		}

	}
	
}
