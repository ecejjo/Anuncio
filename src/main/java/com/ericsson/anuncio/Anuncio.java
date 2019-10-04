package com.ericsson.anuncio;

public class Anuncio {

	String nombre;
	String asunto;
	String comentarios;
	
	public Anuncio(
			String nombre,
			String asunto,
			String comentarios)
	{
		this.nombre = nombre;
		this.asunto = asunto;
		this.comentarios = comentarios;
	}
}
