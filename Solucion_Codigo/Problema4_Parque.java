// Problema-4_Parque.java
import java.util.ArrayList;

public class Problema4_Parque {
    private String nombreParque;
    private ArrayList<Problema4_Visitante> visitantes;
    private int visitantesAutorizados;
    private int visitantesRechazados;
    
    // Constructor
    public Problema4_Parque(String nombreParque) {
        this.nombreParque = nombreParque;
        this.visitantes = new ArrayList<>();
        this.visitantesAutorizados = 0;
        this.visitantesRechazados = 0;
    }
    
    // Métodos set y get
    public void setNombreParque(String nombreParque) {
        this.nombreParque = nombreParque;
    }
    
    public String getNombreParque() {
        return nombreParque;
    }
    
    public ArrayList<Problema4_Visitante> getVisitantes() {
        return visitantes;
    }
    
    public int getVisitantesAutorizados() {
        return visitantesAutorizados;
    }
    
    public int getVisitantesRechazados() {
        return visitantesRechazados;
    }
    
    // Método para agregar visitante
    public void agregarVisitante(Problema4_Visitante visitante) {
        visitantes.add(visitante);
    }
    
    // Método para verificar acceso según el juego
    public boolean verificarAcceso(Problema4_Visitante visitante) {
        String juego = visitante.getJuegoDeseado().toLowerCase();
        int edad = visitante.getEdad();
        double altura = visitante.getAltura();
        
        boolean puedeAcceder = false;
        
        // Restricciones por juego
        switch (juego) {
            case "montaña rusa":
                puedeAcceder = (edad >= 12 && altura >= 1.40);
                break;
            case "rueda gigante":
                puedeAcceder = (edad >= 8 && altura >= 1.20);
                break;
            case "carros chocones":
                puedeAcceder = (edad >= 6 && altura >= 1.10);
                break;
            case "casa del terror":
                puedeAcceder = (edad >= 10 && altura >= 1.30);
                break;
            case "juegos infantiles":
                puedeAcceder = (edad >= 3 && altura >= 0.90);
                break;
            default:
                puedeAcceder = (edad >= 5 && altura >= 1.00);
        }
        
        visitante.setPuedeAcceder(puedeAcceder);
        
        if (puedeAcceder) {
            visitantesAutorizados++;
        } else {
            visitantesRechazados++;
        }
        
        return puedeAcceder;
    }
    
    // Método para procesar todos los visitantes
    public void procesarVisitantes() {
        // Reiniciar contadores
        visitantesAutorizados = 0;
        visitantesRechazados = 0;
        
        for (Problema4_Visitante visitante : visitantes) {
            verificarAcceso(visitante);
        }
    }
    
    // Método para mostrar estadísticas
    public String mostrarEstadisticas() {
        if (visitantes.isEmpty()) {
            return "No hay visitantes registrados.";
        }
        
        double porcentajeAutorizados = (double) visitantesAutorizados / visitantes.size() * 100;
        
        return String.format(
            "\n--- ESTADÍSTICAS DEL PARQUE ---\n" +
            "Parque: %s\n" +
            "Total de visitantes: %d\n" +
            "Visitantes autorizados: %d\n" +
            "Visitantes rechazados: %d\n" +
            "Porcentaje de autorización: %.1f%%",
            nombreParque, visitantes.size(), visitantesAutorizados, 
            visitantesRechazados, porcentajeAutorizados
        );
    }
    
    // Método toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- PARQUE DE DIVERSIONES: ").append(nombreParque.toUpperCase()).append(" ---\n");
        
        if (visitantes.isEmpty()) {
            sb.append("No hay visitantes registrados.\n");
        } else {
            sb.append("Lista de visitantes:\n");
            for (int i = 0; i < visitantes.size(); i++) {
                sb.append(String.format("%d. %s\n", (i + 1), visitantes.get(i).toString()));
            }
        }
        
        return sb.toString();
    }
}