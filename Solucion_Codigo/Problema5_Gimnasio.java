// Problema-5_Gimnasio.java
import java.util.ArrayList;

public class Problema5_Gimnasio {
    private String nombreGimnasio;
    private ArrayList<Problema5_Cliente> clientes;
    private int clientesCompletaron;
    private double tiempoPromedio;
    
    // Constructor
    public Problema5_Gimnasio(String nombreGimnasio) {
        this.nombreGimnasio = nombreGimnasio;
        this.clientes = new ArrayList<>();
        this.clientesCompletaron = 0;
        this.tiempoPromedio = 0.0;
    }
    
    // Métodos set y get
    public void setNombreGimnasio(String nombreGimnasio) {
        this.nombreGimnasio = nombreGimnasio;
    }
    
    public String getNombreGimnasio() {
        return nombreGimnasio;
    }
    
    public ArrayList<Problema5_Cliente> getClientes() {
        return clientes;
    }
    
    public int getClientesCompletaron() {
        return clientesCompletaron;
    }
    
    public double getTiempoPromedio() {
        return tiempoPromedio;
    }
    
    // Método para agregar cliente
    public void agregarCliente(Problema5_Cliente cliente) {
        clientes.add(cliente);
    }
    
    // Método para calcular estadísticas
    public void calcularEstadisticas() {
        if (clientes.isEmpty()) {
            clientesCompletaron = 0;
            tiempoPromedio = 0.0;
            return;
        }
        
        int totalCompletaron = 0;
        int tiempoTotal = 0;
        
        // Usar for para contar completados y sumar tiempos
        for (int i = 0; i < clientes.size(); i++) {
            Problema5_Cliente cliente = clientes.get(i);
            
            if (cliente.isCompletoRutina()) {
                totalCompletaron++;
            }
            
            tiempoTotal += cliente.getDuracion();
        }
        
        this.clientesCompletaron = totalCompletaron;
        this.tiempoPromedio = (double) tiempoTotal / clientes.size();
    }
    
    // Método para obtener estadísticas por tipo de ejercicio
    public String getEstadisticasPorTipo() {
        if (clientes.isEmpty()) {
            return "No hay clientes registrados.";
        }
        
        int cardioCount = 0, fuerzaCount = 0, estiramientoCount = 0;
        int cardioCompletado = 0, fuerzaCompletado = 0, estiramientoCompletado = 0;
        
        // Usar while para clasificar por tipo
        int i = 0;
        while (i < clientes.size()) {
            Problema5_Cliente cliente = clientes.get(i);
            String tipo = cliente.getTipoEjercicio().toLowerCase();
            
            switch (tipo) {
                case "cardio":
                    cardioCount++;
                    if (cliente.isCompletoRutina()) cardioCompletado++;
                    break;
                case "fuerza":
                    fuerzaCount++;
                    if (cliente.isCompletoRutina()) fuerzaCompletado++;
                    break;
                case "estiramiento":
                    estiramientoCount++;
                    if (cliente.isCompletoRutina()) estiramientoCompletado++;
                    break;
            }
            i++;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- ESTADÍSTICAS POR TIPO DE EJERCICIO ---\n");
        sb.append(String.format("Cardio: %d clientes (%d completaron)\n", cardioCount, cardioCompletado));
        sb.append(String.format("Fuerza: %d clientes (%d completaron)\n", fuerzaCount, fuerzaCompletado));
        sb.append(String.format("Estiramiento: %d clientes (%d completaron)\n", estiramientoCount, estiramientoCompletado));
        
        return sb.toString();
    }
    
    // Método para mostrar resumen final
    public String mostrarResumenFinal() {
        calcularEstadisticas();
        
        if (clientes.isEmpty()) {
            return "No hay clientes registrados en el gimnasio.";
        }
        
        double porcentajeCompletado = (double) clientesCompletaron / clientes.size() * 100;
        
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- RESUMEN FINAL DEL GIMNASIO ---\n");
        sb.append(String.format("Gimnasio: %s\n", nombreGimnasio));
        sb.append(String.format("Total de clientes: %d\n", clientes.size()));
        sb.append(String.format("Clientes que completaron rutina: %d\n", clientesCompletaron));
        sb.append(String.format("Porcentaje de finalización: %.1f%%\n", porcentajeCompletado));
        sb.append(String.format("Tiempo promedio de ejercicio: %.1f minutos\n", tiempoPromedio));
        
        return sb.toString();
    }
    
    // Método toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- GIMNASIO: ").append(nombreGimnasio.toUpperCase()).append(" ---\n");
        
        if (clientes.isEmpty()) {
            sb.append("No hay clientes registrados.\n");
        } else {
            sb.append("Lista de clientes y sus rutinas:\n");
            sb.append("─".repeat(80)).append("\n");
            
            for (int i = 0; i < clientes.size(); i++) {
                sb.append(String.format("%d. %s\n", (i + 1), clientes.get(i).toString()));
            }
        }
        
        return sb.toString();
    }
}