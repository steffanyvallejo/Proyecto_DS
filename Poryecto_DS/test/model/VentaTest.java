/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
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
public class VentaTest {
    
    public VentaTest() {
    }
 
    /**
     * Test of calcularValorTotal method, of class Venta.
     */
    @Test
    public void testCalcularValorTotalEquals() {
        Venta instance = new Venta();
        instance.setSubtotal(400);
        double result = instance.calcularValorTotal();
        assertEquals(448.0, result, 0.0);
        
    }
    
    
    
}
