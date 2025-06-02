// Problema-5_Cliente.java
public class Problema5_Cliente {
    private String nombre;
    private String tipoEjercicio;
    private int duracion; // en minutos
    private boolean completoRutina;
    
    // Constructor por defecto
    public Problema5_Cliente() {
        this.nombre = "";
        this.tipoEjercicio = "";
        this.duracion = 0;
        this.completoRutina = false;
    }
    
    // Constructor con parámetros
    public Problema5_Cliente(String nombre, String tipoEjercicio, int duracion, boolean completoRutina) {
        this.nombre = nombre;
        this.tipoEjercicio = tipoEjercicio;
        this.duracion = duracion;
        this.completoRutina = completoRutina;
    }
    
    // Métodos set y get
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setTipoEjercicio(String tipoEjercicio) {
        this.tipoEjercicio = tipoEjercicio;
    }
    
    public String getTipoEjercicio() {
        return tipoEjercicio;
    }
    
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    public int getDuracion() {
        return duracion;
    }
    
    public void setCompletoRutina(boolean completoRutina) {
        this.completoRutina = completoRutina;
    }
    
    public boolean isCompletoRutina() {
        return completoRutina;
    }
    
    // Método para obtener clasificación de duración
    public String getClasificacionDuracion() {
        if (duracion < 30) {
            return "Corta";
        } else if (duracion <= 60) {
            return "Media";
        } else {
            return "Larga";
        }
    }
    
    // Método toString
    @Override
    public String toString() {
        String estado = completoRutina ? "COMPLETADA" : "NO COMPLETADA";
        
        return String.format(
            "Cliente: %-15s | Ejercicio: %-12s | Duración: %3d min (%s) | Estado: %s",
            nombre, tipoEjercicio, duracion, getClasificacionDuracion(), estado
        );
    }
}