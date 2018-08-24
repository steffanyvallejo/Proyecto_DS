/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import model.Administrador;
import model.Articulo;
import model.CocinaInduccion;
import model.Empleado;
import model.Gerente;
import model.Lavadora;
import model.Refrigeradora;
import model.Vendedor;

/**
 *
 * @author Moises
 */
public class ConexionDB {

    private Connection conexion;

    public void connectDatabase() {
        try {
            // We register the PostgreSQL driver
            // Registramos el driver de PostgresSQL
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }
            // Database connect
            // Conectamos con la base de datos
            conexion = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/DB_lineaBlanca",
                    "postgres", "root");

            boolean valid = conexion.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }

    public Empleado login(String user, String pass) {

        connectDatabase();
        try {
            PreparedStatement pst = conexion.prepareStatement("SELECT * FROM t_usuario WHERE usuario = ? AND pass = ?");
            pst.setString(1, user);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String t = rs.getString("tipo");
                if (t.equals("v")) {
                    Vendedor v = new Vendedor();
                    v.setNombre(rs.getString("nombre"));
                    v.setApellido(rs.getString("apellido"));
                    v.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                    v.setNumeroTelefonico(rs.getString("telefono"));
                    v.setDirecciónDomicilio(rs.getString("direccion"));
                    v.setCorreoElectronico(rs.getString("correo"));
                    v.setUsuario(rs.getString("usuario"));
                    v.setContraseña(rs.getString("pass"));
                    v.setTipo(rs.getString("tipo"));
                    v.setIsSuper(rs.getBoolean("super"));
                    pst.close();
                    rs.close();
                    return v;
                } else if (t.equals("g")) {
                    Gerente g = new Gerente();
                    g.setNombre(rs.getString("nombre"));
                    g.setApellido(rs.getString("apellido"));
                    g.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                    g.setNumeroTelefonico(rs.getString("telefono"));
                    g.setDirecciónDomicilio(rs.getString("direccion"));
                    g.setCorreoElectronico(rs.getString("correo"));
                    g.setUsuario(rs.getString("usuario"));
                    g.setContraseña(rs.getString("pass"));
                    g.setTipo(rs.getString("tipo"));
                    g.setIsSuper(rs.getBoolean("super"));
                    pst.close();
                    rs.close();
                    return g;
                } else if (t.equals("a")) {
                    Administrador a = new Administrador();
                    a.setNombre(rs.getString("nombre"));
                    a.setApellido(rs.getString("apellido"));
                    a.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                    a.setNumeroTelefonico(rs.getString("telefono"));
                    a.setDirecciónDomicilio(rs.getString("direccion"));
                    a.setCorreoElectronico(rs.getString("correo"));
                    a.setUsuario(rs.getString("usuario"));
                    a.setContraseña(rs.getString("pass"));
                    a.setTipo(rs.getString("tipo"));
                    a.setIsSuper(rs.getBoolean("super"));
                    pst.close();
                    rs.close();
                    return a;
                }

            }
        } catch (SQLException ex) {
            System.out.println("Error al login");
            System.out.println(ex);
        }
        return null;
    }

    public Articulo agregarArticuloDemo(String modo, String campo){
        connectDatabase();
        System.out.println("conecta db para articulo");
        if (modo.equals("nombre")) {
            System.out.println("antes del try para articulo");
            try {
                System.out.println("entra al nombre");
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM t_articulo WHERE nombre = ?");
                pst.setString(1, campo);
                ResultSet rs = pst.executeQuery();
                System.out.println("ejecucion del query");
                while (rs.next()) {
                    String cat = rs.getString("categoria");
                    if (cat.equals("cocina")) {
                        CocinaInduccion c = new CocinaInduccion();
                        c.setNombre(rs.getString("nombre"));
                        c.setDescripcion(rs.getString("descripcion"));
                        c.setCategoria(rs.getString("categoria"));
                        c.setStock(rs.getInt("stock"));
                        c.setEstado(rs.getBoolean("estado"));
                        c.setPrecio(rs.getFloat("precio"));
                        c.setMarca(rs.getString("marca"));
                        pst.close();
                        rs.close();
                        return c;
                    } else if (cat.equals("lavadora")) {
                        Lavadora l = new Lavadora();
                        l.setNombre(rs.getString("nombre"));
                        l.setDescripcion(rs.getString("descripcion"));
                        l.setCategoria(rs.getString("categoria"));
                        l.setStock(rs.getInt("stock"));
                        l.setEstado(rs.getBoolean("estado"));
                        l.setPrecio(rs.getFloat("precio"));
                        l.setMarca(rs.getString("marca"));
                        pst.close();
                        rs.close();
                        return l;
                    } else if (cat.equals("refrigeradora")) {
                        Refrigeradora r = new Refrigeradora();
                        r.setNombre(rs.getString("nombre"));
                        r.setDescripcion(rs.getString("descripcion"));
                        r.setCategoria(rs.getString("categoria"));
                        r.setStock(rs.getInt("stock"));
                        r.setEstado(rs.getBoolean("estado"));
                        r.setPrecio(rs.getFloat("precio"));
                        r.setMarca(rs.getString("marca"));
                        pst.close();
                        rs.close();
                        return r;
                    }
                    System.out.println("No hay");
                }
            } catch (SQLException ex) {
                System.out.println("Error al no encontrar el producto en la db");
                System.out.println(ex);
            }
        } else if (modo.equals("descripción1")) {
            //con la descripcion
        } else if (modo.equals("categoría")) {
            //con la categoria
        }

        return null;
    }
    
    public LinkedList<String> consultarArticulo(String modo, String campo){
        LinkedList<String> datos = new LinkedList<String>();
        connectDatabase();
        System.out.println("conecta db para articulo");
        if (modo.equals("nombre")) {
            System.out.println("antes del try para articulo");
            try {
                System.out.println("entra al nombre");
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM t_articulo WHERE nombre = ?");
                pst.setString(1, campo);
                ResultSet rs = pst.executeQuery();
                System.out.println("ejecucion del query");
                while (rs.next()) {
                    String nombre = rs.getString("nombre");
                    String categoria = rs.getString("categoria");
                    String precio = Float.toString(rs.getFloat("precio"));
                    String marca = rs.getString("marca");
                    datos.add(nombre);
                    datos.add(categoria);
                    datos.add(precio);
                    datos.add(marca);                                                        
                }
                return datos; 
            } catch (SQLException ex) {
                System.out.println("Error al no encontrar el producto en la db");
                System.out.println(ex);
            }
        } else if (modo.equals("descripción1")) {
            //con la descripcion
        } else if (modo.equals("categoría")) {
            //con la categoria
        }
        return null;
    }
}
