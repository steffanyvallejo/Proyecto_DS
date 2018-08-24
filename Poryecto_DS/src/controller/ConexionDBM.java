/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import model.Administrador;
import model.Empleado;
import model.Gerente;
import model.Vendedor;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author EmilioMP
 */
public class ConexionDBM {

    private final String URL = "jdbc:mysql://localhost:3306/lineaBlanca";
    private final String USERNAME = "root";
    private final String PASSWORD = "1234";

    private Connection conexion;

    public void establecerConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(this.URL, this.USERNAME, this.PASSWORD);
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            conexion = null;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            conexion = null;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            conexion = null;
        }
    }

    public Empleado login(String user, String pass) {
        establecerConexion();
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
                    v.setIsSuper(rs.getBoolean("esSuper"));
                    v.setCedula(rs.getString("cedula"));
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
                    g.setIsSuper(rs.getBoolean("esSuper"));
                    g.setCedula(rs.getString("cedula"));
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
                    a.setIsSuper(rs.getBoolean("esSuper"));
                    a.setCedula(rs.getString("cedula"));
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

    public LinkedList<LinkedList<String>> consultarArticulo(String modo, String campo) {
        LinkedList<LinkedList<String>> datos = new LinkedList<LinkedList<String>>();
        establecerConexion();
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
                    LinkedList<String> temp = new LinkedList<String>();
                    String nombre = rs.getString("nombre");
                    String categoria = rs.getString("categoria");
                    String precio = Float.toString(rs.getFloat("precio"));
                    String marca = rs.getString("marca");
                    temp.add(nombre);
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
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM t_articulo WHERE descripcion LIKE ?");
                pst.setString(1, "%" + campo + "%");
                ResultSet rs = pst.executeQuery();
                System.out.println("ejecucion del query");
                while (rs.next()) {
                    LinkedList<String> temp = new LinkedList<String>();
                    String nombre = rs.getString("nombre");
                    String categoria = rs.getString("categoria");
                    String precio = Float.toString(rs.getFloat("precio"));
                    String marca = rs.getString("marca");
                    temp.add(nombre);
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
                PreparedStatement pst = conexion.prepareStatement("SELECT * FROM t_articulo WHERE categoria = ?");
                pst.setString(1, campo);
                ResultSet rs = pst.executeQuery();
                System.out.println("ejecucion del query");
                while (rs.next()) {
                    LinkedList<String> temp = new LinkedList<String>();
                    String nombre = rs.getString("nombre");
                    String categoria = rs.getString("categoria");
                    String precio = Float.toString(rs.getFloat("precio"));
                    String marca = rs.getString("marca");
                    temp.add(nombre);
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

    public void agregarClienteDB(String nombre, String apellido, String cedula, Date fech_nac, String telefono, String direccion, String correo) {
        establecerConexion();
        try {
            PreparedStatement pst = conexion.prepareStatement("INSERT INTO t_cliente (nombre, apellido, fecha_nacimiento, telefono, direccion, correo, cedula) VALUES (?,?,?,?,?,?,?)");
            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setDate(3, fech_nac);
            pst.setString(4, telefono);
            pst.setString(5, direccion);
            pst.setString(6, correo);
            pst.setString(7, cedula);
            int res = pst.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Cliente ingresado éxitosamente en el sistema");
                System.out.println("ususario bien");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente no ingresado éxitosamente en el sistema");
                System.out.println("usuario mal");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Cliente no ingresado éxitosamente en el sistema");
            System.out.println("usuario mal");
            System.out.println(ex.getMessage());
        }
    }

    public LinkedList<String> consultarClienteDB(String cedula) {
        LinkedList<String> datos = new LinkedList<String>();
        establecerConexion();
        System.out.println("conecta db para buscar c");
        try {
            System.out.println("entra al nombre");
            PreparedStatement pst = conexion.prepareStatement("SELECT * FROM t_cliente WHERE cedula = ?");
            pst.setString(1, cedula);
            ResultSet rs = pst.executeQuery();
            System.out.println("ejecucion del query");
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                String correo = rs.getString("correo");
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

    public LinkedList<LinkedList<String>> reporteVendedor() {        
        Calendar c = Calendar.getInstance();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        c.add(Calendar.DATE, -7);
        java.util.Date pasado = c.getTime();
        java.util.Date ahora = new java.util.Date();
        String pasadoS = formateador.format(pasado);
        String ahoraS = formateador.format(ahora);
        
        establecerConexion();
        LinkedList<LinkedList<String>> datos = new LinkedList<LinkedList<String>>();
        
        try {
            System.out.println("entra al nombre");
            PreparedStatement pst = conexion.prepareStatement("select v.id_usuario as id, u.nombre as nombre, count(*) as cantidad, sum(v.valor) as total from t_usuario u, t_venta v where v.id_usuario = u.id_user and v.fecha between ? and ? group by v.id_usuario;");        
            pst.setDate(1, Date.valueOf(pasadoS));
            pst.setDate(2, Date.valueOf(ahoraS));
            ResultSet rs = pst.executeQuery();
            System.out.println("ejecucion del query");
            while (rs.next()) {
                LinkedList<String> temp = new LinkedList<String>();
                String id = Integer.toString(rs.getInt("id"));
                String nombre = rs.getString("nombre");
                String cantidad = Integer.toString(rs.getInt("cantidad"));
                String total = Float.toString(rs.getFloat("total"));
                temp.add(id);
                temp.add(nombre);
                temp.add(cantidad);
                temp.add(total);
                datos.add(temp);
            }
            return datos;
        } catch (SQLException ex) {
            System.out.println("Error al no encontrar el producto en la db");
            System.out.println(ex);
        }
       
        return null;
    }
    
    public LinkedList<LinkedList<String>> reporteArticulo() {        
        Calendar c = Calendar.getInstance();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        c.add(Calendar.DATE, -7);
        java.util.Date pasado = c.getTime();
        java.util.Date ahora = new java.util.Date();
        String pasadoS = formateador.format(pasado);
        String ahoraS = formateador.format(ahora);
        
        establecerConexion();
        LinkedList<LinkedList<String>> datos = new LinkedList<LinkedList<String>>();
        
        try {
            System.out.println("entra al nombre");
            PreparedStatement pst = conexion.prepareStatement("select v.id_articulo as id, a.nombre as nombre, count(*) as cantidad, sum(v.valor) as total from t_articulo a, t_venta v where v.id_articulo = a.id_art and v.fecha between ? and ? group by v.id_articulo;");        
            pst.setDate(1, Date.valueOf(pasadoS));
            pst.setDate(2, Date.valueOf(ahoraS));
            ResultSet rs = pst.executeQuery();
            System.out.println("ejecucion del query");
            while (rs.next()) {
                LinkedList<String> temp = new LinkedList<String>();
                String id = Integer.toString(rs.getInt("id"));
                String nombre = rs.getString("nombre");
                String cantidad = Integer.toString(rs.getInt("cantidad"));
                String total = Float.toString(rs.getFloat("total"));
                temp.add(id);
                temp.add(nombre);
                temp.add(cantidad);
                temp.add(total);
                datos.add(temp);
            }
            return datos;
        } catch (SQLException ex) {
            System.out.println("Error al no encontrar el producto en la db");
            System.out.println(ex);
        }
       
        return null;
    }
}
