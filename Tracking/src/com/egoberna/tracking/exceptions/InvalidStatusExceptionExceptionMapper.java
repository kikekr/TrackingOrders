package com.egoberna.tracking.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidStatusExceptionExceptionMapper implements ExceptionMapper<InvalidStatusException> {

	/**
	 * Class which maps the business logic exceptions to the corresponding HTTP response codes
	 */
	
    @Override
    public Response toResponse(InvalidStatusException exception) {
    	
    	/**
    	 * Maps an InvalidStatusException to HTTP 400 Bad Request
    	 * 
    	 * @param exception: InvalidStatusException
    	 * @return response: javax.ws.rs.core.Response
    	 */
    	
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(exception.getMessage())
                .type( MediaType.TEXT_XML)
                .build();
    }

}
