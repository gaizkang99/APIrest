package utils;

public class Constantes {
	
	//Constantes de conexión 
	public static final String DATABASE = "dam2tm03uf6p2";
	public static final String CONNECTION ="jdbc:mysql://localhost:3306/" + DATABASE +"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
	public static final String USER_CONNECTION = "root";
	public static final String PASS_CONNECTION = "DAM1T_M03";
	
	//Queries SQL componentes
	public static final String INSERT_COMPONENTE = "INSERT INTO COMPONENTE (nombre,descripcion) VALUES (?,?)";
	public static final String RECUPERAR_COMPONENTE_ID = "select * from componente where id=?";
	public static final String RECUPERAR_COMPONENTES = "select * from componente";
	public static final String BORRAR_COMPONENTE = "delete from componente where nombre=?";
	
	//Queries SQL juegos
	public static final String INSERT_JUEGO = "insert into juego (nombre,componente) values (?,?)";
	public static final String RECUPERAR_JUEGO_ID = "select * from juego where id=?";
	public static final String RECUPERAR_JUEGOS = "select * from juego";
	public static final String ACTUALIZAR_JUEGO = "update componente set nombre = ?, descripcion = ? where id = ?";
	

			
}
