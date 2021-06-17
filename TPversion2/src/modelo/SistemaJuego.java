package modelo;

import java.util.*;

public enum Rebote {
	NINGUNO,
    PARED,
    TECHO,
    LADRILLO,
    BARRA_DERECHA,
    BARRA_IZQUIERDA,
}

public class SistemaJuego {


	//valores constantes:
	private static final double TotalLadrillos = 25;
	private static final double VidaExtra = 1000;

	private static final double LadrilloX = 20;
	private static final double LadrilloY = 20;

	private static final int FILA = 5, COLUMNA = 5;

	private static final double anchoPantalla = 600;
	private static final double altoPantalla = 800;

	private int ladrillosDestruidos;
	private int cantVidas;
	private int puntos;
	private static int nivel;
	private boolean finJuego;   // nos dice termino juego
	private boolean suboNivel; // nos dice si pase de nivel
	private boolean vidaExtraCheck;

	private boolean enPausa = false

	private Barra barra = new Barra(anchoPantalla/2, altoPantalla/2);
	private Bola bola = new Bola(anchoPantalla/2, altoPantalla/2 - 20); //A chequear
	private List<Ladrillo> ladrillos = new ArrayList<Ladrillo>();
	private Jugador jugador = new Jugador();
	private Ranking ranking = new Ranking();


	public SistemaJuego() {
		ladrillosDestruidos = 0;
		cantVidas = 3;
		puntos = 0;
		nivel = 1;
		finJuego = false;
		suboNivel = false;
		vidaExtraCheck = false;
		enPausa = false;
	}

	private static SistemaJuego instancia;

	public static SistemaJuego getInstancia() {
		if(instancia == null)
			instancia = new SistemaJuego();
		return instancia;
	}

	public void crearLadrillos()
	{
		for(int fila=0; fila<FILA; fila++)
		  {
			for(int colum=0;colum<COLUMNA; colum++) {
				int puntos_ladrillo = 10 * (FILA - fila)
				Ladrillo ladrillo = new Ladrillo (LadrilloX + (60*colum), LadrilloY+ (20*fila), puntos_ladrillo);
				ladrillos.add(ladrillo);
				}
		  }
	}

	public void dispararBola(){
//		if(puedoDispararJ())    Hacer METODO
//		{
//			int x = Barra.getInstancia().getPos().getPosX()+15;
//			int y = Jugador.getInstancia().getPos().getPosY()-30;
//			Disparo d = new Disparo(x,y, true);
//			disparosJ.add(d);
//			Jugador.getInstancia().disparar(d);
//		 }

	}

	public static double getanchoPantalla() {
		return anchoPantalla;
	}
	public static int getNivel() {
		return nivel;
	}
	public void morir() {
		if (cantVidas != 0) {

		}
		else {
			finJuego = true;
		}
		//desaparecer la bola y reiniciar - descontar 1 vida - si se llego a 0 gameOver, llamar a Ranking
	}

	public static double getaltoPantalla() {
		return altoPantalla;
	}
	public Barra getBarra() {
		return barra;
	}
	public void setBarra(Barra barra) {
		this.barra = barra;
	}
	public Bola getBola() {
		return bola;
	}
	public void setBola(Bola bola) {
		this.bola = bola;
	}
	public Ranking getPuntaje() {
		return ranking;
	}
	public void setPuntaje(Ranking ranking) {
		this.ranking = ranking;
	}

	public List<Ladrillo> getLadrillo() {
		return ladrillos;
	}
	public void setLadrillo(List<Ladrillo> ladrillo) {
		this.ladrillos = ladrillo;
	}

	private void checkVidaExtra()
	{
		if(puntos > 0 && puntos % VidaExtra == 0)
			setVidasRestantes(getVidasRestantes() + 1);

		vidaExtraCheck= true;
	}

	public int getVidasRestantes() {
		return cantVidas;
	}

	public void setVidasRestantes(int vidasRestantes) {
		this.cantVidas = vidasRestantes;
	}
	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos += puntos;

		checkVidaExtra();
	}

	public static void setInstancia(SistemaJuego instancia) {
		SistemaJuego.instancia = instancia;
	}


	// GAME LOOP
	public void Procesar() {
		// Avanza un paso en el juego

		if (enPausa) {
			// El juego esta pausado no hago nada
			return
		}

		barra.actualizar();
		bola.moverBola();

		checkVidaExtra();

		if (controlarVidaPerdida()) {

			if (controlarGameOver()) {
				actualizarRanking();
				reiniciarJuego();
				return;
			}

			reiniciarNivel();
		}
	}

	public void moverBarraDerecha() {
		barra.moverBarraDerecha()
	}

	public void moverBarraIzquierda() {
		barra.moverIzquierda()
	}

	public void pausarPartida() {
		enPausa = !enPausa
	}

	public void actualizarRanking() {
		ranking.clasificarJugador(jugador)
	}

	public reiniciarJuego() {
		// TODO
	}

	public reiniciarNivel() {
		// TODO
	}

	public void controlarVidaPerdida() {
		// revisar si la bola alcanzo la linea de la paleta
	}

	public void controlarGameOver() {
		// controlo sino me quede sin vidas
	}

	public Rebote reboteEnCoordenada(int x, int y, int radio) {

		// rebote contra pared
		if (x - radio =< 0 || x + radio >= anchoPantalla) {
			return PARED
		}

		// rebote contra el techo
		if (y - radio =< 0) {
			return TECHO
		}

		// rebote contra los ladrillos
		for (Ladrillo ladrillo : ladrillos) {
			Boolean colisiona = false // TODO: Cacular si la bola colisiona con el ladrillo
			if (colisiona) {
				setPuntos(ladrillo.puntos)
				// TODO: Eliminar ladrillo
				return LADRILLO
			}
		}

		// rebote contra la barra
		Boolean colisionaBarraDerecha = false // TODO: Calcular
		if (colisionaBarraDerecha) {
			return BARRA_DERECHA
		}

		Boolean colisionaBarraIzquierda = false // TODO: Calcular
		if (colisionaBarraIzquierda) {
			return BARRA_IZQUIERDA
		}

		return NINGUNO
	}
}











