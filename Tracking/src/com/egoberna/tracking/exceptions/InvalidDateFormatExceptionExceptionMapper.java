package com.egoberna.tracking.exceptions;

import java.time.format.DateTimeParseException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidDateFormatExceptionExceptionMapper implements ExceptionMapper<DateTimeParseException> {

	/**
	 * Class which maps the business logic exceptions to the corresponding HTTP response codes
	 */
	
    @Override
    public Response toResponse(DateTimeParseException exception) {
    	
    	/**
    	 * Maps an DateTimeParseException to HTTP 400 Bad Request
    	 * 
    	 * @param exception: InvalidStatusException
    	 * @return response: javax.ws.rs.core.Response
    	 */
    	
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(exception.getMessage())
                .type( MediaType.TEXT_PLAIN)
                .build();
    }

}
