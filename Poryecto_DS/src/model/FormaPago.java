package model;

import java.util.*;

/**
 * 
 */
public class FormaPago {

	/**
	 * Default constructor
	 */
	public FormaPago() {
	}

	/**
	 * 
	 */
	private PagoStrategy strategy;



	/**
     * @param strategy
	 */
	public void FormaDePago(PagoStrategy strategy) {
		// TODO implement here
                this.strategy=strategy;
	}

	/**
	 * @param pago
	 */
	public void pago(Pago pago) {
		// TODO implement here
                strategy.pagar();
	}

}