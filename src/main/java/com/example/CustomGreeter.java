package com.example;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("greeter")
public class CustomGreeter {

    /**
     * This method implements default get endpoint
     * for greet message
     */
    @GET
    @Produces("text/plain")
    @Path("/greet")
    public String getGreetMessage() {
        return "Hello, World!";
    }

    /**
     * This method implements get endpoint to return a custom
     * greet message to caller
     * @param name
     * @return String
     */
    @GET
    @Produces("text/plain")
    @Path("/greet/{name}")
    public String getGreetMessage(@PathParam("name") String name) {
        return "Hello, " + name + ", Welcome to My Custom Greeter app!";
    }

    /**
     * Implements a ping endpoint for the service.
     * This will be called by docker healthcheck.
     * @return Response, 200 if service health is OK.
     */
    @GET
    @Path("/ping")
    public Response ping(){
        return Response.ok().build();
    }
}
