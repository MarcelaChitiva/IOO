package views;

public class NaveInvasoraView{
	
	private int x;
	private int y;
	private int w;
	private int h;
	private boolean estaViva;

	public NaveInvasoraView() {}

	public NaveInvasoraView(int x, int y, int w, int h, boolean estaViva) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.estaViva = estaViva;
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

	public boolean isEstaViva() {
		return estaViva;
	}

	public void setEstaViva(boolean estaViva) {
		this.estaViva = estaViva;
	}
	

}
