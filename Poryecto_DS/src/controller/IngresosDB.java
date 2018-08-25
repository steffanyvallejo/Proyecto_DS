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
import java.util.LinkedList;
import javax.swing.JOptionPane;
import model.Articulo;
import model.Credito;
import model.Efectivo;
import model.FormaPago;
import model.Vendedor;
import model.Venta;

/**
 *
 * @author EmilioMP
 */
public class IngresosDB {

    private Connection conexion;

    public IngresosDB() {
        this.conexion = new ConexionDBM().establecerConexion(conexion);
    }

    public void agregarClienteDB(String nombre, String apellido, String cedula, Date fech_nac, String telefono, String direccion, String correo) {
        try {
            PreparedStatement pst = conexion.prepareStatement("INSERT INTO t_cliente (Cli_Cedula, Cli_Nombre, Cli_Apellido, Cli_Direccion, Cli_Telefono, Cli_email, Cli_fecha_nacimiento) VALUES (?,?,?,?,?,?,?)");
            pst.setString(1, cedula);
            pst.setString(2, nombre);
            pst.setString(3, apellido);
            pst.setString(4, direccion);
            pst.setString(5, telefono);
            pst.setString(6, correo);
            pst.setDate(7, fech_nac);
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

    public int getIDVendedor(Vendedor vendedor) {
        int id = 0;
        try {
            System.out.println("entra al nombre");
            PreparedStatement pst = conexion.prepareStatement("SELECT * FROM t_usuario WHERE cedula = ?");
            pst.setString(1, vendedor.getCedula());
            ResultSet rs = pst.executeQuery();
            System.out.println("ejecucion del query");
            while (rs.next()) {
                id = rs.getInt("id_user");
            }
            return id;
        } catch (SQLException ex) {
            System.out.println("Error usuario venta");
            System.out.println(ex);
        }
        return id;
    }

    public int getIDCliente(String cedula) {
        int id = 0;
        try {
            System.out.println("entra al nombre");
            PreparedStatement pst = conexion.prepareStatement("SELECT * FROM t_cliente WHERE Cli_Cedula = ?");
            pst.setString(1, cedula);
            ResultSet rs = pst.executeQuery();
            System.out.println("ejecucion del query");
            while (rs.next()) {
                id = rs.getInt("Cli_id");
            }
            return id;
        } catch (SQLException ex) {
            System.out.println("Error cliente venta");
            System.out.println(ex);
        }
        return id;
    }   

    public void ingresarVentaDB(Venta venta, Vendedor vendedor, String cedulaCliente) {
        try {
            PreparedStatement pst = conexion.prepareStatement("INSERT INTO t_venta (Venta_Fecha, Venta_Subtotal, Venta_Total, Cliente_ID, Usua_ID, Venta_Cod) VALUES (?,?,?,?,?,?)");
            pst.setDate(1, Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(venta.getFecha())));
            pst.setDouble(2, venta.getSubtotal());
            pst.setDouble(3, venta.calcularValorTotal());
            pst.setInt(4, getIDCliente(cedulaCliente));
            pst.setInt(5, getIDVendedor(vendedor));
            pst.setString(6, venta.getCodigo());
            int res = pst.executeUpdate();
            if (res > 0) {
                System.out.println("venta bien");
            } else {
                System.out.println("venta mal");
            }
        } catch (SQLException ex) {
            System.out.println("venta mal");
            System.out.println(ex.getMessage());
        }
    }

    public int getIDVenta(Venta venta) {
        int id = 0;
        try {
            System.out.println("entra al nombre");
            PreparedStatement pst = conexion.prepareStatement("SELECT * FROM t_venta WHERE Venta_Cod = ?");
            pst.setString(1, venta.getCodigo());
            ResultSet rs = pst.executeQuery();
            System.out.println("ejecucion del query");
            while (rs.next()) {
                id = rs.getInt("Venta_ID");
            }
            return id;
        } catch (SQLException ex) {
            System.out.println("Error cliente venta");
            System.out.println(ex);
        }
        return id;
    }

    public void ingresarPago(Venta venta, FormaPago fpago) {
        if (fpago instanceof Credito) {
            try {
                PreparedStatement pst = conexion.prepareStatement("INSERT INTO t_pagocredito (PC_Fecha, PC_Subtotal, PC_Impuestos, PC_PagoCorriente, PC_PagoDiferido, PC_MesesDiferidos, Venta_ID) VALUES (?,?,?,?,?,?,?)");              
                pst.setDate(1, Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(venta.getFecha())));
                pst.setDouble(2, venta.getSubtotal());
                pst.setDouble(3, venta.getSubtotal()*0.12);
                if(((Credito) fpago).getModo().equals("Pago corriente")){
                    pst.setBoolean(4, true);
                    pst.setBoolean(5, false);
                    pst.setInt(6, 0);
                    pst.setInt(7, getIDVenta(venta));
                }                
                else if(((Credito) fpago).getModo().equals("Pago diferido")){
                    pst.setBoolean(4, false);
                    pst.setBoolean(5, true);
                    pst.setInt(6, ((Credito) fpago).getMesesDiferido());
                    pst.setInt(7, getIDVenta(venta));
                }
                int res = pst.executeUpdate();
                if (res > 0) {
                    System.out.println("pagoc bien");
                } else {
                    System.out.println("pagoc mal");
                }
            } catch (SQLException ex) {
                System.out.println("pagoc mal");
                System.out.println(ex.getMessage());
            }
        } else if (fpago instanceof Efectivo) {
            try {
                PreparedStatement pst = conexion.prepareStatement("INSERT INTO t_pagoefectivo (PE_Fecha, PE_Subtotal, PE_Impuestos, Venta_ID) VALUES (?,?,?,?)");
                pst.setDate(1, Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(venta.getFecha())));
                pst.setDouble(2, venta.getSubtotal());
                pst.setDouble(3, venta.getSubtotal()*0.12);
                pst.setInt(4, getIDVenta(venta));                
                int res = pst.executeUpdate();
                if (res > 0) {
                    System.out.println("pagoe bien");
                } else {
                    System.out.println("pagoe mal");
                }
            } catch (SQLException ex) {
                System.out.println("pagoe mal");
                System.out.println(ex.getMessage());
            }
        }
    }
    
    
    public int getIDArt(String modelo){
        int id = 0;
        try {
            System.out.println("entra al nombre");
            PreparedStatement pst = conexion.prepareStatement("SELECT * FROM t_articulo WHERE Art_Modelo = ?");
            pst.setString(1, modelo);
            ResultSet rs = pst.executeQuery();
            System.out.println("ejecucion del query");
            while (rs.next()) {
                id = rs.getInt("Art_ID");
            }
            return id;
        } catch (SQLException ex) {
            System.out.println("Error id art");
            System.out.println(ex);
        }
        return id;
    }
    
    public void ingresarDetallesVenta(Venta venta, LinkedList<String> productosC){
        int idV = getIDVenta(venta);
        for(String p: productosC){
            try {
                PreparedStatement pst = conexion.prepareStatement("INSERT INTO t_detalle_venta(Venta_ID, Articulo_ID) VALUES (?,?)");
                pst.setInt(1, idV);
                pst.setInt(2, getIDArt(p));                
                int res = pst.executeUpdate();
                if (res > 0) {
                    System.out.println("detallev bien");
                } else {
                    System.out.println("detallev mal");
                }
            } catch (SQLException ex) {
                System.out.println("detallev mal");
                System.out.println(ex.getMessage());
            }
        }
    }
    public void agregarArticuloDB(Articulo articulo) {
        int idArt= getIDArt(articulo.getModelo());
        try {
            PreparedStatement pst = conexion.prepareStatement("INSERT INTO t_cliente (Art_Modelo, Art_Descripcion,Art_Precio, Art_Stock,Art_Categ, Art_Marca, Art_Color) VALUES (?,?,?,?,?,?,?)");
            pst.setString(1, articulo.getModelo());
            pst.setString(2, articulo.getDescripcion());
            pst.setFloat(3, articulo.getPrecio());
            pst.setInt(4, articulo.getStock());
            pst.setString(5, articulo.getCategoria() );
            pst.setString(6, articulo.getMarca());
            pst.setString(7, articulo.getColor());
            int res = pst.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Articulo registrado con éxito");
                System.out.println("articulo bien");
            } else {
                JOptionPane.showMessageDialog(null, "Articulo no registrado con éxito");
                System.out.println("articulo mal");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el sistema");
            System.out.println("art mal");
            System.out.println(ex.getMessage());
        }
    }
    
}
