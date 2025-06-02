// Problema-4_Visitante.java
public class Problema4_Visitante {
    private String nombre;
    private int edad;
    private double altura;
    private String juegoDeseado;
    private boolean puedeAcceder;
    
    // Constructor por defecto
    public Problema4_Visitante() {
        this.nombre = "";
        this.edad = 0;
        this.altura = 0.0;
        this.juegoDeseado = "";
        this.puedeAcceder = false;
    }
    
    // Constructor con parámetros
    public Problema4_Visitante(String nombre, int edad, double altura, String juegoDeseado) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.juegoDeseado = juegoDeseado;
        this.puedeAcceder = false; // Se calculará después
    }
    
    // Métodos set y get
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public double getAltura() {
        return altura;
    }
    
    public void setJuegoDeseado(String juegoDeseado) {
        this.juegoDeseado = juegoDeseado;
    }
    
    public String getJuegoDeseado() {
        return juegoDeseado;
    }
    
    public void setPuedeAcceder(boolean puedeAcceder) {
        this.puedeAcceder = puedeAcceder;
    }
    
    public boolean isPuedeAcceder() {
        return puedeAcceder;
    }
    
    // Método toString
    @Override
    public String toString() {
        String estado = puedeAcceder ? "AUTORIZADO" : "NO AUTORIZADO";
        
        return String.format(
            "Visitante: %-15s | Edad: %2d años | Altura: %.2fm | " +
            "Juego: %-15s | Estado: %s", 
            nombre, edad, altura, juegoDeseado, estado
        );
    }
}