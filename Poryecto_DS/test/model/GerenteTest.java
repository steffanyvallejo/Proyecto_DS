/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ginger Jacome
 */
public class GerenteTest {
    
    public GerenteTest() {
    }
    

    /**
     * Test of generarReporteVendedor method, of class Gerente.
     */
    @Test
    public void testGenerarReporteVendedor() {
        Gerente instance = new Gerente();
        LinkedList<LinkedList<String>> expResult = null;
        LinkedList<LinkedList<String>> result = instance.generarReporteVendedor();
        assertNotSame(expResult, result);
        
    }

    /**
     * Test of generarReporteArticulo method, of class Gerente.
     */
    @Test
    public void testGenerarReporteArticulo() {
        Gerente instance = new Gerente();
        LinkedList<LinkedList<String>> result = instance.generarReporteArticulo();
        assertNotNull(result);
    }
    
}
