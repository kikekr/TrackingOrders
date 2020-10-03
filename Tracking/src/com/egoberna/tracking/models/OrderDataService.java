package com.egoberna.tracking.models;

import java.util.ArrayList;
import java.util.List;

import com.egoberna.tracking.exceptions.InvalidStatusException;
import com.egoberna.tracking.states.RecogidoEnAlmacen;

public class OrderDataService {
	
	/**
	 * Class which helps to manage orders data. It could be replaced by a persistent storage.
	 */

    private List<Order> orderList = new ArrayList<>();
    private static OrderDataService ourInstance = new OrderDataService();

    public static OrderDataService getInstance() {
    	/**
    	 * Returns an instance of OrderDataService
    	 * @return OrderDataService
    	 */
    	
        return ourInstance;
    }

    public void addOrder(Order order) {
    	/**
    	 * Adds an order
    	 * @param order: Order
    	 */
    	
    	orderList.add(order);
    }
   
    private int searchOrderIndex(int orderId) {
    	/**
    	 * Searches an order by ID and returns the index
    	 * @param orderId: int
    	 * @return int
    	 */
    	
    	for (int i = 0; i < orderList.size(); i++) {
    		if (orderList.get(i).getOrderId() == orderId) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    public Order searchOrder(int orderId) {
       	/**
    	 * Searches an order by ID
    	 * @param orderId: int
    	 * @return Order
    	 */
    	
    	for (int i = 0; i < orderList.size(); i++) {
    		if (orderList.get(i).getOrderId() == orderId) {
    			return orderList.get(i);
    		}
    	}
    	return null;
    }
    
    public void updateOrder(Order order) {
       	/**
    	 * Updates an order
    	 * @param order: Order
    	 */
    	
    	int index = searchOrderIndex(order.getOrderId());
    	if (index != -1) {
        	orderList.set(index, order);
    	}
    }
    
	public Order getOrCreateOrder(int orderId, int trackingStatusId) throws InvalidStatusException {
       	/**
    	 * Get an order or create it if it does not exist
    	 * @param orderId: int
    	 * @param trackingStatusId: int
    	 */
		
		Order order = searchOrder(orderId);
		if (order == null) {
			if (trackingStatusId != RecogidoEnAlmacen.ID)
				throw new InvalidStatusException("El estado inicial debe ser RECOGIDO EN ALMACÉN");
			order = new Order(orderId);
			addOrder(order);
		}
		return order;
	}
 	
}
