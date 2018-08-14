package model;

/**
 *
 */
public class VendedorEditarVenta extends VendedorPermisos {

    /**
     * Default constructor
     */
    public VendedorEditarVenta(Vendedor vendedor) {
        super(vendedor);
    }

    @Override
    public void operacion(Object o) {
        System.out.println("edicion de venta ...");
    }

}
