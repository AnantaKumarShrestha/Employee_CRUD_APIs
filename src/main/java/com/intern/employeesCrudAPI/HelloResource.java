package com.intern.employeesCrudAPI;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("text/plain")
    @Path("/hello")
    public String hello() {
        return "Hello hell, World!";
    }

    @GET
    @Produces("text/plain")
    @Path("/helloo")
    public String hello1() {
        return "Hello , World!";
    }

}