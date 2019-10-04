package com.ericsson.anuncio;

import java.util.List;
import java.util.ListIterator;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnuncioController {

	private List<Anuncio> listaAnuncios = new ArrayList<>();

	@PostConstruct
	public void init() {
		listaAnuncios.add(new Anuncio("Nombre1", "Asunto1", "Comentarios1"));
		listaAnuncios.add(new Anuncio("Nombre2", "Asunto2", "Comentarios2"));
	}

	@GetMapping("/")	
	public String mostrarListaAnuncios(Model model) {	
		model.addAttribute("anuncios", listaAnuncios);
		return "TablonAnuncios_template";
	}


	@GetMapping("/Nuevo")
	public String NuevoAnuncio(Model model, 
		@RequestParam String nombre,
		@RequestParam String asunto,
		@RequestParam String comentarios) {
	
		listaAnuncios.add(new Anuncio(nombre, asunto, comentarios));
		
		model.addAttribute("nombre", nombre);
		model.addAttribute("asunto", asunto);
		model.addAttribute("comentarios", comentarios);

		return "NuevoAnuncio_template";
	}
	
	@GetMapping("/anuncio/{num}")
	public String verAnuncio(Model model, @PathVariable int num) {
		Anuncio anuncio = listaAnuncios.get(num - 1);
		model.addAttribute("anuncio", anuncio);
		return "VerAnuncio_template";
	}
}
