package model;

/**
 *
 */
public abstract class Articulo {

    /**
     * Default constructor
     */
    public Articulo() {
    }

    /**
     *
     */
    protected int idArticulo;

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     *
     */
    protected String nombre;

    /**
     *
     */
    protected String descripcion;

    /**
     *
     */
    protected String categoria;

    /**
     *
     */
    protected int stock;

    /**
     *
     */
    protected boolean estado;

    /**
     *
     */
    protected float precio;

    /**
     *
     */
    protected String marca;

    /**
     * @return
     */
    public int generarCodigo() {
        // TODO implement here
        return 0;
    }

}
