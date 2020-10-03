package com.egoberna.tracking;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement; 

@XmlRootElement(name="orderTracking")
public class OrderStatusChange {
	
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

//	public String getOrderId() {
//		return this.orderId;
//	}
//
//	public void setOrderId(String orderId) {
//		this.orderId = orderId;
//	}
//	
    
	
	
    
}
