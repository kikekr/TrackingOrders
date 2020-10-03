package com.egoberna.tracking;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/tracking")
@Consumes(MediaType.APPLICATION_XML)
public class Tracking {
	
	public static final String TAG = "Tracking";
	private OrderDataService orderDataService = OrderDataService.getInstance();
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String processOrderStatusChangeList(List<OrderStatusChange> orderStatusChangeList) throws InvalidStatusChangeException, UnknownOrderStateException {
		for (int i =0; i < orderStatusChangeList.size(); i++) {
			OrderStatusChange orderStatusChange = orderStatusChangeList.get(i);
			int orderId = Integer.parseInt(orderStatusChange.orderId);
			int changeStatusId = Integer.parseInt(orderStatusChange.trackingStatusId);
			Order order = orderDataService.searchOrder(orderId);
			if (order == null) {
				order = new Order(orderId);
				orderDataService.addOrder(order);
			}
			order.checkStateRestrictions(changeStatusId);
			order.setState(OrderStateFactory.getOrderState(changeStatusId));
			System.out.println("New state: " + order.getState());
			orderDataService.updateOrder(order);
		}
		return "List size: " + orderStatusChangeList.size();
	}
}

