package com.egoberna.tracking.tests.status;
import org.junit.Test;

import com.egoberna.tracking.exceptions.InvalidStatusChangeException;
import com.egoberna.tracking.states.EnReparto;
import com.egoberna.tracking.states.Entregado;
import com.egoberna.tracking.states.IncidenciaEnEntrega;
import com.egoberna.tracking.states.OrderState;
import com.egoberna.tracking.states.RecogidoEnAlmacen;

public class RecogidoEnAlmacenStateTest {
	
	private OrderState getStateInstance() {
		return new RecogidoEnAlmacen();
	}
	
	@Test
	public void fromRecogidoEnAlmacenToRecodigoEnAlmacen() throws InvalidStatusChangeException {
		getStateInstance().checkStateRestrictions(RecogidoEnAlmacen.ID);
	}
	
	@Test
	public void fromRecogidoEnAlmacenToEnReparto() throws InvalidStatusChangeException {
		getStateInstance().checkStateRestrictions(EnReparto.ID);
	}
	
	@Test
	public void fromRecogidoEnAlmacenToIncidenciaEnEntrega() throws InvalidStatusChangeException {
		getStateInstance().checkStateRestrictions(IncidenciaEnEntrega.ID);
	}
	
	@Test
	public void fromRecogidoEnAlmacenToEntregado() throws InvalidStatusChangeException {
		getStateInstance().checkStateRestrictions(Entregado.ID);
	}
	
}
