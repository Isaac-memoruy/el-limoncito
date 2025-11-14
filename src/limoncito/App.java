package limoncito;

import limoncito.domain.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    
        Producto camisa = new Producto("Camisa", 4000, 3500);
        Producto pantalon = new Producto("Pantalón", 6000, 5000);
        Producto chaqueta = new Producto("Chaqueta", 9000, 7500);

        System.out.println("=== Lavandería 'El Limoncito' ===");
        System.out.print("Nombre del cliente: ");
        String nombre = sc.nextLine();
        System.out.print("Teléfono del cliente: ");
        String telefono = sc.nextLine();

        Cliente cliente = new Cliente(nombre, telefono);
        Orden orden = new Orden(cliente);

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nCatálogo:");
            System.out.println("1. Camisa  - $4.000 (Volumen $3.500 desde 5)");
            System.out.println("2. Pantalón - $6.000 (Volumen $5.000 desde 5)");
            System.out.println("3. Chaqueta - $9.000 (Volumen $7.500 desde 5)");
            System.out.print("Seleccione producto (1-3) o 0 para terminar: ");
            int opcion = sc.nextInt();

            if (opcion == 0) break;

            Producto productoSeleccionado = null;
            switch (opcion) {
                case 1: productoSeleccionado = camisa; break;
                case 2: productoSeleccionado = pantalon; break;
                case 3: productoSeleccionado = chaqueta; break;
                default:
                    System.out.println("Opción inválida.");
                    continue;
            }

            System.out.print("Ingrese cantidad: ");
            int cantidad = sc.nextInt();
            try {
                ItemOrden item = new ItemOrden(productoSeleccionado, cantidad);
                orden.agregarItem(item);
            } catch (IllegalArgumentException e) {
                System.out.println("advertencia" + e.getMessage());
            }
        }

        System.out.print("¿Servicio exprés? (s/n): ");
        char resp = sc.next().toLowerCase().charAt(0);
        orden.setServicioExpress(resp == 's');

        orden.mostrarResumen();

        System.out.print("¿Confirmar orden? (s/n): ");
        char conf = sc.next().toLowerCase().charAt(0);
        if (conf == 's') {
            orden.confirmar();
        }

        sc.close();
    }
}