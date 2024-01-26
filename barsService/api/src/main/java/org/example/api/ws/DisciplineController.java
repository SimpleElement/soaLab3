package org.example.api.ws;



import com.orbitz.consul.Consul;
import com.orbitz.consul.model.agent.ImmutableRegistration;
import org.example.remote.dto.DisciplineDto;
import org.example.remote.DisciplineService;
import org.example.remote.ResponseRemote;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/v1/discipline")
@Produces(MediaType.APPLICATION_JSON)
public class DisciplineController {

    @EJB
    private DisciplineService disciplineService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDiscipline(DisciplineDto discipline) {
        ResponseRemote response = (ResponseRemote) disciplineService.createDiscipline(discipline);

        return Response.status(response.getStatus()).entity(response.getMessage()).build();
    }

    @GET
    public Response getAllDiscipline(@QueryParam("name") String name, @QueryParam("pageNumber") Integer pageNumber, @QueryParam("pageSize") Integer pageSize) throws NamingException {
        ResponseRemote response = (ResponseRemote) disciplineService.getAllDiscipline(name, pageNumber, pageSize);

        return Response.status(response.getStatus()).entity(response.getMessage()).build();
    }

    @GET
    @Path("{id}/lab")
    public Response getAllLab(@PathParam("id") Long id, @QueryParam("pageNumber") Integer pageNumber, @QueryParam("pageSize") Integer pageSize) {
        ResponseRemote response = (ResponseRemote) disciplineService.getAllLab(id, pageNumber, pageSize);

        return Response.status(response.getStatus()).entity(response.getMessage()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDisciplineById(@PathParam("id") Long id) {
        ResponseRemote response = (ResponseRemote) disciplineService.deleteDisciplineById(id);

        return Response.status(response.getStatus()).entity(response.getMessage()).build();
    }

    @POST
    @Path("/{disciplineId}/labwork/{labId}/add")
    public Response addLabToDiscipline(@PathParam("disciplineId") Long disciplineId, @PathParam("labId") Long labId) {
        ResponseRemote response = (ResponseRemote) disciplineService.addLabToDiscipline(disciplineId, labId);

        return Response.status(response.getStatus()).entity(response.getMessage()).build();
    }


    @DELETE
    @Path("/{disciplineId}/labwork/{labId}/remove")
    public Response removeLabToDiscipline(@PathParam("disciplineId") Long disciplineId, @PathParam("labId") Long labId) {
        ResponseRemote response = (ResponseRemote) disciplineService.removeLabToDiscipline(disciplineId, labId);

        return Response.status(response.getStatus()).entity(response.getMessage()).build();
    }
}
