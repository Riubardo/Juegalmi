package com.example.tabbedtienda.ui.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Plataforma implements Serializable{

	private int id;
	private String nombre;
	private ArrayList<Videojuego> listaJuegos;

	public Plataforma(int id, String nombre, ArrayList<Videojuego> listaJuegos){
		this.id = id;
		this.nombre = nombre;
		this.listaJuegos = listaJuegos;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public ArrayList<Videojuego> getListaVideojuegos() { return listaJuegos; }
	public void setListaVideojuegos(ArrayList<Videojuego> listaJuegos) { this.listaJuegos = listaJuegos; }
}
