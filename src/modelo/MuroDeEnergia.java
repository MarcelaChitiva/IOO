package modelo;
import views.MuroView;

public class MuroDeEnergia {

    public MuroDeEnergia(int x, int Y, int W, int H, int vida,Partida partida) {
    	this.vida = vida;
    	this.x = x;
    	this.Y = Y;
    	this.W = W;
    	this.H = H;
    	this.partida = partida;
    }

    private int x;
    private int vida;
    private Partida partida;
    private final int Y;
    private final int W;
    private final int H;
    
    public int getX() {
    	return this.x;
    }
    
    public int getY() {
    	return this.Y;
    }
    
    public int getW() {
    	return this.W;
    }
    
    public int getH() {
    	return this.H;
    }
    
    public void reiniciarVida() {
		this.vida = 100;
	}
    
    public void sufrirDanno(int danno) {
    	this.vida-=danno;
    }
    
    public boolean estaMuerto() {
    	return vida<=0;
    }
    
    public MuroView toView() {
    	return new MuroView(x,Y,W,H,vida);
    }

}