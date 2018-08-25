package model;

import controller.ConsultasDB;
import controller.IngresosDB;
import java.sql.Date;
import java.util.LinkedList;

/**
 *
 */
public class Vendedor extends Empleado {

    private ConsultasDB consultas;
    private IngresosDB ingresos;
   
    public Vendedor() {
        this.consultas=new ConsultasDB();
        this.ingresos=new IngresosDB();
    }

    public void agregarCliente(String nombre,String apellido,String cedula, Date fech_nac,String telefono,String direccion, String correo) {
        System.out.println("agregando cliente ...");        
        ingresos.agregarClienteDB(nombre, apellido, cedula, fech_nac, telefono, direccion, correo);
    }
    
    public float cotizar(Articulo a) {
        System.out.println("cotizando producto ...");
        return 0.0f;
    }
    
    public void realizarVenta(Venta venta, Vendedor vendedor, String cedulaCliente, LinkedList<String> productosComprados, FormaPago fpago){
        System.out.println("vendiendo producto ...");
        ingresos.ingresarVentaDB(venta, vendedor, cedulaCliente);
        ingresos.ingresarPago(venta, fpago);
        ingresos.ingresarDetallesVenta(venta, productosComprados);
        
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
    
    public void pedirPermiso(NotificacionPeticion np){
        System.out.println("Necesito permiso");
        //NotificacionPeticion np = new NotificacionPeticion();
        np.notifyObservers();
    }
}
