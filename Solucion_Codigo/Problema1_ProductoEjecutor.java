// Problema-1_ProductoEjecutor.java
import java.util.Scanner;

public class Problema1_ProductoEjecutor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- SISTEMA DE VENTAS ---");
        System.out.println("Bienvenido al sistema de cálculo de descuentos");
        System.out.println();
        
        try {
            // Entrada de datos
            System.out.print("Ingrese el precio unitario del producto: $");
            double precio = scanner.nextDouble();
            
            System.out.print("Ingrese el número de productos: ");
            int numeroProductos = scanner.nextInt();
            
            // Validaciones básicas
            if (precio <= 0 || numeroProductos <= 0) {
                System.out.println("Error: El precio y número de productos deben ser mayores a 0");
                return;
            }
            
            // Crear objeto y calcular
            Problema1_Producto producto = new Problema1_Producto(precio, numeroProductos);
            
            // Mostrar resultados
            System.out.println("\n" + producto.toString());
            
        } catch (Exception e) {
            System.out.println("Error: Por favor ingrese valores numéricos válidos");
        } finally { // siempre se ejecuta sin importar si ocurrió una excepción o no.
            scanner.close();
        }
    }
}