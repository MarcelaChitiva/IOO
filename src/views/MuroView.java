package views;

public class MuroView{
	
	private int x;
	private int y;
	private int w;
	private int h;
	private int vida;
	
	public MuroView(){}

	public MuroView(int x, int y, int w, int h, int vida) {
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
		this.vida = vida;
	}

	public int getVida() {
		return vida;
	}
	
	public boolean estaVivo() {
		return vida>0;
	}

	public void setVida(int vida) {
		this.vida = vida;
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


}
