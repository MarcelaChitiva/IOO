package views;

import modelo.Partida;

public class BateriaView {
	
	private int x;
	private int y;
	private int w;
	private int h;
	private Partida partida;
	
	public BateriaView() {}

	public BateriaView(int x, int y, int w, int h, Partida partida) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.partida = partida;
		
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

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

}
