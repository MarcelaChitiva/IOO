package modelo;

import java.util.ArrayList;
import java.util.List;
import controlador.Controlador;

public class Partida {

    public Partida(int AREA_X, int AREA_Y, Controlador controlador) {
    	this.AREA_X = AREA_X;
    	this.AREA_Y = AREA_Y;
    	this.listaDeNaves = new ArrayList<NaveInvasora>();
    	this.listaDeMuros = new ArrayList<MuroDeEnergia>();
    }

    private int nivel;
    private int vidas;
    private int puntos;
    public final int AREA_X;
    public final int AREA_Y;
    private List<NaveInvasora> listaDeNaves;
    private List<MuroDeEnergia> listaDeMuros;
    private Bateria bateria;
    private Proyectil proyectilEnemigo;
    private Jugador jugador;
    private Proyectil proyectilAmigo;
    private int sentido = 1;
    private boolean cambio = false;
    private int vidaExtra = 0;
    private boolean pasarDeNivel = false;    
    private boolean partidaPerdida = false;
    
    public void crearJugador(String nombre) {
    	this.jugador = new Jugador(nombre);
    }
    
    public Jugador obtenerJugador() {
    	return jugador;
    }

    public void crearBateria(){
    	partidaPerdida = false;
        this.bateria = new Bateria(350, 450, 100, 80, this);
    }
    
    public Bateria obtenerBateria() {
    	return bateria;
    }
     
    public void generarProyectilesEnemigos() {
    	this.proyectilEnemigo = new Proyectil(-1,-1,true,this);
    }
    
    public Proyectil obtenerProyectilEnemigo() {
    	return proyectilEnemigo;
    }

	public ArrayList<NaveInvasora> getNaves(){
		return (ArrayList<NaveInvasora>) listaDeNaves;
	}
	
	public ArrayList<NaveInvasora> generarNaves(){
		if (!listaDeNaves.isEmpty())
			listaDeNaves.clear();
		int posx = -90;
		int posy = 10;
		for (int i=0;i<15;i++) {
			if (i==5 || i==10) {
				posx=10;
				posy+=40;
			}
			else
				posx+=100;
			NaveInvasora n = new NaveInvasora(posx,posy,30,34,this);
			listaDeNaves.add(n);
		}
		return (ArrayList<NaveInvasora>) listaDeNaves;
	}

	public void generarMuro() {
		if (!listaDeMuros.isEmpty())
			listaDeMuros.clear();
		int posx = -190;
		int posy = 350;
		for (int i=0; i<3;i++) {
			posx+=270;
			MuroDeEnergia m = new MuroDeEnergia(posx,posy,100,100,100,this);
			listaDeMuros.add(m);
		}
	}
	
	public void moverNaves() {
		int indicador=1;
			if (sentido==1) {
				indicador=1;
				if (listaDeNaves.get(4).estaViva()|| listaDeNaves.get(9).estaViva() || listaDeNaves.get(14).estaViva()) {
						if (listaDeNaves.get(14).getX()+10>=this.AREA_X-50) 
							cambio = true;
					}
					else if (listaDeNaves.get(3).estaViva()||listaDeNaves.get(8).estaViva()||listaDeNaves.get(13).estaViva()) {
						if (listaDeNaves.get(13).getX()+10>=this.AREA_X-50)
							cambio = true;
					}
					else if (listaDeNaves.get(2).estaViva()||listaDeNaves.get(7).estaViva()||listaDeNaves.get(12).estaViva()) {
						if (listaDeNaves.get(12).getX()+10>=this.AREA_X-50)
							cambio = true;
					}
					else if (listaDeNaves.get(1).estaViva()||listaDeNaves.get(6).estaViva()||listaDeNaves.get(11).estaViva()) {
						if (listaDeNaves.get(11).getX()+10>=this.AREA_X-50)
							cambio = true;
					}
					else {
						if(listaDeNaves.get(10).getX()+10>=this.AREA_X-50)
							cambio = true;
					}
				}
				else if (sentido==0){
					indicador=0;
					if (listaDeNaves.get(0).estaViva()|| listaDeNaves.get(5).estaViva() || listaDeNaves.get(10).estaViva()) {
						if (listaDeNaves.get(0).getX()-10<=0) {
							cambio = true;
						}
					}
					else if (listaDeNaves.get(1).estaViva()||listaDeNaves.get(6).estaViva()||listaDeNaves.get(11).estaViva()) {
						if (listaDeNaves.get(1).getX()-10<=0) {
							cambio = true;
						}
					}
					else if (listaDeNaves.get(2).estaViva()||listaDeNaves.get(7).estaViva()||listaDeNaves.get(12).estaViva()) {
						if (listaDeNaves.get(12).getX()-10<=0) {
							cambio = true;
						}
					}
					else if (listaDeNaves.get(3).estaViva()||listaDeNaves.get(8).estaViva()||listaDeNaves.get(13).estaViva()) {
						if (listaDeNaves.get(3).getX()-10<=0) {
							cambio = true;
						}
					}
					else {
						if(listaDeNaves.get(4).getX()-10<=0) {
							cambio = true;
						}
					}
				}
				if (cambio) {
					if (sentido==1)
						sentido=0;
					else 
						sentido=1;
					indicador = -1;
					cambio = false;
				}
				for (int i=0; i<listaDeNaves.size();i++) {
					listaDeNaves.get(i).moverNave(indicador);
				}
	}
	
	public void moverBateria(int sentido) {
		if (sentido==1) {
			if (bateria.getX()+10<= this.AREA_X-110)
				bateria.moverBateria(sentido);
		}
		else {
			if(bateria.getX()-10>0)
				bateria.moverBateria(sentido);
		}
	}
	
	public void moverProyectiles() {
		proyectilAmigo.moverProyectil();
		proyectilEnemigo.moverProyectil();
	}

	public void dispararProyectil(int x, int y, boolean enemigo) {
		if (enemigo)
			proyectilEnemigo.dispararse(x, y);
		else
			proyectilAmigo.dispararse(x,y);
	}
	
    /**
     * Verifica que objetos estan colisionando en el instante en el que el metodo fue invocado 
     * y evalua lo que se debe realizar en base a esos datos.
     */
    public void detectarColisiones() {
    	
    	pasarDeNivel = false;
    	if (proyectilAmigo.estoyEnJuego()) {
    		for (NaveInvasora nave: this.listaDeNaves) {
    			if (nave.estaViva()) {
    				if (proyectilAmigo.verificarColision(nave.getX(), nave.getY(), nave.getW())) {
        				nave.matarNave();
        				proyectilAmigo.sacarDelJuego();
        				this.puntos+=10;
        				vidaExtra+=10;
        				if (vidaExtra>=500) {
        					this.vidas++;
        					vidaExtra=0;
        				}
    				}
    			}
    		}
        	
    		for (int i=0 ; i<listaDeMuros.size(); i++) {
    			if(!listaDeMuros.get(i).estaMuerto()) {
    				if(proyectilAmigo.verificarColision(listaDeMuros.get(i).getX(), listaDeMuros.get(i).getY(), listaDeMuros.get(i).getW())) {
    					proyectilAmigo.sacarDelJuego();
    					listaDeMuros.get(i).sufrirDanno(10);
    				}
    			}
    		}
    	}
    	
    	if (proyectilEnemigo.estoyEnJuego()) {
    		if (proyectilEnemigo.verificarColision(bateria.getX(), bateria.getY(), bateria.getW()+40)) {
    			proyectilEnemigo.sacarDelJuego();
    			this.vidas--;
    			if (this.vidas<=0)
    				finalizarPartida();
    			else {
    				for(int i=0; i<listaDeMuros.size();i++) {
    					listaDeMuros.get(i).reiniciarVida();
    				}
    			}
    		}
    		
    		for (int i=0 ; i<listaDeMuros.size(); i++) {
    			if(!listaDeMuros.get(i).estaMuerto()) {
    				if(proyectilEnemigo.verificarColision(listaDeMuros.get(i).getX(), listaDeMuros.get(i).getY(), listaDeMuros.get(i).getW()+20)) {
    					proyectilEnemigo.sacarDelJuego();
    					listaDeMuros.get(i).sufrirDanno(5);
    				}
    			}
    		}
    	}
    	
    	for(int i=0; i<listaDeNaves.size();i++) {
    		if(listaDeNaves.get(i).estaViva()) {
    			if(listaDeNaves.get(i).verificarColision(bateria.getY())) {
    				finalizarPartida();
    			}
    			else if(listaDeNaves.get(i).verificarColision(listaDeMuros.get(0).getY())) {
    				for (int j=0; j<listaDeMuros.size(); j++) {
    					if (!listaDeMuros.get(j).estaMuerto())
    						listaDeMuros.get(j).sufrirDanno(100);
    				}
    			}
    		}
    	}
    	
    	boolean nivelSuperado = true;
    	for (int i = 0; i<15; i++) {
    		if (listaDeNaves.get(i).estaViva())
    			nivelSuperado = false;
    	}
    	if (nivelSuperado) {
    		this.nivel = (int) (this.nivel*0.8);
    		this.puntos+=200;
    		this.vidaExtra+=200;
    		if (vidaExtra>=500) {
				this.vidas++;
				vidaExtra=0;
			}
    		this.pasarDeNivel = true;
    		pasarNivel();
    	}
    		
    }

	public ArrayList<MuroDeEnergia> obtenerMuro(){
		return (ArrayList<MuroDeEnergia>) listaDeMuros;
	}
	
	public void finalizarPartida() {
		partidaPerdida = true;
		this.jugador.actualizarPuntaje(puntos);
		Controlador.getInstancia().finalizarPartida();
		this.proyectilAmigo.sacarDelJuego();
		this.proyectilEnemigo.sacarDelJuego();
	}
	
	public void pasarNivel() {
		this.generarMuro();
		this.generarNaves();
		this.proyectilAmigo.sacarDelJuego();
		this.proyectilEnemigo.sacarDelJuego();
	}
	
	public void generarProyAmigo() {
		this.proyectilAmigo = new Proyectil(1000,1000,false,this);
	}
	
	public Proyectil obtenerProyAmigo() {
		return proyectilAmigo;
	}
	
	public void actualizarVidas(int x) {
		this.vidas = x;
	}
	
	public int getVidas() {
		return vidas;
	}
	
	public void actualizarPuntos(int x) {
		this.puntos = x;
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	public boolean getPasarNivel() {
		return pasarDeNivel;
	}
	
	public boolean getPartidaPerdida() {
		return partidaPerdida;
	}
	
	public int setVelocidadTimer(Object x) {
		if (x=="CADETE")
			this.nivel = 350;
		else if (x=="GUERRERO")
			this.nivel = 250;
		else 
			this.nivel = 150;
		return nivel;
	}
	
	public int getVelocidad() {
		return nivel;
	}
	

}