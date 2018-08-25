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
    
    
    public CargasDB(){        
        this.conexion = new ConexionDBM().establecerConexion(conexion);
    }
    
    public Empleado login(String user, String pass) {        
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

    public LinkedList<Articulo> cargarArticulos(){
        LinkedList<Articulo> articulosDisponibles = new LinkedList<Articulo>();        
        System.out.println("conecta db para buscar c");
        try {
            System.out.println("entra al nombre");
            PreparedStatement pst = conexion.prepareStatement("SELECT * FROM t_articulo");           
            ResultSet rs = pst.executeQuery();
            System.out.println("ejecucion del query");
            while (rs.next()) {
                if(rs.getString("Art_Categ").equals("cocina")){
                    CocinaInduccion cocina = new CocinaInduccion(rs.getString("Art_Modelo"), rs.getString("Art_Marca"), rs.getString("Art_Categ"), rs.getString("Art_Color"), rs.getFloat("Art_Precio"), rs.getInt("Art_Stock"));                    
                    articulosDisponibles.add(cocina);
                    
                }else if(rs.getString("Art_Categ").equals("lavadora")){
                    Lavadora lavadora = new Lavadora(rs.getString("Art_Modelo"), rs.getString("Art_Marca"), rs.getString("Art_Categ"), rs.getString("Art_Color"), rs.getFloat("Art_Precio"), rs.getInt("Art_Stock"));
                    articulosDisponibles.add(lavadora);
                    
                }else if(rs.getString("Art_Categ").equals("refrigeradora")){
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
