package model;

import java.util.*;

/**
 * 
 */
public class Efectivo extends Pago implements PagoStrategy {

	/**
	 * Default constructor
	 */
	public Efectivo() {
	}

	/**
	 * 
	 */
	private double cantidad;

	/**
	 * 
	 */
	public void pagar() {
		// TODO implement here
                System.out.println("Pagando en efectivo...");
	}


}