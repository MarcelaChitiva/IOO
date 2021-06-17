package modelo;

public class Barra{

	private static final double anchoBarra = 60;
	private static final double altoBarra = 20;
	private static final double paso = 1.0;             
	private static final double velBarra = 0.6;
	public static Barra instancia;
	public double velocidad = 0.0;
	public double x, y; // Si suponemos que la pantalla es de 800x600 para que aparezca en la mitad

	double izquierda() {
		return x - anchoBarra / 2.0;
}
	double derecha() {
		return x + anchoBarra / 2.0;
}
	double arriba() {
		return y - altoBarra / 2.0;
		}
	double abajo() {
	return y + altoBarra / 2.0;
}	

	public Barra(double x, double y) { //constructor
		this.x = x;
		this.y = y;
	}
	
	public void detenerse() {
		velocidad = 0.0;
	}
	public void moverIzquierda() {
		if (izquierda() > 0.0) {
			velocidad = -velBarra;
		} else {
			velocidad = 0.0;
		}
	}
	public void moverDerecha() {
		if (derecha() < SistemaJuego.getanchoPantalla()) {
			velocidad = velBarra;
		} else {
			velocidad = 0.0;
		}
	}
	public void actualizar() {
		x += velocidad * paso;
	}
	
//	public static Barra getInstancia(){
//		if(instancia==null)
//			instancia = new Barra(anchoBarra,altoBarra);
//		return instancia;
//	}
	
	/////////////////////////////GETTERS Y SETTERS//////////////////////////////////
	
	public double getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

}


