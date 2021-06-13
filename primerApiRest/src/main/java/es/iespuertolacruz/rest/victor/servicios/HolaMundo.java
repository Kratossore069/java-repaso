package es.iespuertolacruz.rest.victor.servicios;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;



@Path("/hola-mundo")
public class HolaMundo {

    @GET
    @Path("/{nombre}")
    public Response getMsg(@PathParam("nombre") String msg)
    {
        //String mensajeRecibido=request.getParameter("nombre");
        String output = "Hola " + msg+" tu api rest funciona ";
        return Response.status(200).entity(output).build();
    }


}
