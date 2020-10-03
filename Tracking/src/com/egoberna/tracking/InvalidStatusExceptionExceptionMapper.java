package com.egoberna.tracking;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidStatusExceptionExceptionMapper implements ExceptionMapper<InvalidStatusException>
{

    @Override
    public Response toResponse(InvalidStatusException exception)
    {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(exception.getMessage())
                .type( MediaType.TEXT_PLAIN)
                .build();
    }

}
