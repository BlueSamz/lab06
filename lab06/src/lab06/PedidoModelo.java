package lab06;

import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {
    private List<Pedido> pedidos;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede estar vacio."); 
        }
        pedidos.add(pedido);
    }
    
    public void eliminarPedido(String nombrePlato) throws PedidoNoEncontradoException{    //numero de pedid, validar para que no haya eliminacion completa
    	boolean encontrado = false;
    	for(int i=0; i<pedidos.size();i++) {
    		if(pedidos.get(i).getNombrePlato().equalsIgnoreCase(nombrePlato)){
    			pedidos.remove(i);
    			encontrado = true;
    			break;
    		}
    	}
    	if (!encontrado) {
    		throw new PedidoNoEncontradoException("El pedido con el nombre "+ nombrePlato + "no se encontró");
    	}
    }
    
    public void actualizarPedido(String nombrePlatoAnt, String nuevoPedido) {
        if (nombrePlatoAnt == null || nuevoPedido == null) {
            throw new IllegalArgumentException("El nombre del plato antiguo y el nuevo no pueden estar vacios.");
        }
        if (!nuevoPedido.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("El nuevo nombre del plato solo puede contener caracteres alfabéticos.");
        }

        for (Pedido pedido : pedidos) {
            if (pedido.getNombrePlato().equalsIgnoreCase(nombrePlatoAnt)) {
                pedido.setNombrePlato(nuevoPedido);
                return; 
            }
        }
    }
    
    public List<Pedido> buscarPedido(String criterio) {
        if (criterio == null || criterio.isEmpty()) {
            throw new IllegalArgumentException("El criterio de búsqueda no puede estar vacío.");
        }

        List<Pedido> pedidosEncontrados = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getNombrePlato().equalsIgnoreCase(criterio) || 
                pedido.getTipoP().equalsIgnoreCase(criterio)) {
                pedidosEncontrados.add(pedido);
            }
        }
        return pedidosEncontrados;
    }

    public int contarPedidos() {
        return pedidos.size();
    }
    
    public int contarPedidosPorTipo(String tipo) {
        if (tipo == null || tipo.isEmpty()) {
            throw new IllegalArgumentException("El tipo no puede estar vacío.");
        }

        int contador = 0;
        for (Pedido pedido : pedidos) {
            if (pedido.getTipoP().equalsIgnoreCase(tipo)) {
                contador++;
            }
        }
        return contador;
    }

    
    public List<Pedido> getPedidos() {
        return pedidos;
    }
}

