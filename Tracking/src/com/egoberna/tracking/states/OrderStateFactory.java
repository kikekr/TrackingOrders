package com.egoberna.tracking.states;

import com.egoberna.tracking.exceptions.UnknownOrderStateException;

public class OrderStateFactory {

	public static OrderState getOrderState(int orderStateId) throws UnknownOrderStateException {
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
			throw new UnknownOrderStateException(orderStateId);
		}

	}
	
}
