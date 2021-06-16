package modelo;

import views.ProyectilView;

public class Proyectil{

    public Proyectil(int x,int y, boolean enemigo, Partida partida) {
    	this.x = x;
    	this.y = y;
    	this.h = 40;
    	this.y = 40;
    	this.enemigo = enemigo;
    	this.partida = partida;
    	this.enJuego = true;
    }

    private int x;
    private int y;
    private int h;
    private int w;
    private boolean enemigo;
    private Partida partida;
    private boolean enJuego;

    public boolean soyAmigo() {
        return !enemigo;
    }
    
    public boolean estoyEnJuego() {
    	return enJuego;
    }
    
    public void moverProyectil() {
    	if (!this.enemigo && enJuego) {
    		this.y-=10;
    		this.enJuego = true;
    		if (this.y<0)
    			enJuego = false;
    	}
    	else if (this.enemigo && enJuego){
    		this.y+=10;
    		this.enJuego = true;
    		if (this.y>partida.AREA_Y-100)
    			enJuego = false;
    	}
    }
    
    public boolean verificarColision(int x, int y, int w) {
    	int ancho = w/2;
    	return (y==this.y && x-ancho<=this.x && this.x<x+ancho);
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
    public void sacarDelJuego() {
    	this.enJuego = false;
    }

    public ProyectilView toView() {
    	return new ProyectilView(x,y,enemigo,enJuego);
    }

	public void dispararse(int x, int y) {
		this.x = x;
		this.y = y;
		this.enJuego = true;
	}


}