package com.egoberna.tracking;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement; 

@XmlRootElement(name="OrderStatusChange")
public class OrderStatusChange {
	
    @XmlAttribute
	private String orderId;
	
}
