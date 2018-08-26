package model;

import java.util.Date;

public class Cliente extends Persona {

    public Cliente() {       
    }        

    public Cliente(String nombre, String apellido, Date fechaNacimiento, String numeroTelefonico, String direcciónDomicilio, String correoElectronico, String cedula) {
        super(nombre, apellido, fechaNacimiento, numeroTelefonico, direcciónDomicilio, correoElectronico, cedula);
    }        
}
