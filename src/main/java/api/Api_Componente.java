package api;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Componente;
import service.ServiceManager;

@Path("/componente")
@Produces("application/json;charset=UTF-8")
@Consumes("application/json;charset=UTF-8")
public class Api_Componente {
	
	private ServiceManager service;
	
	@GET()
	@Path("{id}")
	public Response recuperarComponenteId(@PathParam("id") int id) throws SQLException {
		service = new ServiceManager();
		Componente c = service.getSc().idComponente(id);
		return Response.ok("Has escogido el componente: " + c.toString(), MediaType.APPLICATION_JSON).build();
	}
	
	@GET()
	@Path("/")
	public Response recuperarComponentes() throws SQLException {
		service = new ServiceManager();
		ArrayList<Componente> componentes = service.getSc().recuperarTodosComponentes();
		return Response.ok("Has recuperado estos componentes: " + componentes, MediaType.APPLICATION_JSON).build();
	}
	
	@PUT()
	@Path("/")
	public Response anadirComponente(Componente componente) throws SQLException {
		service = new ServiceManager();
		service.getSc().anadirComponente(componente);
		return Response.ok("Se ha añadido un componente nuevo", MediaType.APPLICATION_JSON).build();
	}
	
	@DELETE()
	@Path("/")
	public Response borrarComponentes(@QueryParam("nombre") String nombre) throws SQLException {
		service = new ServiceManager();
		service.getSc().borrarComponenteByNombre(nombre);
		return Response.ok("Se ha borrado el componente con nombre: " + nombre, MediaType.APPLICATION_JSON).build();
	}
	
	
	
}
