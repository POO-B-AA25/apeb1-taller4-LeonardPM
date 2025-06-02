// Problema-1_Producto.java
public class Problema1_Producto {
    private double precio;
    private int numeroProductos;
    private double descuento;
    private double precioFinal;
    
    // Constructor
    public Problema1_Producto() {
        this.precio = 0.0;
        this.numeroProductos = 0;
        this.descuento = 0.0;
        this.precioFinal = 0.0;
    }
    
    // Constructor con parámetros
    public Problema1_Producto(double precio, int numeroProductos) {
        this.precio = precio;
        this.numeroProductos = numeroProductos;
        this.descuento = calcularDescuento(precio, numeroProductos);
        this.precioFinal = calcularPrecioFinal();
    }
    
    // Métodos set y get
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setNumeroProductos(int numeroProductos) {
        this.numeroProductos = numeroProductos;
    }
    
    public int getNumeroProductos() {
        return numeroProductos;
    }
    
    public double getDescuento() {
        return descuento;
    }
    
    public double getPrecioFinal() {
        return precioFinal;
    }
    
    // Método para calcular el descuento
    public double calcularDescuento(double precio, int numeroProductos) {
        double porcentajeDescuento = 0.0;
        
        if (precio >= 1000 && numeroProductos >= 10) {
            porcentajeDescuento = 0.10; // 10% de descuento
        } else if (precio < 1000) {
            porcentajeDescuento = 0.05; // 5% de descuento
        }
        
        this.descuento = (precio * numeroProductos) * porcentajeDescuento;
        return this.descuento;
    }
    
    // Método para calcular el precio final
    public double calcularPrecioFinal() {
        double precioTotal = precio * numeroProductos;
        this.precioFinal = precioTotal - descuento;
        return this.precioFinal;
    }
    
    // Método toString para mostrar información
    @Override
    public String toString() {
        double precioTotal = precio * numeroProductos;
        double porcentaje = (descuento / precioTotal) * 100;
        
        return String.format(
            "--- DETALLE DE COMPRA ---\n" +
            "Precio unitario: $%.2f\n" +
            "Cantidad de productos: %d\n" +
            "Precio total: $%.2f\n" +
            "Descuento aplicado: %.0f%% ($%.2f)\n" +
            "Precio final: $%.2f",
            precio, numeroProductos, precioTotal, porcentaje, descuento, precioFinal
        );
    }
}