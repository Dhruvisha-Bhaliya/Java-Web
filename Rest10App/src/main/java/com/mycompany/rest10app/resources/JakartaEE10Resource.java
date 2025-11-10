package com.mycompany.rest10app.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author
 */
@Path("rest")
public class JakartaEE10Resource {

    @GET
    public Response ping() {
        return Response
                .ok("ping Jakarta EE")
                .build();
    }

    @GET
    @Path("special/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response saySpecialHello(@PathParam("name") String name) {
        return Response
                .ok("🌟 Hello, " + name + "! Welcome to Jakarta EE 10 REST API.")
                .build();
    }
}
