/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author EmilioMP
 */
public class CargasDB {

    private Connection conexion;

    public CargasDB() {
        this.conexion = new ConexionDBM().establecerConexion(conexion);
    }

    public Empleado login(String user, String pass) {
        try {
            PreparedStatement pst = conexion.prepareStatement("SELECT * FROM t_usuario WHERE usuario = ? AND pass = ?");
            pst.setString(1, user);
            pst.setString(2, pass);
            ResultSet resultados = pst.executeQuery();
            while (resultados.next()) {
                String t = resultados.getString("tipo");
                if (t.equals("v")) {
                    Vendedor v = new Vendedor();
                    setearDatos(v, resultados);
                    close(pst, resultados);
                    return v;
                } else if (t.equals("g")) {
                    Gerente g = new Gerente();
                    setearDatos(g, resultados);
                    close(pst, resultados);
                    return g;
                } else if (t.equals("a")) {
                    Administrador a = new Administrador();
                    setearDatos(a, resultados);
                    close(pst, resultados);
                    return a;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al login");
            System.out.println(ex);
        }
        return null;
    }

    private void setearDatos(Empleado emp, ResultSet resultados) {
        try {
            emp.setNombre(resultados.getString("nombre"));
            emp.setApellido(resultados.getString("apellido"));
            emp.setFechaNacimiento(resultados.getDate("fecha_nacimiento"));
            emp.setNumeroTelefonico(resultados.getString("telefono"));
            emp.setDirecciónDomicilio(resultados.getString("direccion"));
            emp.setCorreoElectronico(resultados.getString("correo"));
            emp.setUsuario(resultados.getString("usuario"));
            emp.setContraseña(resultados.getString("pass"));
            emp.setTipo(resultados.getString("tipo"));
            emp.setIsSuper(resultados.getBoolean("esSuper"));
            emp.setCedula(resultados.getString("cedula"));
        } catch (SQLException ex) {
            Logger.getLogger(CargasDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void close(PreparedStatement pst, ResultSet resultados) {
        try {
            pst.close();
            resultados.close();
        } catch (SQLException ex) {
            Logger.getLogger(CargasDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public LinkedList<Articulo> cargarArticulos() {
        LinkedList<Articulo> articulosDisponibles = new LinkedList<Articulo>();
        System.out.println("conecta db para buscar c");
        try {
            System.out.println("entra al nombre");
            PreparedStatement pst = conexion.prepareStatement("SELECT * FROM t_articulo");
            ResultSet rs = pst.executeQuery();
            System.out.println("ejecucion del query");
            while (rs.next()) {
                if (rs.getString("Art_Categ").equals("cocina")) {
                    CocinaInduccion cocina = new CocinaInduccion(rs.getString("Art_Modelo"), rs.getString("Art_Marca"), rs.getString("Art_Categ"), rs.getString("Art_Color"), rs.getFloat("Art_Precio"), rs.getInt("Art_Stock"));
                    articulosDisponibles.add(cocina);

                } else if (rs.getString("Art_Categ").equals("lavadora")) {
                    Lavadora lavadora = new Lavadora(rs.getString("Art_Modelo"), rs.getString("Art_Marca"), rs.getString("Art_Categ"), rs.getString("Art_Color"), rs.getFloat("Art_Precio"), rs.getInt("Art_Stock"));
                    articulosDisponibles.add(lavadora);

                } else if (rs.getString("Art_Categ").equals("refrigeradora")) {
                    Refrigeradora refrigeradora = new Refrigeradora(rs.getString("Art_Modelo"), rs.getString("Art_Marca"), rs.getString("Art_Categ"), rs.getString("Art_Color"), rs.getFloat("Art_Precio"), rs.getInt("Art_Stock"));
                    articulosDisponibles.add(refrigeradora);
                }
            }
            return articulosDisponibles;
        } catch (SQLException ex) {
            System.out.println("Error al cargar productos en la db");
            System.out.println(ex);
        }
        return null;
    }
}
