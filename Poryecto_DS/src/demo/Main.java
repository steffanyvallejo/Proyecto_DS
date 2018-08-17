package demo;

import controller.ConexionDB;
import model.Cliente;
import model.Vendedor;
import model.VendedorEditarVenta;
import model.Administrador;
import model.Articulo;
import model.CocinaInduccion;
import model.Credito;
import model.FormaPago;
import model.NotificacionPeticion;



/**
 *
 */
public class Main {
    
    public static ConexionDB cn;

    public static void main(String[] args) {
        /*
            Prueba decorate
         */
        Cliente c = new Cliente();
        Vendedor v = new Vendedor();
        v.agregarCliente(c);
        VendedorEditarVenta ve = new VendedorEditarVenta(v);
        ve.operacion(v);

        /*
            Prueba observer
         */
        Administrador adm = new Administrador();
        NotificacionPeticion np = new NotificacionPeticion();
        np.attach(adm);
        v.pedirPermiso(np);
        
        /*
            Prueba Strategy
        */
        Articulo a= new CocinaInduccion();
        FormaPago formadePago= new FormaPago();
        formadePago.FormaDePago(new Credito());
        formadePago.pago(new Credito());
        v.vender(a);
                        
        cn = new ConexionDB();
        Vendedor vendedor = (Vendedor)cn.login("emilio", "emilio");
        System.out.println(vendedor.getNombre());
        
        
        
        
    }
    /**
     * Default constructor
     */
    public Main() {
    }

    /**
     * @return
     */
    public void main() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void conectarDatabase() {
        // TODO implement here
    }

}
