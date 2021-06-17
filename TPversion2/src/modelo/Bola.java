package modelo;

import java.util.Random;
import modelo.SistemaJuego.*;

public class Bola {

	public double x, y;
	public double velocidadBola = 0.6; //velocidad base
	public double velBolaX;
	public double velBolaY;
	public double paso = 1.0;
	public static final int widthBola = 20, heightBola = 20;
	public static final double radio = 10; //Si Y es menor que el radio de la bola, nos aseguramos que la parte Y de la velocidad sea positiva 
	public static Bola instancia;
	Random r = new Random();
	
	public Bola (double x, double y) {
		this.x = x;
		this.y = y;
	}
	
//	public static Bola getInstancia(){
//		if(instancia==null)
//			instancia = new Bola(widthBola,heightBola);
//		return instancia;
//	}
	
	public double calculoDeVel(){ //Calculo de la velocidad por nivel
		
		double calculo = 0;	
		calculo = SistemaJuego.getNivel() * velocidadBola;  //multiplico vel base * nivel
		return calculo;
	}
	
	public double setVelocidadBola(double velocidadBola) {
	return calculoDeVel();
	}
	
	double izquierda() {
		return x - widthBola / 2.0;     //ubicacion en x e y
	}

	double derecha() {
		return x + widthBola / 2.0;
	}

	double arriba() {
		return y - heightBola / 2.0;
	}

	double abajo() {
		return y + heightBola / 2.0;
	}

	/*AGREGAR CALCULO DE GRADOS SEGUN IMPACTO
	Los rebotes de la bola cuando tocan un ladrillo y los destruyen se realizan en un ángulo aleatorio entre 85 y 95 grados.
	Los rebotes de la bola cuando tocan la barra dependen de la porción de la barra sobre la que impactan, si impactan sobre la
 mitad izquierda de la barra el ángulo será de 90 mas del ángulo de entrada, si impacta en la mitad de la derecha el ángulo será 
 de 60 más el ángulo de entrada.

	*/

	public void moverBola() {
		// x += velBolaX; // Calcularia el update del movimiento de la bola
		// y += velBolaY;

		double velocidad = calculoDeVel()
		double proxima_x = x + velBolaX * velocidad
		double proxima_y = y + velBolaY * velocidad

		SistemaJuego sistema = SistemaJuego.getInstancia()
		Rebote tipo_rebote = sistema.reboteEnCoordenada(proxima_x, proxima_y, radio)

		// TODO: actualizo la posicion y direccion de la bola
	    switch (tipo_rebote) {
            case PARED:
                break;

            case TECHO:
                break;

            case LADRILLO:
                break;

            case BARRA_DERECHA:
                break;

            case BARRA_IZQUIERDA:
                break;

            case NINGUNO:
            	x = proxima_x
            	y = proxima_y
            	break;
        }

//        if (x - radio < 0) {
//            velBolaX = -velBolaX; 
//            x = radio; //  vuelve a colocar la bola al borde
//         } else if (x + radio > SistemaJuego.getanchoPantalla()) {
//            velBolaX = -velBolaX;
//            x = SistemaJuego.getanchoPantalla() - radio;
//         }
//        
//         if (y - radio < 0) {
//            velBolaY = -velBolaY;
//            y = radio;
//         } else if (y + radio > SistemaJuego.getaltoPantalla()) {
//            velBolaY = -velBolaY;
//            y = SistemaJuego.getaltoPantalla() - radio;
//         }

//		if (izquierda() < 0)
//			velEnX = velocidadBola;
//		else if (derecha() > SistemaJuego.getanchoPantalla())
//			velEnX = -velocidadBola;
//		if (arriba() < 0) {
//			velEnY = velocidadBola;
//		} else if (abajo() > SistemaJuego.getaltoPantalla()) {
//			velEnY = -velocidadBola;
//			x = barra.x;
//			y = barra.y - 50;
//			SistemaJuego.morir();
//			}	
		}

	public double calculoReboteX() {
		double alpha = r.nextInt(95-85) + 85;
		double dirx = Math.cos(alpha*(Math.PI/180)); // para ver si va derecha o izquierda
		return dirx;
	}

	public double calculoReboteY() {
		Random r = new Random();
		double alpha = r.nextInt(95-85) + 85;
		double diry= Math.sin(alpha*(Math.PI/180));; //para ver si va en direccion arriba o abajo
		return diry;
	}
}
