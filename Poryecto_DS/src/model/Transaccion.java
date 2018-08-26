package model;

import java.util.*;

public class Transaccion implements IAtenderCliente{

    private IAtenderCliente next;
    private int idTransacción=0;
    private Date fecha;
    private String idCliente;
    private String idVendedor;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }
    
    public Transaccion() {
        this.idTransacción+=1; 
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
