package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Componente;
import utils.Constantes;

public class DaoComponente {
	
	private Connection conexion;
	
	public void conectar() throws SQLException {
			String url = Constantes.CONNECTION;
			String usuario = Constantes.USER_CONNECTION;
			String contrasena = Constantes.PASS_CONNECTION;
			//Conexion
			conexion = DriverManager.getConnection(url, usuario, contrasena);
	}
	
	public void desconectar() throws SQLException {
		if(conexion != null) {
				conexion.close();
		}
	}
	
	public void insertarComponente(String name, String description) throws SQLException{
		try(PreparedStatement ps = conexion.prepareStatement(Constantes.INSERT_COMPONENTE)){
			ps.setString(1, name);
			ps.setString(2, description);
			ps.executeUpdate();
		}
	}
	
	public Componente recuperarComponente(int id) throws SQLException {
		Componente componenteID = new Componente();
		try(PreparedStatement ps = conexion.prepareStatement(Constantes.RECUPERAR_COMPONENTE_ID)){
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					componenteID.setId(rs.getInt("id"));
					componenteID.setNombre(rs.getString("nombre"));
					componenteID.setDescripcion(rs.getString("descripcion"));
				}
			}
		}
		return componenteID;
	}
	
	public ArrayList<Componente> recuperarComponentes() throws SQLException {
		ArrayList<Componente> componentes = new ArrayList<Componente>();
		try(PreparedStatement ps = conexion.prepareStatement(Constantes.RECUPERAR_COMPONENTES)){
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Componente componente = new Componente();
					componente.setId(rs.getInt("id"));
					componente.setNombre(rs.getString("nombre"));
					componente.setDescripcion(rs.getString("descripcion"));
					componentes.add(componente);
				}
			}
		}
		return componentes;
	}
	
	public void borrarComponente(String nombre) throws SQLException {
		try(PreparedStatement ps = conexion.prepareStatement(Constantes.BORRAR_COMPONENTE)){
			ps.setString(1, nombre);
			ps.executeUpdate();
		}
	}
	
	
 	

}
