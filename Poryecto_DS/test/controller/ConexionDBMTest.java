/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eduar
 */
public class ConexionDBMTest {
    
    public ConexionDBMTest() {
    }
    /**
     * Test of establecerConexion method, of class ConexionDBM.
     */
    @Test
    public void testEstablecerConexion() {
        System.out.println("establecerConexion");
        Connection conexion = null;
        ConexionDBM instance = new ConexionDBM();
        Connection expResult = null;
        Connection result = instance.establecerConexion(conexion);
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of cerrarConexion method, of class ConexionDBM.
     */
    @Test
    public void testCerrarConexion() {
        System.out.println("cerrarConexion");
        Connection conexion = null;
        ConexionDBM instance = new ConexionDBM();
        instance.cerrarConexion(conexion);
    }
    
}
