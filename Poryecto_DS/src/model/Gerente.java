package model;

import controller.ConexionDBM;
import java.util.*;

/**
 *
 */
public class Gerente extends Empleado {

    /**
     * Default constructor
     */
    ConexionDBM cn;

    public Gerente() {
    }

    /**
     * @param c Cliente
     * @return
     */
    public LinkedList<String> consultarCliente(String cedula) {
        System.out.println("consulta cliente ...");
        cn = new ConexionDBM();
        LinkedList<String>datos = cn.consultarClienteDB(cedula);
        return datos;
    }

    /**
     * @param a Articulo
     * @return
     */
    public LinkedList<LinkedList<String>> consultarArticulo(String modo, String campo) {
        System.out.println("consulta articulo ...");
        cn = new ConexionDBM();
        System.out.println(modo);
        System.out.println(campo);
        LinkedList<LinkedList<String>> datos = cn.consultarArticulo(modo, campo);
        return datos;
    }

    /**
     * @param t Transaccion
     * @return
     */
    public boolean consultaTransaccion(Transaccion t) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public LinkedList<Transaccion> generarReporte() {
        // TODO implement here
        return null;
    }
    
    public LinkedList<LinkedList<String>> generarReporteVendedor(){
        cn = new ConexionDBM();
        System.out.println("Entra a grv");
        LinkedList<LinkedList<String>> datos = new LinkedList<LinkedList<String>>();
        datos = cn.reporteVendedor();
        return datos;
    }
    
    public LinkedList<LinkedList<String>> generarReporteArticulo(){
        cn = new ConexionDBM();
        System.out.println("Entra a grv");
        LinkedList<LinkedList<String>> datos = new LinkedList<LinkedList<String>>();
        datos = cn.reporteArticulo();
        return datos;
    }

}
