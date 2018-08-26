package model;

public class Refrigeradora extends Articulo {

    private int altura;
    private int numPuertas;

    public Refrigeradora(String modelo, String marca, String categoria, String color, float precio, int stock) {
        super(modelo, marca, categoria, color, precio, stock);
    }

    @Override
    public void setDescripcion() {
        this.descripcion = "altura:" + altura + ", numero de puertas: " + numPuertas + ", color:" + color;
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

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }
}
