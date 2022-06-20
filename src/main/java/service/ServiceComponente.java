package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoComponente;
import model.Componente;

public class ServiceComponente {
	
	private DaoComponente dao;
	
	public ServiceComponente() {
		dao = new DaoComponente();
	}
	
	public void anadirComponente(Componente componente) throws SQLException {
			dao.conectar();
			dao.insertarComponente(componente.getNombre(), componente.getDescripcion());
			dao.desconectar();
		
	}
	
	public Componente idComponente(int id) throws SQLException {
		dao.conectar();
		Componente compID = dao.recuperarComponente(id);
		dao.desconectar();
		return compID;
	}
	
	public ArrayList<Componente> recuperarTodosComponentes() throws SQLException{
		dao.conectar();
		ArrayList<Componente> componentes = dao.recuperarComponentes();
		dao.desconectar();
		return componentes;
	}
	
	public void borrarComponenteByNombre(String nombre) throws SQLException {
		dao.conectar();
		dao.borrarComponente(nombre);
		dao.desconectar();
	}
	
	
	
	

}
