// Problema-2_EmpleadoEjecutor.java
import java.util.ArrayList;
import java.util.Scanner;

public class Problema2_EmpleadoEjecutor {
    private static ArrayList<Problema2_Empleado> empleados = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opcion;
        
        System.out.println("--- SISTEMA DE GESTIÓN DE EMPLEADOS ---");
        
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    agregarEmpleado();
                    break;
                case 2:
                    mostrarEmpleados();
                    break;
                case 3:
                    calcularAumentoSalario();
                    break;
                case 4:
                    System.out.println("¡Gracias por usar el sistema!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
            
        } while (opcion != 4);
        
        scanner.close();
    }
    
    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Agregar empleado");
        System.out.println("2. Mostrar información de empleados");
        System.out.println("3. Calcular aumento de salario");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    private static void agregarEmpleado() {
        System.out.println("\n--- Agregar Nuevo Empleado ---");
        
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Ingrese el salario: $");
        double salario = scanner.nextDouble();
        
        System.out.print("Ingrese la edad: ");
        int edad = scanner.nextInt();
        
        if (salario <= 0 || edad <= 0) {
            System.out.println("Error: El salario y la edad deben ser mayores a 0");
            return;
        }
        
        Problema2_Empleado empleado = new Problema2_Empleado(nombre, salario, edad);
        empleados.add(empleado);
        
        System.out.println("Empleado agregado exitosamente!");
    }
    
    private static void mostrarEmpleados() {
        System.out.println("\n--- Lista de Empleados ---");
        
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        
        System.out.println("Total de empleados: " + empleados.size());
        System.out.println("----------------------------------------");
        
        for (int i = 0; i < empleados.size(); i++) {
            System.out.println((i + 1) + ". " + empleados.get(i).toString());
        }
    }
    
    private static void calcularAumentoSalario() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados para calcular aumentos.");
            return;
        }
        
        System.out.print("\nIngrese el porcentaje de aumento salarial: ");
        double porcentajeAumento = scanner.nextDouble();
        
        if (porcentajeAumento <= 0) {
            System.out.println("El porcentaje debe ser mayor a 0");
            return;
        }
        
        // Calcular salario promedio usando for
        double sumaTotal = 0.0;
        for (int i = 0; i < empleados.size(); i++) {
            sumaTotal += empleados.get(i).getSalario();
        }
        double salarioPromedio = sumaTotal / empleados.size();
        
        System.out.printf("\nSalario promedio actual: $%.2f\n", salarioPromedio);
        System.out.println("Empleados que recibirán aumento:");
        System.out.println("----------------------------------------");
        
        int contador = 0;
        // Aplicar aumento usando while
        int i = 0;
        while (i < empleados.size()) {
            Problema2_Empleado emp = empleados.get(i);
            if (emp.getSalario() < salarioPromedio) {
                double salarioAnterior = emp.getSalario();
                emp.aplicarAumento(porcentajeAumento);
                
                System.out.printf("%s: $%.2f -> $%.2f\n", 
                                emp.getNombre(), salarioAnterior, emp.getSalario());
                contador++;
            }
            i++;
        }
        
        // Mostrar resumen usando do-while
        if (contador > 0) {
            System.out.println("----------------------------------------");
            System.out.println("Total de empleados con aumento: " + contador);
        } else {
            System.out.println("Ningún empleado califica para aumento.");
        }
    }
}