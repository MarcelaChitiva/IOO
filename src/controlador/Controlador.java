package controlador;

import java.util.ArrayList;
import modelo.Jugador;
import modelo.Partida;
import modelo.Ranking;
import modelo.NaveInvasora;
import views.BateriaView;
import views.JugadorView;
import views.MuroView;
import views.NaveInvasoraView;
import views.ProyectilView;
import modelo.MuroDeEnergia;

public class Controlador {
	
	private static Controlador instancia;
	

    private Controlador() {
        this.ranking = new Ranking();
    }
    
    private String nivel;
    private Partida partida;
    private Ranking ranking;
    
    public static Controlador getInstancia() {
    	if (instancia==null)
    		instancia = new Controlador();
    	return instancia;
    }

    public void crearJugador(String nombre) {
        partida.crearJugador(nombre);
    }
    
    public void moverNaves() {
    	partida.moverNaves();
    }
    
    public void moverBateria(int sentido) {
    	partida.moverBateria(sentido);
    }
    
    public void moverProyectiles() {
    	partida.moverProyectiles();
    }
    
    public void detectarColisiones() {
    	partida.detectarColisiones();
    }
    
    public boolean getNivelSuperado() {
    	return partida.getPasarNivel();
    }
    
    public boolean getPartidaPerdida() {
    	return partida.getPartidaPerdida();
    }
    
    public void dispararProyectil(int x, int y, boolean enemigo) {
    	partida.dispararProyectil(x, y, enemigo);
    }
    
    public void crearNivel() {
    	partida.crearBateria();
    	partida.generarNaves();
    	partida.generarProyAmigo();
    	partida.generarMuro();
    	partida.generarProyectilesEnemigos();
    	partida.obtenerJugador().conectarPartida(partida);
    }
    
    public void cargarNivel(Object x) {
    	partida.setVelocidadTimer(x);
    	this.nivel = (String) x;
    }
    
    public String obtenerNivel() {
    	return nivel;
    }
    
    public int obtenerTiempo() {
    	return partida.getVelocidad();
    }

    public void crearPartida(int AREA_X, int AREA_Y) {
        partida = new Partida(AREA_X, AREA_Y, this);
        this.partida.actualizarPuntos(0);
        this.partida.actualizarVidas(3);   
    }


    public BateriaView obtenerBateria() {
    	return this.partida.obtenerBateria().toView();
    }
    
    public ProyectilView obtenerProyectilEnemigos() {
		return this.partida.obtenerProyectilEnemigo().toView();
    }
    
    public ArrayList<NaveInvasoraView> obtenerNaves(){
    	ArrayList <NaveInvasora>naves = this.partida.getNaves();
    	ArrayList<NaveInvasoraView> resultado = new ArrayList<NaveInvasoraView>();
    	for(NaveInvasora nave : naves)
    		resultado.add(nave.toView());
    	return resultado;
    }
    
    public ArrayList<MuroView> obtenerMuro(){
    	ArrayList<MuroDeEnergia> muros = this.partida.obtenerMuro();
    	ArrayList<MuroView> resultado = new ArrayList<MuroView>();
    	for (MuroDeEnergia muro: muros)
    		resultado.add(muro.toView());
    	return resultado;
    }
    
    public ArrayList<JugadorView> obtenerRanking(){
    	ArrayList<JugadorView> resultado = new ArrayList<JugadorView>();
    	ArrayList <Jugador> rank = this.ranking.devolverTop10();
    	for (Jugador jugador: rank)
    		resultado.add(jugador.toView());
    	return resultado;
    }
    
    public ProyectilView obtenerProyAmigo() {
    	return partida.obtenerProyAmigo().toView();
    }
    
    public int getPuntos() {
    	return partida.getPuntos();
    }
      
    public int getVidas() {
    	return partida.getVidas();
    }
    
    public void finalizarPartida() {
    	this.ranking.clasificarJugador(partida.obtenerJugador());
    }
 
}