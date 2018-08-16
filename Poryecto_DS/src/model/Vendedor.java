package model;

/**
 *
 */
public class Vendedor extends Empleado {

    /**
     * Default constructor
     */
    public Vendedor() {
    }

    public void agregarCliente(Cliente c) {
        System.out.println("agregando cliente ...");
    }

    /**
     * @param Articulo
     * @return
     */
    public float cotizar(Articulo a) {
        System.out.println("cotizando producto ...");
        return 0.0f;
    }

    /**
     * @param Articulo
     * @return
     */
    public void vender(Articulo a) {
        System.out.println("vendiendo producto ...");
    }

    /**
     * @param c Cliente
     * @return
     */
    public boolean consultarCliente(Cliente c) {
        System.out.println("consulta cliente ...");
        return false;
    }

    /**
     * @param a Articulo
     * @return
     */
    public boolean consultarArticulo(Articulo a) {
        System.out.println("consulta articulo ...");
        return false;
    }
    
    public void pedirPermiso(NotificacionPeticion np){
        System.out.println("Necesito permiso");
        //NotificacionPeticion np = new NotificacionPeticion();
        np.notifyObservers();
    }

}
