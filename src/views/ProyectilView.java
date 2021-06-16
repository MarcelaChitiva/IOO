package views;

public class ProyectilView{
	
	private int x;
	private int y;
	private boolean enemigo;
	private boolean enJuego;

	public ProyectilView() {}

	public ProyectilView(int x, int y,boolean enemigo, boolean enJuego) {
		this.x = x;
		this.y = y;
		this.enemigo = enemigo;
		this.enJuego = enJuego;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean getEnemigo() {
		return enemigo;
	}

	public void setEnemigo(boolean enemigo) {
		this.enemigo = enemigo;
	}

	public boolean isEnJuego() {
		return enJuego;
	}

	public void setEnJuego(boolean enJuego) {
		this.enJuego = enJuego;
	}

}
