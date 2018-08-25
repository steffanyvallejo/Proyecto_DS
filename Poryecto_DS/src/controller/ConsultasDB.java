/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.sql.Connection;


/**
 *
 * @author EmilioMP
 */
public class ConsultasDB {
    
    private Connection conexion;    
    
    public ConsultasDB(){
        this.conexion=new ConexionDBM().establecerConexion(conexion);
    }
    
    public LinkedList<LinkedList<String>> consultarArticulo(String modo, String campo) {
        LinkedList<LinkedList<String>> datos = new LinkedList<LinkedList<String>>();        
        System.out.println("conecta db para articulo");
        if (modo.equals("nombre")) {
            System.out.println("antes del try para articulo");
            try {
                System.out.println("entra al nombre");
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM t_articulo WHERE Art_Modelo = ?");
                pst.setString(1, campo);
                ResultSet rs = pst.executeQuery();
                System.out.println("ejecucion del query");
                while (rs.next()) {
                    LinkedList<String> temp = new LinkedList<String>();
                    String modelo = rs.getString("Art_Modelo");
                    String categoria = rs.getString("Art_Categ");
                    String precio = Float.toString(rs.getFloat("Art_Precio"));
                    String marca = rs.getString("Art_Marca");
                    temp.add(modelo);
                    temp.add(categoria);
                    temp.add(precio);
                    temp.add(marca);
                    datos.add(temp);
                }
                return datos;
            } catch (SQLException ex) {
                System.out.println("Error al no encontrar el producto en la db");
                System.out.println(ex);
            }
        } else if (modo.equals("descripción")) {
            System.out.println("antes del try para articulo");
            try {
                System.out.println("entra a la descripcion");
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM t_articulo WHERE Art_Descripcion LIKE ?");
                pst.setString(1, "%" + campo + "%");
                ResultSet rs = pst.executeQuery();
                System.out.println("ejecucion del query");
                while (rs.next()) {
                    LinkedList<String> temp = new LinkedList<String>();
                    String modelo = rs.getString("Art_Modelo");
                    String categoria = rs.getString("Art_Categ");
                    String precio = Float.toString(rs.getFloat("Art_Precio"));
                    String marca = rs.getString("Art_Marca");
                    temp.add(modelo);
                    temp.add(categoria);
                    temp.add(precio);
                    temp.add(marca);
                    datos.add(temp);
                }
                return datos;
            } catch (SQLException ex) {
                System.out.println("Error al no encontrar el producto en la db");
                System.out.println(ex);
            }
        } else if (modo.equals("categoría")) {
            System.out.println("antes del try para articulo");
            try {
                System.out.println("entra a la categoria");
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM t_articulo WHERE Art_Categ = ?");
                pst.setString(1, campo);
                ResultSet rs = pst.executeQuery();
                System.out.println("ejecucion del query");
                while (rs.next()) {
                    LinkedList<String> temp = new LinkedList<String>();
                    String modelo = rs.getString("Art_Modelo");
                    String categoria = rs.getString("Art_Categ");
                    String precio = Float.toString(rs.getFloat("Art_Precio"));
                    String marca = rs.getString("Art_Marca");
                    temp.add(modelo);
                    temp.add(categoria);
                    temp.add(precio);
                    temp.add(marca);
                    datos.add(temp);
                }
                return datos;
            } catch (SQLException ex) {
                System.out.println("Error al no encontrar el producto en la db");
                System.out.println(ex);
            }
        }
        return null;
    }
    
    public LinkedList<String> consultarClienteDB(String cedula) {
        LinkedList<String> datos = new LinkedList<String>();
        System.out.println("conecta db para buscar c");
        try {
            System.out.println("entra al nombre");
            PreparedStatement pst = conexion.prepareStatement("SELECT * FROM t_cliente WHERE Cli_Cedula = ?");
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
}
