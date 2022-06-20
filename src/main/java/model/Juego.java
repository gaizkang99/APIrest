package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Juego {
	
	@JsonProperty("id")
	private int id;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("componente")
	private int componente;
	
	public Juego(){}
	
	public Juego(@JsonProperty("id") int id,@JsonProperty("nombre") String nombre,@JsonProperty("componente") int componente) {
		this.id = id;
		this.nombre = nombre;
		this.componente = componente;
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

	@JsonProperty("componente")
	public int getComponente() {
		return componente;
	}

	@JsonProperty("componente")
	public void setComponente(int componente) {
		this.componente = componente;
	}

	@Override
	public String toString() {
		return "Juego [id=" + id + ", nombre=" + nombre + ", componente=" + componente + "]";
	}
	
	
	
	

}
