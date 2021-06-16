package modelo;


public class Jugador {

    public Jugador(String nombre) {
    	this.nombre = nombre;
    	this.puntaje = 0;
    }

    private String nombre;
    private int puntaje;
    private SistemaJuego partida;

    public void conectarPartida(SistemaJuego partida) {
    	this.partida = partida;
    }

    
    public void actualizarPuntaje(int puntaje){
        this.puntaje = puntaje;
    }

    public String getNombre() {
    	return this.nombre;
    }
    
    public int getPuntaje() {
    	return this.puntaje;
    }
    
   
}