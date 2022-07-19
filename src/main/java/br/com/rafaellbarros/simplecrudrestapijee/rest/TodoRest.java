package br.com.rafaellbarros.simplecrudrestapijee.rest;

import br.com.rafaellbarros.simplecrudrestapijee.model.entity.Todo;
import br.com.rafaellbarros.simplecrudrestapijee.service.TodoService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * created by:
 *
 * @author rafael barros for DevDusCorre <rafaelbarros.softwareengineer@gmail.com> on 19/07/2022
 */

@RequestScoped
@Path("v2/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoRest {

    @Inject
    private TodoService todoService;

    @GET
    @Path("{id}")
    public Response getTodo(@PathParam("id") final Long id) {
        return Response.ok(todoService.findById(id)).build();
    }

    @GET
    public Response getAll() {
        return Response.ok(todoService.getAll()).build();
    }

    @POST
    public Response create(final Todo todo) {
        return Response.ok(todoService.create(todo)).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") final Long id, final Todo todo) {
        return Response.ok(todoService.update(id, todo)).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        todoService.delete(id);
        return Response.noContent().build();
    }

}
