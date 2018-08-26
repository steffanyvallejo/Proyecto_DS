package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class ConsultasDB {

    private Connection conexion;
    private PreparedStatement pst;
    private LinkedList<LinkedList<String>> datosArt;

    public ConsultasDB() {
        this.conexion = new ConexionDBM().establecerConexion(conexion);
           
    }

    public LinkedList<LinkedList<String>> consultarArticulo(String modo, String campo) {         
        System.out.println("conecta db para articulo");
        if (modo.equals("nombre")) {
            return consultaNombre(campo);
        } else if (modo.equals("descripción")) {
            return consultaDescripcion(campo);
        } else if (modo.equals("categoría")) {
            return consultaCategoria(campo);
        }            
        return null;
    }
    
    public LinkedList<String> consultarClienteDB(String cedula) {
        LinkedList<String> datos = new LinkedList<String>();
        System.out.println("conecta db para buscar c");
        try {
            System.out.println("entra al nombre");
            pst = conexion.prepareStatement("SELECT * FROM t_cliente WHERE Cli_Cedula = ?");
            pst.setString(1, cedula);
            ResultSet rs = pst.executeQuery();
            System.out.println("ejecucion del query");
            while (rs.next()) {
                String nombre = rs.getString("Cli_Nombre");
                String apellido = rs.getString("Cli_Apellido");
                String telefono = rs.getString("Cli_Telefono");
                String direccion = rs.getString("Cli_Direccion");
                String correo = rs.getString("Cli_email");
                datos.add(nombre);
                datos.add(apellido);
                datos.add(telefono);
                datos.add(direccion);
                datos.add(correo);
            }
            return datos;
        } catch (SQLException ex) {
            System.out.println("Error al no encontrar el producto en la db");
            System.out.println(ex);
        }
        return null;
    }

    private LinkedList<LinkedList<String>> consultaNombre(String campo) {
        datosArt = new LinkedList<LinkedList<String>>();
        System.out.println("antes del try para articulo");
        try {
            System.out.println("entra al nombre");
            pst = conexion.prepareStatement("SELECT * FROM t_articulo WHERE Art_Modelo = ?");
            pst.setString(1, campo);
            ResultSet rs = pst.executeQuery();
            guardarDatosArt(rs, datosArt);
            return datosArt;
        } catch (SQLException ex) {
            System.out.println("Error al no encontrar el producto en la db");
            System.out.println(ex);
        }
        return null;
    }

    private LinkedList<LinkedList<String>> consultaDescripcion(String campo) {
        datosArt = new LinkedList<LinkedList<String>>();
        System.out.println("antes del try para articulo");
        try {
            System.out.println("entra a la descripcion");
            pst = conexion.prepareStatement("SELECT * FROM t_articulo WHERE Art_Descripcion LIKE ?");
            pst.setString(1, "%" + campo + "%");
            ResultSet rs = pst.executeQuery();
            guardarDatosArt(rs, datosArt);
            return datosArt;
        } catch (SQLException ex) {
            System.out.println("Error al no encontrar el producto en la db");
            System.out.println(ex);
        }
        return null;
    }

    private LinkedList<LinkedList<String>> consultaCategoria(String campo) {
        datosArt = new LinkedList<LinkedList<String>>();
        System.out.println("antes del try para articulo");
        try {
            System.out.println("entra a la categoria");
            pst = conexion.prepareStatement("SELECT * FROM t_articulo WHERE Art_Categ = ?");
            pst.setString(1, campo);
            ResultSet rs = pst.executeQuery();
            guardarDatosArt(rs, datosArt);
            return datosArt;
        } catch (SQLException ex) {
            System.out.println("Error al no encontrar el producto en la db");
            System.out.println(ex);
        }return null;
    }
    
    private void guardarDatosArt(ResultSet rs, LinkedList<LinkedList<String>> datosArt){
        try {
            while (rs.next()) {                
                LinkedList<String> tempArt = new LinkedList<>();
                String modelo = rs.getString("Art_Modelo");
                String categoria = rs.getString("Art_Categ");
                String precio = Float.toString(rs.getFloat("Art_Precio"));
                String marca = rs.getString("Art_Marca");
                tempArt.add(modelo);
                tempArt.add(categoria);
                tempArt.add(precio);
                tempArt.add(marca);                
                datosArt.add(tempArt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
