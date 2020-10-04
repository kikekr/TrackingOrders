package com.egoberna.tracking.tests.orders;

import static org.junit.Assert.assertEquals;

import java.time.ZonedDateTime;

import org.junit.Test;

import com.egoberna.tracking.exceptions.UnknownOrderStatusException;
import com.egoberna.tracking.models.Order;
import com.egoberna.tracking.models.OrderStatusChangeRegister;
import com.egoberna.tracking.states.EnReparto;
import com.egoberna.tracking.states.OrderStateFactory;
import com.egoberna.tracking.states.RecogidoEnAlmacen;

public class OrderTest {
	
	@Test
	public void getStateAtTest() throws UnknownOrderStatusException {
		
		Order order = new Order(0);
		
		OrderStatusChangeRegister enRepartoChangeRegister = new OrderStatusChangeRegister();
		enRepartoChangeRegister.setDate(ZonedDateTime.parse("2019-01-25T07:17:23.108+00:00"));
		enRepartoChangeRegister.setState(OrderStateFactory.getOrderState(EnReparto.ID));
		enRepartoChangeRegister.setOrder(order);
		order.addStatusChangeRegister(enRepartoChangeRegister);
		
		assertEquals(order.getStateAt(ZonedDateTime.parse("2019-01-23T07:17:23.108+00:00")), null);

		
		
	}
	
}
