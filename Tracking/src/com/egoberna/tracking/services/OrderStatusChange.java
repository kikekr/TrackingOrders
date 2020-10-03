package com.egoberna.tracking.services;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement; 

@XmlRootElement(name="orderTracking")
public class OrderStatusChange {
	
	/**
	 * Class which represents an order status change register request received from the web service
	 */
	
    @XmlElement(name="orderId")
    public String orderId;
    
    @XmlElement(name="trackingStatusId")
    public String trackingStatusId;
    
    @XmlElement(name="changeStatusDate")
    public String changeStatusDate;
    
    public OrderStatusChange( ) {}

	@Override
	public String toString() {
		return "OrderStatusChange [orderId=" + orderId + ", trackingStatusId=" + trackingStatusId
				+ ", changeStatusDate=" + changeStatusDate + "]";
	}

}
