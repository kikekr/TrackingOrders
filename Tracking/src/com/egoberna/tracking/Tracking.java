package com.egoberna.tracking;

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

	  @POST
	  @Consumes(MediaType.APPLICATION_XML)
	  @Produces(MediaType.TEXT_PLAIN)
	  public String sayPlainTextHello(OrderStatusChange s) {
		System.out.println(s);
	    return "Hello Jersey";
	  }
	
}
