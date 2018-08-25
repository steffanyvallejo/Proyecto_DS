/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;

/**
 *
 * @author EmilioMP
 */
public class ReportesDB {
    
    private Connection conexion;
    
    
    public ReportesDB(){
        this.conexion=new ConexionDBM().establecerConexion(conexion);
    }
    
    public LinkedList<LinkedList<String>> reporteVendedor() {        
        Calendar c = Calendar.getInstance();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        c.add(Calendar.DATE, -7);
        java.util.Date pasado = c.getTime();
        java.util.Date ahora = new java.util.Date();
        String pasadoS = formateador.format(pasado);
        String ahoraS = formateador.format(ahora);
        
        LinkedList<LinkedList<String>> datos = new LinkedList<LinkedList<String>>();
        
        try {
            System.out.println("entra al nombre");
            PreparedStatement pst = conexion.prepareStatement("select v.Usua_ID as id, u.nombre as nombre, count(*) as cantidad, sum(v.Venta_Total) as total from t_usuario u, t_venta v where v.Usua_ID = u.id_user and v.Venta_Fecha between ? and ? group by v.Usua_ID;");        
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
                
        LinkedList<LinkedList<String>> datos = new LinkedList<LinkedList<String>>();
        
        try {
            System.out.println("entra al nombre");
            PreparedStatement pst = conexion.prepareStatement("select dv.Articulo_ID as id, a.Art_Modelo as nombre, count(*) as cantidad, sum(v.Venta_Total) as total from t_articulo a, t_venta v, t_detalle_venta dv where dv.Venta_ID = v.Venta_ID and dv.Articulo_ID = a.Art_ID and v.Venta_Fecha between ? and ? group by dv.Articulo_ID;");        
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