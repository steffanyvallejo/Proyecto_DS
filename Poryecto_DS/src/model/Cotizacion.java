package model;

import java.util.*;

/**
 * 
 */
public class Cotizacion extends Responsability {

	
	public Cotizacion(Articulo a, int cantidad) {
            //this.idArticulo=a.idArticulo;
            this.cantArticulo=cantidad;
            
	}

	/**
	 * 
	 */
	private int idArticulo;

	private int cantArticulo;
        public float consultar(Articulo a) {
                System.out.println("Cotizando..");
		return a.precio;
	}

	public double calcularValor() {
		return 0.0d;
	}

	public void setNextResponsability() {
		// TODO implement here
	}

}