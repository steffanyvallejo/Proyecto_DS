package model;

import java.util.*;

/**
 * 
 */
public interface ArticuloFactoryMethod {

	/**
	 * @return
	 */
	public Articulo crearArticulo(String modelo, String marca, String categoria, String color, float precio, int stock);

}