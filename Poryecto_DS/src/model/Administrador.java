package model;

/**
 *
 */
public class Administrador implements PeticionPermiso{

    private boolean isSuper;

    public Administrador() {
    }

    public void manejarTransacciones() {
        // TODO implement here
    }

    public void ingresarStock(Articulo a, int num) {
        // TODO implement here
    }

    public void actualizarStock(float num) {
        // TODO implement here
    }

    public void ingresarPrecioDeVenta(float num) {
        // TODO implement here
    }

    public void actualizarPrecioDeVenta(float num) {
        // TODO implement here
    }

    public boolean consultarArticulo(Articulo a) {
        // TODO implement here
        return false;
    }

    public void eliminarArticulo(Articulo a) {
        // TODO implement here
    }

    public void ingresarTransaccion(Transaccion t) {
        // TODO implement here
    }

    public void actualizarTransaccion(Transaccion t) {
        // TODO implement here
    }

    public boolean consultarTransaccion(Transaccion t) {
        // TODO implement here
        return false;
    }

    public void eliminarTransaccion(Transaccion t) {
        // TODO implement here
    }

    public void ingresarCliente(boolean b, Empleado e) {
        // TODO implement here
    }

    public void actualizarCliente(boolean b, Empleado e) {
        // TODO implement here
    }

    public boolean consultarCliente(boolean b, Empleado e) {
        // TODO implement here
        return false;
    }

    public void eliminarCliente(boolean s, Empleado e) {
        // TODO implement here
    }

    @Override
    public void update() {
        System.out.println("Administrador:");
        System.out.println("Concebir permiso ...");
    }

}
