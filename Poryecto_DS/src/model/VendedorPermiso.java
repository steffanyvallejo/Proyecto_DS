/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.util.*;

/**
 * 
 */
public abstract class VendedorPermiso extends Vendedor {

	/**
	 * Default constructor
	 */
	public VendedorPermiso() {
	}

	/**
	 * 
	 */
	private Vendedor vendedor;


	/**
	 * @param o 
	 * @return
	 */
	public abstract void operacion(Object o);

}
