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
            ResultSet resultados = pst.executeQuery();
            while (resultados.next()) {
                String t = resultados.getString("tipo");
                if (t.equals("v")) {
                    Vendedor v = new Vendedor();
                    v.setNombre(resultados.getString("nombre"));
                    v.setApellido(resultados.getString("apellido"));
                    v.setFechaNacimiento(resultados.getDate("fecha_nacimiento"));
                    v.setNumeroTelefonico(resultados.getString("telefono"));
                    v.setDirecciónDomicilio(resultados.getString("direccion"));
                    v.setCorreoElectronico(resultados.getString("correo"));
                    v.setUsuario(resultados.getString("usuario"));
                    v.setContraseña(resultados.getString("pass"));
                    v.setTipo(resultados.getString("tipo"));
                    v.setIsSuper(resultados.getBoolean("esSuper"));
                    v.setCedula(resultados.getString("cedula"));
                    pst.close();
                    resultados.close();
                    return v;
                } else if (t.equals("g")) {
                    Gerente g = new Gerente();
                    g.setNombre(resultados.getString("nombre"));
                    g.setApellido(resultados.getString("apellido"));
                    g.setFechaNacimiento(resultados.getDate("fecha_nacimiento"));
                    g.setNumeroTelefonico(resultados.getString("telefono"));
                    g.setDirecciónDomicilio(resultados.getString("direccion"));
                    g.setCorreoElectronico(resultados.getString("correo"));
                    g.setUsuario(resultados.getString("usuario"));
                    g.setContraseña(resultados.getString("pass"));
                    g.setTipo(resultados.getString("tipo"));
                    g.setIsSuper(resultados.getBoolean("esSuper"));
                    g.setCedula(resultados.getString("cedula"));
                    pst.close();
                    resultados.close();
                    return g;
                } else if (t.equals("a")) {
                    Administrador a = new Administrador();
                    a.setNombre(resultados.getString("nombre"));
                    a.setApellido(resultados.getString("apellido"));
                    a.setFechaNacimiento(resultados.getDate("fecha_nacimiento"));
                    a.setNumeroTelefonico(resultados.getString("telefono"));
                    a.setDirecciónDomicilio(resultados.getString("direccion"));
                    a.setCorreoElectronico(resultados.getString("correo"));
                    a.setUsuario(resultados.getString("usuario"));
                    a.setContraseña(resultados.getString("pass"));
                    a.setTipo(resultados.getString("tipo"));
                    a.setIsSuper(resultados.getBoolean("esSuper"));
                    a.setCedula(resultados.getString("cedula"));
                    pst.close();
                    resultados.close();
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
