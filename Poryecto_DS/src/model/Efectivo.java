package model;

import java.util.*;

/**
 *
 */
public class Efectivo extends FormaPago implements PagoStrategy {

    public Efectivo() {
    }

    @Override
    public void pagar(float total) {        
        System.out.println("Pagando en efectivo...");
    }
}
