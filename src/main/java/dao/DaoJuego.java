package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Componente;
import model.Juego;
import utils.Constantes;

public class DaoJuego {
	
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
	
	public void crearJuego(String nombre, int componente) throws SQLException{
		try(PreparedStatement ps = conexion.prepareStatement(Constantes.INSERT_JUEGO)){
			ps.setString(1, nombre);
			ps.setInt(2, componente);
			ps.executeUpdate();
		}
	}
	
	public Juego recuperarJuego(int id) throws SQLException {
		Juego juegoID = new Juego();
		try(PreparedStatement ps = conexion.prepareStatement(Constantes.RECUPERAR_JUEGO_ID)){
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					juegoID.setId(rs.getInt("id"));
					juegoID.setNombre(rs.getString("nombre"));
					juegoID.setComponente(rs.getInt("componente"));
				}
			}
		}
		return juegoID;
	}
	
	public ArrayList<Juego> recuperarJuegos() throws SQLException {
		ArrayList<Juego> juegos = new ArrayList<Juego>();
		try(PreparedStatement ps = conexion.prepareStatement(Constantes.RECUPERAR_JUEGOS)){
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Juego juego = new Juego();
					juego.setId(rs.getInt("id"));
					juego.setNombre(rs.getString("nombre"));
					juego.setComponente(rs.getInt("componente"));
					juegos.add(juego);
				}
			}
		}
		return juegos;
	}
	
	public void actualizarJuegoId(int id, Componente componente) throws SQLException{
		int idComponente = 0;
		try (PreparedStatement st = conexion.prepareStatement(Constantes.RECUPERAR_COMPONENTE_ID)){
			st.setInt(1, id);
			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					idComponente = rs.getInt(1);
				}
			}
		 }
		try (PreparedStatement ps = conexion.prepareStatement(Constantes.ACTUALIZAR_JUEGO)) {
			ps.setString(1, componente.getNombre());
			ps.setString(2, componente.getDescripcion());
			ps.setInt(3, idComponente);
			ps.executeUpdate();
		}
	}
	
}
