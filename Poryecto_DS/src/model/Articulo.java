package model;

/**
 *
 */
public abstract class Articulo {

    protected String modelo;
    protected String descripcion;
    protected String categoria;
    protected int stock;
    protected float precio;
    protected String marca;
    protected String color;

    public Articulo(String modelo, String marca, String categoria, String color, float precio, int stock) {
        this.modelo = modelo;
        this.categoria = categoria;
        this.stock = stock;
        this.precio = precio;
        this.marca = marca;
        this.color = color;
    }

    public abstract void setDescripcion();
     public abstract String gettDescripcion();
    public abstract int getStock();
    public abstract float getPrecio();
    

}
