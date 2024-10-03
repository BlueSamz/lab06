package lab06;

import java.util.List;
import java.util.Scanner;

public class PedidoVista {
    private Scanner scanner;

    public PedidoVista() {
        scanner = new Scanner(System.in);
    }

    public String solicitarNombrePlato() {
        System.out.print("Ingrese el nombre del plato: ");
        return scanner.nextLine();
    }

    public String solicitarTipoPlato() {
        System.out.print("Ingrese el tipo del plato: ");
        return scanner.nextLine();
    }

    public String solicitarNombrePlatoAnt() {
        System.out.print("Ingrese el nombre del plato a actualizar: ");
        return scanner.nextLine();
    }

    public String solicitarNuevoNombre() {
        System.out.print("Ingrese el nuevo nombre del plato: ");
        return scanner.nextLine();
    }

    public String solicitarCriterio() {
        System.out.print("Ingrese el criterio de búsqueda (nombre o tipo): ");
        return scanner.nextLine();
    }

    public String solicitarTipoParaContar() {
        System.out.print("Ingrese el tipo para contar: ");
        return scanner.nextLine();
    }

    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos en la lista.");
        } else {
            System.out.println("Lista de Pedidos:");
            for (Pedido pedido : pedidos) {
                System.out.println("- " + pedido.getNombrePlato() + " (Tipo: " + pedido.getTipoP() + ")");
            }
        }
    }

    public void mostrarMenu() {
        System.out.println("\nOpciones:");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos");
        System.out.println("3. Eliminar Pedido");
        System.out.println("4. Actualizar Pedido");
        System.out.println("5. Buscar Pedido");
        System.out.println("6. Contar Pedidos");
        System.out.println("7. Salir");
    }

    public String solicitarOpcion() {
        System.out.print("Selecciona una opción: ");
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
