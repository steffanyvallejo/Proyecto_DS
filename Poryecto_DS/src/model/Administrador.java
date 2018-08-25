package model;

import java.util.LinkedList;

/**
 *
 */
public class Administrador extends Empleado implements PeticionPermiso{
    
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

    @Override
    public LinkedList<LinkedList<String>> consultarArticulo(String modo, String campo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<String> consultarCliente(String cedula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
