package modelo;

public class Puntaje {

		int puntos = 0;
		int vidas;
		boolean victoria = false;
		boolean gameOver = false;
		int cantLadrillos = 25;
		int espaciosRanking = 20;
		String text = "";
		
				
	public void incrementarPuntaje() {
		puntos++;
		if (puntos == (cantLadrillos)) {   // CORREGIR !!
			victoria = true;			
		} else {
			actualizarPuntaje();
		}
	}

	public void morir() {
		vidas--;
		if (vidas == 0) {
			gameOver = true;
		} else {
			actualizarPuntaje();
		}
	}

	/*
	 * 	Por cada ladrillo destruido de la primera fila se obtienen 10 puntos, 
	 * por cada ladrillo de la segunda 20, por los de la tercera 30 por los de la cuarta 40 
	 * y por los de la quinta 50 (la primera fila es la fila inferior del bloque). Por cada 1000 
	 * puntos se obtiene una vida.
	 */
	
	
	private void actualizarPuntaje() {
		text = "Puntaje: " + puntos + "  Vidas: " + puntos;
	}
	

	public void clasificarJugador() {
		//pedir nombre y ubicar en el top 20 si corresponde
	}
}
