package model;

import java.util.*;

/**
 * 
 */
public class CocinaInduccion extends Articulo {
    private int numHornillas;
    private boolean tieneHorno;

    public CocinaInduccion(String modelo, String marca, String categoria, String color, float precio, int stock) {
        super(modelo, marca, categoria, color, precio, stock);
    }

    
    
    
    @Override
    public void setDescripcion() {
        this.descripcion= "Numero de hornillas: "+numHornillas+", tiene horno: "+tieneHorno;
    }

    @Override
    public String getDescripcion() {
        return this.descripcion;
    }

    @Override
    public int getStock() {
        return this.stock;    }

    @Override
    public float getPrecio() {
        return this.precio;
    }

    public void setNumHornillas(int numHornillas) {
        this.numHornillas = numHornillas;
    }

    public void setTieneHorno(boolean tieneHorno) {
        this.tieneHorno = tieneHorno;
    }


}