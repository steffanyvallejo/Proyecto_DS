/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Steffany
 */
public class ArticuloFactory implements ArticuloFactoryMethod{

    @Override
    public Articulo crearArticulo(String modelo, String marca, String categoria, String color, float precio, int stock) {
        if(categoria.equalsIgnoreCase("refrigeradora")){
            return new Refrigeradora(modelo,marca,categoria,color,precio,stock);
        }
        else if(categoria.equalsIgnoreCase("cocina")){
            return new CocinaInduccion(modelo,marca,categoria,color,precio,stock);
          
        }
        else if(categoria.equalsIgnoreCase("lavadora")){
            return new Lavadora(modelo,marca,categoria,color,precio,stock);
          
        }
        return null;
    }
    
}
