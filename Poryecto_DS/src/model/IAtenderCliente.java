/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedList;

/**
 *
 * @author EmilioMP
 */

public interface IAtenderCliente {
    public void setNex(IAtenderCliente atender);
    public IAtenderCliente getNex();
    public void realizarVenta(Venta venta, Vendedor vendedor, String cedulaCliente, LinkedList<String> productosComprados, FormaPago fpago);
    public void realizarCotizacion(Articulo a);    
}
