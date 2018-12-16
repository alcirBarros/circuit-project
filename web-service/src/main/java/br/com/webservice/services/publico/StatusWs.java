package br.com.webservice.services.publico;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Component;

@Component
@Path("status")
public class StatusWs {

    @GET
    @Path("/get")
    @Produces({MediaType.APPLICATION_JSON})
    public Response status() {
        return Response.status(200).build();
    }

    @GET
    @Path("/{parameter}")
    public Response responseMsg(@PathParam("parameter") String parameter, @DefaultValue("Nothing to say") @QueryParam("value") String value) {
        String output = "Hello from: " + parameter + " : " + value;
        return Response.status(200).entity(output).build();

    }
}
