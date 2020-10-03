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
    
    public Order searchOrder(int orderId) {
    	for (int i = 0; i < orderList.size(); i++) {
    		if (orderList.get(i).getOrderId() == orderId) {
    			return orderList.get(i);
    		}
    	}
    	return null;
    }
 	
}
