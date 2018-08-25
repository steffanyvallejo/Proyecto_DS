package model;

import java.util.*;

/**
 * 
 */
public class Lavadora extends Articulo{

	private float capacidadCarga;
        private String tipo;

    public Lavadora(String modelo, String marca, String categoria, String color, float precio, int stock) {
        super(modelo, marca, categoria, color, precio, stock);
    }
	

    @Override
    public void setDescripcion() {
       this.descripcion= "Capacidad: "+capacidadCarga+", tipo: "+tipo;
    }

    @Override
    public String getDescripcion() {
       return this.descripcion;
    }

    @Override
    public int getStock() {
        return this.stock;
    }

    @Override
    public float getPrecio() {
        return this.precio;
    }

    public void setCapacidadCarga(float capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}