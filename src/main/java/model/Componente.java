package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Componente {
	
	@JsonProperty("id")
	private int id;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("descripcion")
	private String descripcion;
	
	public Componente() {}

	@JsonCreator
	public Componente(@JsonProperty("id") int id, @JsonProperty("nombre") String nombre, @JsonProperty("descripcion") String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	@JsonProperty("id")
	public int getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty("nombre")
	public String getNombre() {
		return nombre;
	}

	@JsonProperty("nombre")
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonProperty("descripcion")
	public String getDescripcion() {
		return descripcion;
	}

	@JsonProperty("descripcion")
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Componente [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
	
	

}
