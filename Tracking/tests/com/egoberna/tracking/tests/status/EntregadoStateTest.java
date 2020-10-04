package com.egoberna.tracking.tests.status;
import org.junit.Test;

import com.egoberna.tracking.exceptions.InvalidStatusChangeException;
import com.egoberna.tracking.states.EnReparto;
import com.egoberna.tracking.states.Entregado;
import com.egoberna.tracking.states.IncidenciaEnEntrega;
import com.egoberna.tracking.states.OrderState;
import com.egoberna.tracking.states.RecogidoEnAlmacen;

public class EntregadoStateTest {

	private OrderState getStateInstance() {
		return new Entregado();
	}

	@Test(expected = InvalidStatusChangeException.class)
	public void fromEntregadoToRecodigoEnAlmacen() throws InvalidStatusChangeException {
		getStateInstance().checkStateRestrictions(RecogidoEnAlmacen.ID);
	}
	
	@Test(expected = InvalidStatusChangeException.class)
	public void fromEntregadoToEnReparto() throws InvalidStatusChangeException {
		getStateInstance().checkStateRestrictions(EnReparto.ID);
	}
	
	@Test(expected = InvalidStatusChangeException.class)
	public void fromEntregadoToIncidenciaEnEntrega() throws InvalidStatusChangeException {
		getStateInstance().checkStateRestrictions(IncidenciaEnEntrega.ID);
	}
	
	@Test(expected = InvalidStatusChangeException.class)
	public void fromEntregadoToEntregado() throws InvalidStatusChangeException {
		getStateInstance().checkStateRestrictions(Entregado.ID);
	}
	
}
