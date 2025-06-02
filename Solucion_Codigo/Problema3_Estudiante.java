// Problema-3_Estudiante.java
public class Problema3_Estudiante {
    private String nombre;
    private int grado;
    private boolean permisoVigente;
    private boolean puedeSubir;
    
    // Constructor por defecto
    public Problema3_Estudiante() {
        this.nombre = "";
        this.grado = 0;
        this.permisoVigente = false;
        this.puedeSubir = false;
    }
    
    // Constructor con parámetros
    public Problema3_Estudiante(String nombre, int grado, boolean permisoVigente) {
        this.nombre = nombre;
        this.grado = grado;
        this.permisoVigente = permisoVigente;
        this.puedeSubir = verificarAcceso();
    }
    
    // Métodos set y get
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setGrado(int grado) {
        this.grado = grado;
    }
    
    public int getGrado() {
        return grado;
    }
    
    public void setPermisoVigente(boolean permisoVigente) {
        this.permisoVigente = permisoVigente;
        this.puedeSubir = verificarAcceso();
    }
    
    public boolean isPermisoVigente() {
        return permisoVigente;
    }
    
    public boolean isPuedeSubir() {
        return puedeSubir;
    }
    
    // Método para verificar si puede acceder al autobús
    private boolean verificarAcceso() {
        // Condiciones: debe tener permiso vigente y estar en grados válidos (1-12)
        if (permisoVigente && grado >= 1 && grado <= 12) {
            return true;
        }
        return false;
    }
    
    // Método toString
    @Override
    public String toString() {
        String estado = puedeSubir ? "AUTORIZADO" : "NO AUTORIZADO";
        String permiso = permisoVigente ? "SÍ" : "NO";
        
        return String.format("Estudiante: %-15s | Grado: %2d | Permiso: %-2s | Estado: %s", 
                           nombre, grado, permiso, estado);
    }
}