package com.intern.employeesCrudAPI.exception;

import com.intern.employeesCrudAPI.enums.Status;
import com.intern.employeesCrudAPI.payload.ApiResponse;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<ResourceNotFoundException> {

    @Override
    public Response toResponse(ResourceNotFoundException exception) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponse(exception.getMessage(), Status.FAIL)).build();
    }
}
