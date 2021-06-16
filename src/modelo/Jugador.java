package modelo;

import views.JugadorView;

public class Jugador {

    public Jugador(String nombre) {
    	this.nombre = nombre;
    	this.puntaje = 0;
    }

    private String nombre;
    private int puntaje;
    private Partida partida;

    public void conectarPartida(Partida partida) {
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
    
    public JugadorView toView() {
    	return new JugadorView(this.nombre,this.puntaje);
    }

}