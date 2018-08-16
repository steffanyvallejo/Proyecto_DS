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
import model.Administrador;
import model.Empleado;
import model.Gerente;
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
                /*
                Empleado emp = new Empleado();
                emp.setNombre(rs.getString("nombre"));
                emp.setApellido(rs.getString("apellido"));
                emp.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                emp.setNumeroTelefonico(rs.getString("telefono"));
                emp.setDirecciónDomicilio(rs.getString("direccion"));
                emp.setCorreoElectronico(rs.getString("correo"));
                emp.setUsuario(rs.getString("usuario"));
                emp.setContraseña(rs.getString("pass"));
                emp.setTipo(rs.getString("tipo"));
                emp.setIsSuper(rs.getBoolean("super"));
                pst.close();
                rs.close();
                return emp;
                */
                
                String t = rs.getString("tipo");                
                if(t.equals("v")){
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
                }else if(t.equals("g")){
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
                }else if (t.equals("a")){
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
        }
        return null;
    }
}
