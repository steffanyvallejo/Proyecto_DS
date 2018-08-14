package model;

import java.util.*;

/**
 * 
 */
public class Credito extends Pago implements PagoStrategy{

	/**
	 * Default constructor
	 */
	public Credito() {
	}

	/**
	 * 
	 */
	private long numeroTarjetaCredito;

	/**
	 * 
	 */
	private Date fechaDeExpedicion;

	/**
	 * 
	 */
	private String nombre;

	/**
	 * @param double total 
	 * @return
	 */
	private boolean realizarCargo(double total) {
		// TODO implement here
		return false;
	}

	/**
	 * 
	 */
	public void pagar() {
		// TODO implement here
	}


}