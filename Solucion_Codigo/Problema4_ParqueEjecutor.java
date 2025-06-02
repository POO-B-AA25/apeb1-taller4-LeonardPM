// Problema-4_ParqueEjecutor.java
import java.util.Scanner;

public class Problema4_ParqueEjecutor {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("--- SISTEMA DE CONTROL DE PARQUE DE DIVERSIONES ---");
        
        // Crear parque
        System.out.print("Ingrese el nombre del parque: ");
        String nombreParque = scanner.nextLine();
        Problema4_Parque parque = new Problema4_Parque(nombreParque);
        
        // Registrar visitantes
        registrarVisitantes(parque);
        
        // Procesar accesos
        System.out.println("\n--- PROCESANDO ACCESOS ---");
        parque.procesarVisitantes();
        
        // Mostrar resultados
        System.out.println(parque.toString());
        
        // Mostrar visitantes no autorizados
        mostrarVisitantesRechazados(parque);
        
        // Mostrar estadísticas finales
        System.out.println(parque.mostrarEstadisticas());
        
        scanner.close();
    }
    
    private static void registrarVisitantes(Problema4_Parque parque) {
        System.out.println("\n--- Registro de Visitantes ---");
        System.out.print("¿Cuántos visitantes desea registrar?: ");
        int numVisitantes = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        String[] juegosDisponibles = {
            "Montaña Rusa", "Rueda Gigante", "Carros Chocones", 
            "Casa del Terror", "Juegos Infantiles", "Otros"
        };
        
        System.out.println("\nJuegos disponibles:");
        for (int i = 0; i < juegosDisponibles.length; i++) {
            System.out.println((i + 1) + ". " + juegosDisponibles[i]);
        }
        
        // Usar for para registrar visitantes
        for (int i = 0; i < numVisitantes; i++) {
            System.out.println("\n--- Visitante " + (i + 1) + " ---");
            
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            
            System.out.print("Altura (en metros): ");
            double altura = scanner.nextDouble();
            scanner.nextLine(); // Limpiar buffer
            
            System.out.print("Seleccione el juego deseado (1-6): ");
            int opcionJuego = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            String juegoSeleccionado;
            if (opcionJuego >= 1 && opcionJuego <= juegosDisponibles.length) {
                juegoSeleccionado = juegosDisponibles[opcionJuego - 1];
            } else {
                juegoSeleccionado = "Otros";
            }
            
            Problema4_Visitante visitante = new Problema4_Visitante(nombre, edad, altura, juegoSeleccionado);
            parque.agregarVisitante(visitante);
            
            System.out.println("Visitante registrado exitosamente!");
        }
    }
    
    private static void mostrarVisitantesRechazados(Problema4_Parque parque) {
        System.out.println("\n--- VISITANTES NO AUTORIZADOS ---");
        
        boolean hayRechazados = false;
        int contador = 0;
        
        // Usar while para mostrar rechazados
        while (contador < parque.getVisitantes().size()) {
            Problema4_Visitante visitante = parque.getVisitantes().get(contador);
            
            if (!visitante.isPuedeAcceder()) {
                if (!hayRechazados) {
                    System.out.println("Los siguientes visitantes no cumplen los requisitos:");
                    hayRechazados = true;
                }
                
                String razon = determinarRazonRechazo(visitante);
                System.out.println("- " + visitante.getNombre() + 
                                 " (Edad: " + visitante.getEdad() + 
                                 ", Altura: " + visitante.getAltura() + "m) - " + razon);
            }
            contador++;
        }
        
        if (!hayRechazados) {
            System.out.println("¡Todos los visitantes fueron autorizados!");
        }
    }
    
    private static String determinarRazonRechazo(Problema4_Visitante visitante) {
        String juego = visitante.getJuegoDeseado().toLowerCase();
        int edad = visitante.getEdad();
        double altura = visitante.getAltura();
        
        // Determinar la razón específica del rechazo
        switch (juego) {
            case "montaña rusa":
                if (edad < 12) return "Edad mínima: 12 años";
                if (altura < 1.40) return "Altura mínima: 1.40m";
                break;
            case "rueda gigante":
                if (edad < 8) return "Edad mínima: 8 años";
                if (altura < 1.20) return "Altura mínima: 1.20m";
                break;
            case "carros chocones":
                if (edad < 6) return "Edad mínima: 6 años";
                if (altura < 1.10) return "Altura mínima: 1.10m";
                break;
            case "casa del terror":
                if (edad < 10) return "Edad mínima: 10 años";
                if (altura < 1.30) return "Altura mínima: 1.30m";
                break;
            case "juegos infantiles":
                if (edad < 3) return "Edad mínima: 3 años";
                if (altura < 0.90) return "Altura mínima: 0.90m";
                break;
            default:
                if (edad < 5) return "Edad mínima: 5 años";
                if (altura < 1.00) return "Altura mínima: 1.00m";
        }
        
        return "No cumple requisitos";
    }
} 