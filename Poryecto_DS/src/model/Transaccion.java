package model;

import java.util.*;

/**
 * 
 */
public class Transaccion implements IAtenderCliente{

    private IAtenderCliente next;
    public int idTransacción=0;
    private Date fecha;
    public String idCliente;
    public String idVendedor;

    public Transaccion() {
    }       
    
    public Transaccion(Cliente c, Vendedor v) {
        this.fecha = new Date();
        this.idTransacción+=1;
        this.fecha=fecha;
        this.idCliente=c.getId();
        this.idVendedor=v.getId();
    }    

    public void registrarTransacción(int idTransaccion) {
        System.out.println("Transacion"+this.idTransacción+" exitosa");
    }

    @Override
    public void setNex(IAtenderCliente atender) {
        next = atender;
    }

    @Override
    public IAtenderCliente getNex() {
        return next;
    }

    @Override
    public void realizarVenta(Venta venta, Vendedor vendedor, String cedulaCliente, LinkedList<String> productosComprados, FormaPago fpago) {
        Vendedor vendedorA = new Vendedor();
        this.setNex(vendedorA);
        next.realizarVenta(venta, vendedor, cedulaCliente, productosComprados, fpago);
    }

    @Override
    public void realizarCotizacion(Articulo a) {
        Vendedor vendedorA = new Vendedor();
        this.setNex(vendedorA);
        next.realizarCotizacion(a);
    }
}
