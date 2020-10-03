package com.egoberna.tracking;

import java.util.ArrayList;
import java.util.List;

import com.egoberna.tracking.states.RecogidoEnAlmacen;

public class OrderDataService {

    private List<Order> orderList = new ArrayList<>();
    
    private static OrderDataService ourInstance = new OrderDataService();

    public static OrderDataService getInstance() {
        return ourInstance;
    }

    public void addOrder(Order order) {
    	orderList.add(order);
    }
   
    private int searchOrderIndex(int orderId) {
    	for (int i = 0; i < orderList.size(); i++) {
    		if (orderList.get(i).getOrderId() == orderId) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    public Order searchOrder(int orderId) {
    	for (int i = 0; i < orderList.size(); i++) {
    		if (orderList.get(i).getOrderId() == orderId) {
    			return orderList.get(i);
    		}
    	}
    	return null;
    }
    
    public void updateOrder(Order order) {
    	int index = searchOrderIndex(order.getOrderId());
    	if (index != -1) {
        	orderList.set(index, order);
    	}
    }
    
	public Order getOrCreateOrder(int orderId, int trackingStatusId) throws InvalidStatusException {
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
