
package Modelo;


public class Productos {
    private int id;
    private String codigo;
    private String nombre;
    private int categoria;
    private String categoriaPro;
    private int stock;
    private double precio;
    
    public Productos(){
        
    }

    public Productos(int id, String codigo, String nombre, int categoria, String categoriaPro, int stock, double precio) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.categoriaPro = categoriaPro;
        this.stock = stock;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getCategoriaPro() {
        return categoriaPro;
    }

    public void setCategoriaPro(String categoriaPro) {
        this.categoriaPro = categoriaPro;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

   
}
