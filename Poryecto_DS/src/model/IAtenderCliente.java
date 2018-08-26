package model;

import java.util.LinkedList;

/**
 *
 */

public interface IAtenderCliente {
    public void setNex(IAtenderCliente atender);
    public IAtenderCliente getNex();
    public void realizarVenta(Venta venta, Vendedor vendedor, String cedulaCliente, LinkedList<String> productosComprados, FormaPago fpago);
    public void realizarCotizacion(Articulo a);    
}
