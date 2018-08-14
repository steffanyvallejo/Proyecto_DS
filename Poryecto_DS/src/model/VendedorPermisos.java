package MODEL;

import java.util.*;

/**
 * 
 */
public abstract class VendedorPermisos extends Vendedor {

	/**
	 * Default constructor
	 */
	public VendedorPermisos() {
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