package com.egoberna.tracking.tests.orders;

import java.time.ZonedDateTime;

import org.junit.Test;

import com.egoberna.tracking.exceptions.InvalidStatusException;
import com.egoberna.tracking.models.Order;
import com.egoberna.tracking.states.EnReparto;
import com.egoberna.tracking.states.Entregado;
import com.egoberna.tracking.states.IncidenciaEnEntrega;
import com.egoberna.tracking.states.RecogidoEnAlmacen;

public class OrderStatusTest {
	
	@Test
	public void testBasicStatusChange() throws InvalidStatusException {
		Order order = new Order(0);
		order.changeStatus(ZonedDateTime.parse("2019-01-27T07:17:23.108+00:00"), RecogidoEnAlmacen.ID);
		order.changeStatus(ZonedDateTime.parse("2019-01-27T08:17:23.108+00:00"), EnReparto.ID);
		order.changeStatus(ZonedDateTime.parse("2019-01-27T09:17:23.108+00:00"), IncidenciaEnEntrega.ID);
		order.changeStatus(ZonedDateTime.parse("2019-01-27T10:17:23.108+00:00"), Entregado.ID);
	}
	
	@Test
	public void testDisorderedStatusChange() throws InvalidStatusException {
		Order order = new Order(0);
		order.changeStatus(ZonedDateTime.parse("2019-01-27T07:17:23.108+00:00"), RecogidoEnAlmacen.ID);
		order.changeStatus(ZonedDateTime.parse("2019-01-27T10:17:23.108+00:00"), Entregado.ID);
		order.changeStatus(ZonedDateTime.parse("2019-01-27T09:17:23.108+00:00"), IncidenciaEnEntrega.ID);
		order.changeStatus(ZonedDateTime.parse("2019-01-27T08:17:23.108+00:00"), EnReparto.ID);
	}
	
	@Test()
	public void testDisplacedStatusChange1() throws InvalidStatusException {
		Order order = new Order(0);
		order.changeStatus(ZonedDateTime.parse("2019-01-27T07:17:23.108+00:00"), RecogidoEnAlmacen.ID);
		order.changeStatus(ZonedDateTime.parse("2019-01-27T10:17:23.108+00:00"), EnReparto.ID);
		order.changeStatus(ZonedDateTime.parse("2019-01-27T08:17:23.108+00:00"), RecogidoEnAlmacen.ID);
		order.changeStatus(ZonedDateTime.parse("2019-01-27T11:17:23.108+00:00"), EnReparto.ID);
	}
	
	@Test(expected=InvalidStatusException.class)
	public void testDisplacedStatusChange2() throws InvalidStatusException {
		Order order = new Order(0);
		order.changeStatus(ZonedDateTime.parse("2019-01-27T07:17:23.108+00:00"), RecogidoEnAlmacen.ID);
		order.changeStatus(ZonedDateTime.parse("2019-01-27T10:17:23.108+00:00"), EnReparto.ID);
		order.changeStatus(ZonedDateTime.parse("2019-01-27T08:17:23.108+00:00"), Entregado.ID);

	}
//	
}
