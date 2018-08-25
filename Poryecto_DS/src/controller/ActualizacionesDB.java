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
import javax.swing.JOptionPane;
import model.CocinaInduccion;
import model.Lavadora;
import model.Refrigeradora;

/**
 *
 * @author EmilioMP
 */
public class ActualizacionesDB {
     private Connection conexion;
    
    
    public ActualizacionesDB(){        
        this.conexion = new ConexionDBM().establecerConexion(conexion);
    }
    
    public LinkedList<String> datosActualizarVenta(String codigo){
        LinkedList<String> datos = new LinkedList<>();
        try {
            System.out.println("entra al nombre");
            PreparedStatement pst = conexion.prepareStatement("SELECT * FROM t_venta WHERE Venta_Cod = ?");           
            pst.setString(1, codigo);
            ResultSet rs = pst.executeQuery();
            System.out.println("ejecucion del query");
            while (rs.next()) {
                datos.add(String.valueOf(rs.getDouble("Venta_Subtotal")));
                datos.add(String.valueOf(rs.getDouble("Venta_Total")));                
            }
            return datos;
        } catch (SQLException ex) {
            System.out.println("Error al cargar productos en la db");
            System.out.println(ex);
        }return null;
    }
    
    public void actualizarVenta(String codigo, Double subtotal, Double total){
        try {
            PreparedStatement pst = conexion.prepareStatement("UPDATE t_venta SET Venta_Subtotal = ?, Venta_Total = ? WHERE Venta_Cod = ?");
            pst.setDouble(1, subtotal);
            pst.setDouble(2, total);
            pst.setString(3, codigo);            
            int res = pst.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "VENTA ACTUALIZADA EXITOSAMENTE!");
                System.out.println("actv bien");
            } else {
                JOptionPane.showMessageDialog(null, "VENTA NO ACTUALIZADA EXITOSAMENTE!");
                System.out.println("actv mal");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "VENTA NO ACTUALIZADA EXITOSAMENTE!");
            System.out.println("actv mal");
            System.out.println(ex.getMessage());
        }
    }
}
