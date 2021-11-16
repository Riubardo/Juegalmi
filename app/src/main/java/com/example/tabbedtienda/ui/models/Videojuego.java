package com.example.tabbedtienda.ui.models;

import java.io.Serializable;

public class Videojuego implements Serializable {
	private int id;
	private String nombreJuego;
	private String descripcion;
	private int pegi;
	private String nombreDesarrolladora;
	private float precioVenta;
	private float precioAlquiler;
	private String urlImagenGoogle;

	public Videojuego(int id, String nombreJuego, String descripcion, int pegi, String nombreDesarrolladora, float precioVenta, float precioAlquiler, String urlImagenGoogle) {
		this.id = id;
		this.nombreJuego = nombreJuego;
		this.descripcion = descripcion;
		this.pegi = pegi;
		this.nombreDesarrolladora = nombreDesarrolladora;
		this.precioVenta = precioVenta;
		this.precioAlquiler = precioAlquiler;
		this.urlImagenGoogle = urlImagenGoogle;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getNombreJuego() { return nombreJuego; }
	public void setNombreJuego(String nombreJuego) { this.nombreJuego = nombreJuego; }

	public String getDescripcion() { return descripcion; }
	public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

	public int getPegi() { return pegi; }
	public void setPegi(int pegi) { this.pegi = pegi; }

	public String getNombreDesarrolladora() { return nombreDesarrolladora; }
	public void setNombreDesarrolladora(String nombreDesarrolladora) { this.nombreDesarrolladora = nombreDesarrolladora; }

	public float getPrecioVenta() { return precioVenta; }
	public void setPrecioVenta(float precioVenta) { this.precioVenta = precioVenta; }

	public float getPrecioAlquiler() { return precioAlquiler; }
	public void setPrecioAlquiler(float precioAlquiler) { this.precioAlquiler = precioAlquiler; }

	public String getUrlImagenGoogle() { return urlImagenGoogle; }
	public void setUrlImagenGoogle(String utlImagenGoogle) { this.urlImagenGoogle = utlImagenGoogle; }
}
