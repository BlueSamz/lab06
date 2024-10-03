package lab06;

public class Main {
    public static void main(String[] args) {
        PedidoModelo modelo = new PedidoModelo();
        PedidoVista vista = new PedidoVista();
        PedidoControlador controlador = new PedidoControlador(modelo, vista);

        vista.mostrarMensaje("Bienvenido al sistema de gestión de pedidos.");
        try {
            controlador.iniciar();
        } catch (Exception e) {
            vista.mostrarMensaje("Ocurrió un error: " + e.getMessage());
        } finally {
            vista.cerrarScanner();
        }
    }
}
