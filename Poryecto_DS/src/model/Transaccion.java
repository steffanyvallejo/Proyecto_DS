package model;

import java.util.*;

/**
 * 
 */
public class Transaccion {

    public Transaccion(Cliente c, Vendedor v) {
        java.util.Date fecha = new Date();
        this.idTransacción+=1;
        this.fecha=fecha;
        this.idCliente=c.getId();
        this.idVendedor=v.getId();
    }
    

    public int idTransacción=0;

    private Date fecha;

    public String idCliente;

    public String idVendedor;


    public void registrarTransacción(int idTransaccion) {
        System.out.println("Transacion"+this.idTransacción+" exitosa");

    }

}
