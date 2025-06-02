// Problema-5_GimnasioEjecutor.java
import java.util.Scanner;

public class Problema5_GimnasioEjecutor {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("--- SISTEMA DE GESTIÓN DE GIMNASIO ---");
        
        // Crear gimnasio
        System.out.print("Ingrese el nombre del gimnasio: ");
        String nombreGimnasio = scanner.nextLine();
        Problema5_Gimnasio gimnasio = new Problema5_Gimnasio(nombreGimnasio);
        
        // Registrar clientes
        registrarClientes(gimnasio);
        
        // Mostrar información completa
        System.out.println("\n" + gimnasio.toString());
        
        // Mostrar estadísticas por tipo
        System.out.println(gimnasio.getEstadisticasPorTipo());
        
        // Mostrar clientes que no completaron
        mostrarClientesNoCompletaron(gimnasio);
        
        // Mostrar resumen final
        System.out.println(gimnasio.mostrarResumenFinal());
        
        scanner.close();
    }
    
    private static void registrarClientes(Problema5_Gimnasio gimnasio) {
        System.out.println("\n--- Registro de Clientes ---");
        System.out.print("¿Cuántos clientes desea registrar?: ");
        int numClientes = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        String[] tiposEjercicio = {"Cardio", "Fuerza", "Estiramiento"};
        
        System.out.println("\nTipos de ejercicio disponibles:");
        for (int i = 0; i < tiposEjercicio.length; i++) {
            System.out.println((i + 1) + ". " + tiposEjercicio[i]);
        }
        
        System.out.println();
        
        // Usar for para registrar clientes
        for (int i = 0; i < numClientes; i++) {
            System.out.println("--- Cliente " + (i + 1) + " ---");
            
            System.out.print("Nombre del cliente: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Seleccione tipo de ejercicio (1-3): ");
            int opcionEjercicio = scanner.nextInt();
            
            String tipoEjercicio;
            if (opcionEjercicio >= 1 && opcionEjercicio <= 3) {
                tipoEjercicio = tiposEjercicio[opcionEjercicio - 1];
            } else {
                tipoEjercicio = "Cardio"; // Por defecto
                System.out.println("Opción inválida. Se asignó Cardio por defecto.");
            }
            
            System.out.print("Duración del ejercicio (minutos): ");
            int duracion = scanner.nextInt();
            
            System.out.print("¿Completó la rutina? (true/false): ");
            boolean completoRutina = scanner.nextBoolean();
            scanner.nextLine(); // Limpiar buffer
            
            // Validaciones básicas
            if (duracion <= 0) {
                System.out.println("Duración inválida. Se asignaron 30 minutos por defecto.");
                duracion = 30;
            }
            
            Problema5_Cliente cliente = new Problema5_Cliente(nombre, tipoEjercicio, duracion, completoRutina);
            gimnasio.agregarCliente(cliente);
            
            System.out.println("Cliente registrado exitosamente!");
            System.out.println();
        }
    }
    
    private static void mostrarClientesNoCompletaron(Problema5_Gimnasio gimnasio) {
        System.out.println("\n--- CLIENTES QUE NO COMPLETARON SU RUTINA ---");
        
        boolean hayIncompletos = false;
        int contador = 0;
        
        // Usar do-while para mostrar clientes que no completaron
        if (!gimnasio.getClientes().isEmpty()) {
            do {
                Problema5_Cliente cliente = gimnasio.getClientes().get(contador);
                
                if (!cliente.isCompletoRutina()) {
                    if (!hayIncompletos) {
                        System.out.println("Los siguientes clientes no completaron su rutina:");
                        System.out.println("─".repeat(60));
                        hayIncompletos = true;
                    }
                    
                    String motivoPosible = obtenerMotivoNoComplecion(cliente);
                    System.out.println("• " + cliente.getNombre() + 
                                     " (" + cliente.getTipoEjercicio() + 
                                     ", " + cliente.getDuracion() + " min) - " + motivoPosible);
                }
                
                contador++;
            } while (contador < gimnasio.getClientes().size());
        }
        
        if (!hayIncompletos) {
            System.out.println("¡Excelente! Todos los clientes completaron su rutina.");
        }
    }
    
    private static String obtenerMotivoNoComplecion(Problema5_Cliente cliente) {
        // Análisis simple basado en duración y tipo
        int duracion = cliente.getDuracion();
        String tipo = cliente.getTipoEjercicio().toLowerCase();
        
        if (duracion < 20) {
            return "Rutina muy corta";
        } else if (duracion > 120) {
            return "Rutina muy larga, posible fatiga";
        } else {
            switch (tipo) {
                case "cardio":
                    return "Posible fatiga cardiovascular";
                case "fuerza":
                    return "Posible fatiga muscular";
                case "estiramiento":
                    return "Rutina incompleta";
                default:
                    return "Motivo no especificado";
            }
        }
    }
}