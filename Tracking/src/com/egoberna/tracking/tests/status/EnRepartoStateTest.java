package com.egoberna.tracking.tests.status;
import org.junit.Test;

import com.egoberna.tracking.exceptions.InvalidStatusChangeException;
import com.egoberna.tracking.states.EnReparto;
import com.egoberna.tracking.states.Entregado;
import com.egoberna.tracking.states.IncidenciaEnEntrega;
import com.egoberna.tracking.states.OrderState;
import com.egoberna.tracking.states.RecogidoEnAlmacen;

public class EnRepartoStateTest {
	
	private OrderState getStateInstance() {
		return new EnReparto();
	}

	@Test(expected = InvalidStatusChangeException.class)
	public void fromEnRepartoToRecodigoEnAlmacen() throws InvalidStatusChangeException {
		getStateInstance().checkStateRestrictions(RecogidoEnAlmacen.ID);
	}
	
	@Test
	public void fromEnRepartoToEnReparto() throws InvalidStatusChangeException {
		getStateInstance().checkStateRestrictions(EnReparto.ID);
	}
	
	@Test
	public void fromEnRepartoToIncidenciaEnEntrega() throws InvalidStatusChangeException {
		getStateInstance().checkStateRestrictions(IncidenciaEnEntrega.ID);
	}
	
	@Test
	public void fromEnRepartoToEntregado() throws InvalidStatusChangeException {
		getStateInstance().checkStateRestrictions(Entregado.ID);
	}
	
}
