package modelo;

import views.NaveInvasoraView;

public class NaveInvasora {
	
    public NaveInvasora(int x, int y, int w, int h, Partida partida) {
    	this.x=x;
    	this.y=y;
    	this.w=w;
    	this.h=h;
    	this.partida = partida;
    	this.estaViva = true;
    }

    private int x;
    private int y;
    private int w;
    private int h;
    private boolean estaViva;
    private Partida partida;
    
    public boolean estaViva() {
    	return estaViva;
    }
    
    public void moverNave(int indicador) {
		if (indicador==1)
			this.x = this.x +10;
		else if(indicador==0)
			this.x = this.x-10;
		else
			this.y = this.y+20;
	}
    
    public void matarNave() {
    	this.estaViva = false;
    }
    
    public void setViva() {
    	this.estaViva = true;
    }
    
    public int getX() {
    	return this.x;
    }
    
    public int getY() {
    	return this.y;
    }
    
    public int getW() {
    	return this.w;
    }
    
    public int getH() {
    	return this.h;
    }
    
    public NaveInvasoraView toView() {
    	return new NaveInvasoraView(x,y,h,w,estaViva);
    }
    
    public boolean verificarColision(int y) {
    	return (this.y == y);
    }
  
}
