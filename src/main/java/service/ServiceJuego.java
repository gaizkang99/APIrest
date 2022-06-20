package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoJuego;
import model.Componente;
import model.Juego;

public class ServiceJuego {
	
	private DaoJuego dao;
	
	public ServiceJuego() {
		dao = new DaoJuego();
	}
	
	public void crearJuego(Juego juego) throws SQLException {
		dao.conectar();
		dao.crearJuego(juego.getNombre(), juego.getComponente());
		dao.desconectar();
	}
	
	public Juego idJuego(int id) throws SQLException {
		dao.conectar();
		Juego j = dao.recuperarJuego(id);
		dao.desconectar();
		return j;
	}
	
	public ArrayList<Juego> recuperarTodosJuegos() throws SQLException {
		dao.conectar();
		ArrayList<Juego> juegos = dao.recuperarJuegos();
		dao.desconectar();
		return juegos;
	}
	
	public void actualizarJuego(int id, Componente componente) throws SQLException {
		dao.conectar();
		dao.actualizarJuegoId(id, componente);
		dao.desconectar();		
	}

}
