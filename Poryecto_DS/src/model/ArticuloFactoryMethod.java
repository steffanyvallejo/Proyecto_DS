package model;

public interface ArticuloFactoryMethod {

    public Articulo crearArticulo(String modelo, String marca, String categoria, String color, float precio, int stock);
}
