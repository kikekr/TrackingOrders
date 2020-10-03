package com.egoberna.tracking;

import java.util.ArrayList;
import java.util.List;

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
    	System.out.println("searchOrderIndex " + orderId);
    	System.out.println(orderList.size());
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
 	
}
