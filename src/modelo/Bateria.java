package modelo;
import views.BateriaView;

public class Bateria {
	
    public Bateria(int x, int Y, int W, int H, Partida partida) {
    	this.x = x;
    	this.Y = Y;
    	this.W = W;
    	this.H = H;
    	this.partida = partida;
    }

    private int x;
    private final int Y;
    private final int W;
    private final int H;
    private Partida partida;
    
    public void moverBateria(int sentido) {
    	if (sentido==1)
    		this.x+=10;
    	if (sentido==0)
    		this.x-=10;
    }
    
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

    public BateriaView toView() {
    	return new BateriaView(x,Y,W,H,partida);
    }

}