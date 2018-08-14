package model;

/**
 *
 */
public abstract class VendedorPermisos extends Vendedor {

    private Vendedor vendedor;

    /**
     * Default constructor
     */
    public VendedorPermisos(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    /**
     * @param o
     * @return
     */
    public abstract void operacion(Object o);

}
