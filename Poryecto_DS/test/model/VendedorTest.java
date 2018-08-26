/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.LinkedList;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author Ginger Jacome
 */
public class VendedorTest extends TestCase{
    
    public VendedorTest() {
    }
    
    
    /**
     * Test of consultarCliente method, of class Vendedor.
     */
//    @Test
//    public void testConsultarClienteEquals() {
//        String cedula = "1234567890";
//        Vendedor instance = new Vendedor();
//        LinkedList<String> datos=new LinkedList<>();
//        //Cliente que tengan en su base de datos
//        datos.add("ginger");
//        datos.add("jaco");
//        datos.add("1234543234");
//        datos.add("san carlos");
//        datos.add("ging@espol.edu.ec");
//        LinkedList<String> result = instance.consultarCliente(cedula);
//        assertEquals(datos, result);
//    }
    /**
     * Test of consultarArticulo method, of class Vendedor.
     */
    @Test
    public void testConsultarArticulo() {
        String modo = "";
        String campo = "";
        Vendedor instance = new Vendedor();
        LinkedList<LinkedList<String>> result = instance.consultarArticulo(modo, campo);
        assertNull(result);
    }
    
//    @Test
//    public void testConsultarClienteEmpty(){
//        String cedula = "dgd";
//        Vendedor instance = new Vendedor();
//        LinkedList<String> result = instance.consultarCliente(cedula);
//        assertTrue(result.isEmpty());
//    }
    
}
