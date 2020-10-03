package com.egoberna.tracking.tests.status;
import org.junit.Test;

import com.egoberna.tracking.exceptions.InvalidStatusChangeException;
import com.egoberna.tracking.states.EnReparto;
import com.egoberna.tracking.states.Entregado;
import com.egoberna.tracking.states.IncidenciaEnEntrega;
import com.egoberna.tracking.states.OrderState;
import com.egoberna.tracking.states.RecogidoEnAlmacen;

public class IncidenciaEnEntregaStateTest {

	private OrderState getStateInstance() {
		return new IncidenciaEnEntrega();
	}

	@Test(expected = InvalidStatusChangeException.class)
	public void fromIncidenciaEnEntregaToRecodigoEnAlmacen() throws InvalidStatusChangeException {
		getStateInstance().checkStateRestrictions(RecogidoEnAlmacen.ID);
	}
	
	@Test
	public void fromIncidenciaEnEntregaToEnReparto() throws InvalidStatusChangeException {
		getStateInstance().checkStateRestrictions(EnReparto.ID);
	}
	
	@Test
	public void fromIncidenciaEnEntregaToIncidenciaEnEntrega() throws InvalidStatusChangeException {
		getStateInstance().checkStateRestrictions(IncidenciaEnEntrega.ID);
	}
	
	@Test
	public void fromIncidenciaEnEntregaToEntregado() throws InvalidStatusChangeException {
		getStateInstance().checkStateRestrictions(Entregado.ID);
	}
	
}
