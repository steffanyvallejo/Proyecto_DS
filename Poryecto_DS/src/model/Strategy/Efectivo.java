package model.Strategy;

import model.Strategy.PagoStrategy;
import model.Strategy.FormaPago;

public class Efectivo extends FormaPago implements PagoStrategy {

    public Efectivo() {
    }

    @Override
    public void pagar(float total) {        
        System.out.println("Pagando en efectivo...");
    }
}
