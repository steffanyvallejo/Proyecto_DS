package model;

import java.util.*;

/**
 * 
 */
public abstract class Persona {

	/**
	 * Default constructor
	 */
	public Persona() {
	}
        protected String id;

    
	protected String nombre;
	protected String apellido;
	protected Date fechaNacimiento;
	protected String numeroTelefonico;
	protected String direcciónDomicilio;
	protected String correoElectronico;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getDirecciónDomicilio() {
        return direcciónDomicilio;
    }

    public void setDirecciónDomicilio(String direcciónDomicilio) {
        this.direcciónDomicilio = direcciónDomicilio;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }








}