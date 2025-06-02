// Problema-2_Empleado.java
public class Problema2_Empleado {
    private String nombre;
    private double salario;
    private int edad;
    
    // Constructor por defecto
    public Problema2_Empleado() {
        this.nombre = "";
        this.salario = 0.0;
        this.edad = 0;
    }
    
    // Constructor con parámetros
    public Problema2_Empleado(String nombre, double salario, int edad) {
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
    }
    
    // Métodos set y get
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public double getSalario() {
        return salario;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public int getEdad() {
        return edad;
    }
    
    // Método para aplicar aumento
    public void aplicarAumento(double porcentaje) {
        double aumento = salario * (porcentaje / 100);
        this.salario += aumento;
    }
    
    // Método toString (mostrarInformacion)
    @Override
    public String toString() {
        return String.format("Nombre: %-20s | Salario: $%8.2f | Edad: %d años", 
                           nombre, salario, edad);
    }
}