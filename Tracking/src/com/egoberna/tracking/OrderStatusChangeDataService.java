package com.egoberna.tracking;

import java.util.ArrayList;
import java.util.List;

public class OrderStatusChangeDataService {

    private List<OrderStatusChange> orderStatusChangeList = new ArrayList<>();
    
    private static OrderStatusChangeDataService ourInstance = new OrderStatusChangeDataService();

    public static OrderStatusChangeDataService getInstance() {
        return ourInstance;
    }

    public void addOrderStatusChange(OrderStatusChange orderStatusChange) {
    	orderStatusChangeList.add(orderStatusChange);
    }
}
