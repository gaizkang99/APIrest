package api;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Componente;
import model.Juego;
import service.ServiceManager;

@Path("/juego")
@Produces("application/json;charset=UTF-8")
@Consumes("application/json;charset=UTF-8")
public class Api_Juego {

	private ServiceManager service;
	
	@PUT()
	@Path("/")
	public Response anadirJuego(Juego juego) throws SQLException {
		service = new ServiceManager();
		service.getSj().crearJuego(juego);
		return Response.ok("Se ha añadido un juego nuevo", MediaType.APPLICATION_JSON).build();
	}
	
	@GET()
	@Path("{id}")
	public Response recuperarJuegoId(@PathParam("id") int id) throws SQLException {
		service = new ServiceManager();
		Juego j = service.getSj().idJuego(id);
		return Response.ok("Has escogido el componente: " + j.toString(), MediaType.APPLICATION_JSON).build();
	}
	
	@GET()
	@Path("/")
	public Response recuperarJuegos() throws SQLException {
		service = new ServiceManager();
		ArrayList<Juego> juegos = service.getSj().recuperarTodosJuegos();
		return Response.ok("Has recuperado estos componentes: " + juegos, MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Path("{id}")
	public Response actualizarJuegoId(@PathParam("id") int id, Componente componente) throws SQLException {
		service = new ServiceManager();
		service.getSj().actualizarJuego(id, componente);
		return Response.ok("El juego se ha actualizado", MediaType.APPLICATION_JSON).build();
	}
	
	
}
