package model;

import controller.ConexionDBM;
import controller.ConsultasDB;
import controller.ReportesDB;
import java.util.*;

/**
 *
 */
public class Gerente extends Empleado {

    /**
     * Default constructor
     */
    
    private ConsultasDB consultas;
    private ReportesDB reportes;

    public Gerente() {
        this.consultas=new ConsultasDB();
        this.reportes=new ReportesDB();
    }

    @Override
    public LinkedList<String> consultarCliente(String cedula) {
        System.out.println("consulta cliente ...");        
        LinkedList<String>datos = consultas.consultarClienteDB(cedula);
        return datos;
    }
    
    @Override
    public LinkedList<LinkedList<String>> consultarArticulo(String modo, String campo) {
        System.out.println("consulta articulo ...");        
        System.out.println(modo);
        System.out.println(campo);
        LinkedList<LinkedList<String>> datos = consultas.consultarArticulo(modo, campo);
        return datos;
    }

    public boolean consultaTransaccion(Transaccion t) {
        // TODO implement here
        return false;
    }

    public LinkedList<Transaccion> generarReporte() {
        // TODO implement here
        return null;
    }
    
    public LinkedList<LinkedList<String>> generarReporteVendedor(){        
        System.out.println("Entra a grv");
        LinkedList<LinkedList<String>> datos = new LinkedList<LinkedList<String>>();
        datos = reportes.reporteVendedor();
        return datos;
    }
    
    public LinkedList<LinkedList<String>> generarReporteArticulo(){        
        System.out.println("Entra a grv");
        LinkedList<LinkedList<String>> datos = new LinkedList<LinkedList<String>>();
        datos = reportes.reporteArticulo();
        return datos;
    }

}
