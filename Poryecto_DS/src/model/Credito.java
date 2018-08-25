package model;

import java.util.*;

/**
 *
 */
public class Credito extends FormaPago implements PagoStrategy{

    private String modo;
    private int mesesDiferido;

    public Credito() {
    }        
    
    public Credito(String modo, int mesesDiferido) {      
        this.modo = modo;
        this.mesesDiferido = mesesDiferido;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public int getMesesDiferido() {
        return mesesDiferido;
    }

    public void setMesesDiferido(int mesesDiferido) {
        this.mesesDiferido = mesesDiferido;
    }

    @Override
    public void pagar(float total) {
        System.out.println("Pagando con tarjeta de crédito...");
    }
}
