package demo;

import model.Cliente;
import model.Vendedor;
import model.VendedorEditarVenta;
import model.Administrador;
import model.NotificacionPeticion;
import view.MainView;

/**
 *
 */
public class Main {

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
