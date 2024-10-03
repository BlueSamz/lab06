package lab06;

public class Pedido {
    private String nombrePlato;
    private String tipoP;

    public Pedido(String nombrePlato, String tipoP) {
        this.nombrePlato = nombrePlato;
        this.tipoP = tipoP;
        
    }

    public String getNombrePlato() {
        return nombrePlato;
    }
    
    public String getTipoP() {
    	return tipoP;
    }
    
    public void setNombrePlato(String nombrePlato) {
    	if(!nombreValido(nombrePlato)) {
    		throw new IllegalArgumentException("El nombre del plato solo puede ser caracteres alfabeticos");
    	}
    }
    
    private boolean nombreValido(String nombrePlato) {
    	return nombrePlato.matches("[a-zA-Z]+");
    }
    
}
