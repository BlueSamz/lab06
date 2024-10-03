package lab06;

import java.util.List;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarPedido(String nombrePlato, String tipoP) {
        if (nombrePlato.isEmpty() || tipoP.isEmpty()) {
            vista.mostrarMensaje("El nombre y tipo del plato no pueden estar vacíos.");
            return;
        }

        if (!nombrePlato.matches("[a-zA-Z ]+")) {
            vista.mostrarMensaje("El nombre del plato es invalido");
            return;
        }

        if (!tipoP.matches("[a-zA-Z ]+")) {
            vista.mostrarMensaje("El tipo del plato es invalido");
            return;
        }

        try {
            modelo.agregarPedido(new Pedido(nombrePlato, tipoP));
            vista.mostrarMensaje("Pedido agregado: " + nombrePlato);
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje(e.getMessage());
        }
    }


    public void eliminarPedido() {
        String nombrePlato = vista.solicitarNombrePlato();
        try {
            modelo.eliminarPedido(nombrePlato);
            vista.mostrarMensaje("Pedido eliminado: " + nombrePlato);
        } catch (PedidoNoEncontradoException e) {
            vista.mostrarMensaje(e.getMessage());
        }
    }

    public void actualizarPedido() {
        String nombrePlatoAnt = vista.solicitarNombrePlatoAnt();
        String nuevoNombre = vista.solicitarNuevoNombre();
        try {
            modelo.actualizarPedido(nombrePlatoAnt, nuevoNombre);
            vista.mostrarMensaje("Pedido actualizado: " + nuevoNombre);
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje(e.getMessage());
        }
    }
    
    public void buscarPedido() {
        String criterio = vista.solicitarCriterio();
        try {
            List<Pedido> pedidosEncontrados = modelo.buscarPedido(criterio);
            vista.mostrarPedidos(pedidosEncontrados);
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje(e.getMessage());
        }
    }

    public void contarPedidos() {
        int totalPedidos = modelo.contarPedidos();
        vista.mostrarMensaje("Total de pedidos: " + totalPedidos);
        
        String tipo = vista.solicitarTipoParaContar();
        try {
            int totalPorTipo = modelo.contarPedidosPorTipo(tipo);
            vista.mostrarMensaje("Total de pedidos de tipo " + tipo + ": " + totalPorTipo);
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje(e.getMessage());
        }
    }

    

    
    public void mostrarPedidos() {
        List<Pedido> pedidos = modelo.getPedidos();
        vista.mostrarPedidos(pedidos);
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1":
                    String nombrePlato = vista.solicitarNombrePlato();
                    String tipoP = vista.solicitarTipoPlato();
                    agregarPedido(nombrePlato, tipoP);
                    break;
                case "2":
                    mostrarPedidos();
                    break;
                case "3":
                    eliminarPedido();
                    break;
                case "4":
                    actualizarPedido();
                    break;
                case "5":
                    buscarPedido();
                    break;
                case "6":
                    contarPedidos();
                    break;
                case "7":
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida, inténtelo de nuevo.");
            }
        } while (!opcion.equals("7"));
        vista.cerrarScanner();
    }
}
