package controlador;


import java.util.*;
import modelo.SistemaJuego

public class Controlador {

	SistemaJuego sistema = null;

	public Controlador() {
	}

	public Procesar() {
		if (!sistema) { return; }

		// Avanza un paso en el juego
		sistema.Procesar()
	}

	public void moverBarraDerecha() {
		if (!sistema) { return; }

		sistema.moverBarraDerecha()
	}

	public void moverBarraIzquierda() {
		if (!sistema) { return; }

		sistema.moverBarraIzquierda()
	}

	public void iniciarPartida() {
		if (!sistema) { return; }

		sistema = SistemaJuego.getInstancia()
	}

	public void pausarPartida() {
		if (!sistema) { return; }

		sistema.pausarPartida()
	}

	public String ingresarNombre() {
		//Scanner entradaEscaner = new Scanner (System.in);
		//entradaTeclado = entradaEscaner.nextLine ();
		return "";
	}

}