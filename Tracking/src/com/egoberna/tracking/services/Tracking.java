package com.egoberna.tracking.services;

import java.time.ZonedDateTime;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.egoberna.tracking.exceptions.InvalidStatusException;
import com.egoberna.tracking.models.Order;
import com.egoberna.tracking.models.OrderDataService;

@Path("/tracking")
@Consumes(MediaType.APPLICATION_XML)
public class Tracking {
	
	/**
	 * Class which represents the tracking order endpoint
	 */
	
	public static final String TAG = "Tracking";
	private OrderDataService orderDataService = OrderDataService.getInstance();
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_XML)
	public String onPostReceived(List<OrderStatusChange> orderStatusChangeList) throws 
		InvalidStatusException {
		
		/**
		 * Receives the HTTP Request, process the data and returns the appropiated HTTP response.
		 * @param: orderStatusChangeList: List<OrderStatusChange>
		 */
		
		processOrderStatusChangeList(orderStatusChangeList);
	    return "<?xml version=\"1.0\"?>" + "<tracking> Operation completed successfully" + "</tracking>";
	}
	
	private void processOrderStatusChangeList(List<OrderStatusChange> orderStatusChangeList) 
			throws InvalidStatusException {
		
		/**
		 * Process an order status change request and returns the appropiated HTTP response.
		 * @param: orderStatusChangeList: List<OrderStatusChange>
		 * @return String
		 */
		
		
		for (int i =0; i < orderStatusChangeList.size(); i++) {
			OrderStatusChange orderStatusChange = orderStatusChangeList.get(i);
			
			// Parse order status change parameters
			int changeStatusId = Integer.parseInt(orderStatusChange.trackingStatusId);
			int orderId = Integer.parseInt(orderStatusChange.orderId);
			ZonedDateTime zonedDateTime = ZonedDateTime.parse(orderStatusChange.changeStatusDate);
			
			// Get or create order
			Order order = orderDataService.getOrCreateOrder(orderId, changeStatusId);
			
			// Change the order status
			order.changeStatus(zonedDateTime, changeStatusId);
			
			// Update order
			orderDataService.updateOrder(order);			
		}

	}
	
}

