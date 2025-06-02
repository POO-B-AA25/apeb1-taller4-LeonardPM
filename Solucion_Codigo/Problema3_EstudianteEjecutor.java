// Problema-3_EstudianteEjecutor.java
import java.util.ArrayList;
import java.util.Scanner;

public class Problema3_EstudianteEjecutor {
    private static ArrayList<Problema3_Estudiante> estudiantes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int aceptados = 0;
    private static int rechazados = 0;
    
    public static void main(String[] args) {
        System.out.println("--- SISTEMA DE CONTROL DE AUTOBÚS ESCOLAR ---");
        
        registrarEstudiantes();
        simularIngresoEstudiantes();
        mostrarResumen();
        
        scanner.close();
    }
    
    private static void registrarEstudiantes() {
        System.out.println("\n--- Registro de Estudiantes ---");
        System.out.print("¿Cuántos estudiantes desea registrar?: ");
        int numEstudiantes = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        for (int i = 0; i < numEstudiantes; i++) {
            System.out.println("\n--- Estudiante " + (i + 1) + " ---");
            
            System.out.print("Nombre del estudiante: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Grado (1-12): ");
            int grado = scanner.nextInt();
            
            System.out.print("¿Tiene permiso vigente? (true/false): ");
            boolean permiso = scanner.nextBoolean();
            scanner.nextLine(); // Limpiar buffer
            
            Problema3_Estudiante estudiante = new Problema3_Estudiante(nombre, grado, permiso);
            estudiantes.add(estudiante);
            
            System.out.println("Estudiante registrado: " + estudiante.toString());
        }
    }
    
    private static void simularIngresoEstudiantes() {
        System.out.println("\n--- SIMULACIÓN DE INGRESO AL AUTOBÚS ---");
        System.out.println("Verificando acceso de estudiantes...\n");
        
        // Usar diferentes tipos de ciclos
        // For para mostrar todos los estudiantes
        for (int i = 0; i < estudiantes.size(); i++) {
            Problema3_Estudiante estudiante = estudiantes.get(i);
            System.out.println((i + 1) + ". " + estudiante.toString());
            
            if (estudiante.isPuedeSubir()) {
                aceptados++;
            } else {
                rechazados++;
            }
        }
        
        System.out.println("\n--- Proceso de Verificación Completado ---");
        
        // While para mostrar solo los rechazados
        System.out.println("\nEstudiantes NO AUTORIZADOS:");
        int j = 0;
        while (j < estudiantes.size()) {
            Problema3_Estudiante estudiante = estudiantes.get(j);
            if (!estudiante.isPuedeSubir()) {
                System.out.println("- " + estudiante.getNombre() + 
                                 " (Grado: " + estudiante.getGrado() + 
                                 ", Permiso: " + (estudiante.isPermisoVigente() ? "SÍ" : "NO") + ")");
            }
            j++;
        }
        
        // Do-while para confirmación
        String continuar;
        do {
            System.out.print("\n¿Desea ver el resumen final? (s/n): ");
            continuar = scanner.nextLine().toLowerCase();
        } while (!continuar.equals("s") && !continuar.equals("n"));
        
        if (continuar.equals("n")) {
            System.out.println("Finalizando sistema...");
        }
    }
    
    private static void mostrarResumen() {
        System.out.println("\n--- RESUMEN FINAL DEL DÍA ---");
        System.out.println("Total de estudiantes procesados: " + estudiantes.size());
        System.out.println("Estudiantes ACEPTADOS: " + aceptados);
        System.out.println("Estudiantes RECHAZADOS: " + rechazados);
        
        if (estudiantes.size() > 0) {
            double porcentajeAceptados = (double) aceptados / estudiantes.size() * 100;
            System.out.printf("Porcentaje de aceptación: %.1f%%\n", porcentajeAceptados);
        }
        
        System.out.println("\n--- Fin del Sistema de Control ---");
    }
}