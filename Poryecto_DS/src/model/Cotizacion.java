package model;

import model.FactoryMethod.Articulo;
import java.text.SimpleDateFormat;
import java.util.*;

public class Cotizacion {

    private String codigo;
    private Date fecha;
    private float total;

    public Cotizacion() {
    }

    public Cotizacion(Date fecha, float total) {
        this.fecha = fecha;
        this.total = total;
        setCodigo();
    }

    public String getCodigo() {
        return codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getTotal() {
        return total;
    }

    public void calcularTotal(LinkedList<Articulo> listArticulos){
        if (null!=listArticulos) {
            for (Articulo a : listArticulos) {
                total += a.getPrecio();
            }
        }
    }
    
    public void mostrarProductosCotizados(LinkedList<Articulo> listArticulos){
        if (null != listArticulos) {
            for (Articulo a : listArticulos) {
                System.out.println(a.getCategoria() + a.getDescripcion());
            }
        }
    }    
    
    public void setCodigo(){
        SimpleDateFormat formateador1 = new SimpleDateFormat("yyyyMMddhhmmss");                        
        java.util.Date ahora = new java.util.Date();        
        String codigoS = formateador1.format(ahora);
        this.codigo=codigoS;
    }
}
