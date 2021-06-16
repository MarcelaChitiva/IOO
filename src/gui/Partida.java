package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import controlador.Controlador;
import views.BateriaView;
import views.MuroView;
import views.NaveInvasoraView;
import views.ProyectilView;

public class Partida extends JFrame implements KeyListener{

	private static final long serialVersionUID = 1L;
	ImageIcon imgBateria = new ImageIcon ("src/images/bateria.png");
	ImageIcon imgNave = new ImageIcon("src/images/NaveInvasora.png");
	ImageIcon imgProyectil = new ImageIcon("src/images/proyectil.png");
	ImageIcon imgMuro = new ImageIcon("src/images/muro.png");
	JLabel proyAmigoIcon,proyEnemigoIcon, bateriaIcon, aux, textoPuntos, puntos, textoVidas, vidas, textoNivel, nivel, textoGameOver;
	JButton ranking;
	ArrayList<JLabel> navesIcon = new ArrayList<JLabel>();
	ArrayList<JLabel> murosIcon = new ArrayList<JLabel>();
	ArrayList<MuroView> murosView;
	ArrayList<ProyectilView> proyectilesEnemigos;
	ArrayList<NaveInvasoraView> navesView;
	ProyectilView proyectilAmigo;
	ProyectilView proyectilEnemigo;
	BateriaView bateria;
	Container c;
	int contPuntos = 0;
	int contVidas = 3;
	Timer timerMoverNaves, timerMoverProyectiles, timerProyectil1;

	public Partida(){
		configurar();
		asignarEventos();
		addKeyListener(this);
		this.setVisible(true);
		this.setSize(800,600);
	}
	
	private void configurar() {
		Container c = this.getContentPane();
		c.setLayout(null);
		this.setTitle("Partida");
		c.setBackground(Color.black);
		
		textoPuntos = new JLabel("PUNTOS:");
		textoPuntos.setForeground(Color.green);
		textoPuntos.setFont(new java.awt.Font("Agency FB",1,30));
		puntos = new JLabel(String.valueOf(Controlador.getInstancia().getPuntos()));
		puntos.setForeground(Color.white);
		puntos.setFont(new java.awt.Font("Agency FB",1,30));
		textoVidas = new JLabel("VIDAS:");
		textoVidas.setForeground(Color.green);
		textoVidas.setFont(new java.awt.Font("Agency FB",1,30));
		vidas = new JLabel(String.valueOf(Controlador.getInstancia().getVidas()));
		vidas.setForeground(Color.white);
		vidas.setFont(new java.awt.Font("Agency FB",1,30));
		textoNivel = new JLabel("NIVEL:");
		textoNivel.setForeground(Color.green);
		textoNivel.setFont(new java.awt.Font("Agency FB",1,30));
		nivel = new JLabel(Controlador.getInstancia().obtenerNivel());
		nivel.setForeground(Color.white);
		nivel.setFont(new java.awt.Font("Agency FB",1,30));
		textoGameOver = new JLabel("GAME OVER");
		textoGameOver.setForeground(Color.green);
		textoGameOver.setFont(new java.awt.Font("Agency FB",1,60));
		c.add(textoGameOver);
		textoGameOver.setVisible(false);
		textoGameOver.setBounds(300, 200, 500, 100);
		ranking = new JButton("VER RANKING");
		ranking.setBackground(Color.green);
		ranking.setFont(new java.awt.Font("Agency FB",1,30));
		ranking.setBounds(280, 350, 270, 80);
		ranking.setVisible(false);
		c.add(ranking);
		
		textoPuntos.setBounds(10,500,100,80);
		puntos.setBounds(100, 500, 80, 80);
		textoVidas.setBounds(200, 500, 100, 80);
		vidas.setBounds(300, 500, 80, 80);
		textoNivel.setBounds(400, 500, 80, 80);
		nivel.setBounds(480, 500, 150, 80);
		c.add(textoPuntos);
		c.add(puntos);
		c.add(textoVidas);
		c.add(vidas);
		c.add(textoNivel);
		c.add(nivel);

		Controlador.getInstancia().crearNivel();
		
		
		bateria = Controlador.getInstancia().obtenerBateria();
		bateriaIcon = new JLabel(imgBateria);
		bateriaIcon.setBounds(bateria.getX(), bateria.getY(), bateria.getW(), bateria.getH());
		c.add(bateriaIcon);
		bateriaIcon.setVisible(true);
		
		proyectilAmigo = Controlador.getInstancia().obtenerProyAmigo();
		proyAmigoIcon = new JLabel(imgProyectil);
		c.add(proyAmigoIcon);
		
		proyectilEnemigo = Controlador.getInstancia().obtenerProyectilEnemigos();
		proyEnemigoIcon = new JLabel(imgProyectil);
		c.add(proyEnemigoIcon);

		navesView = Controlador.getInstancia().obtenerNaves();
		for (int i=0; i<15; i++) {
			navesIcon.add(new JLabel(imgNave));
			navesIcon.get(i).setBounds(navesView.get(i).getX(),navesView.get(i).getY(),navesView.get(i).getH(),navesView.get(i).getW());
			c.add(navesIcon.get(i));
		}
		
		murosView = Controlador.getInstancia().obtenerMuro();
		for (int i=0; i<3; i++) {
			murosIcon.add(new JLabel(imgMuro));
			murosIcon.get(i).setBounds(murosView.get(i).getX(), murosView.get(i).getY(), murosView.get(i).getH(), murosView.get(i).getW());
			c.add(murosIcon.get(i));
		}
		
	}
	
	private void asignarEventos() {
		moverNaves movTimer = new moverNaves();
		timerMoverNaves = new Timer (Controlador.getInstancia().obtenerTiempo(), movTimer);
		timerMoverNaves.start();
		moverProyectiles movProy = new moverProyectiles();
		timerMoverProyectiles = new Timer(20, movProy);
		timerMoverProyectiles.start();
		generarProy1 proy1 = new generarProy1();
		timerProyectil1 = new Timer(1500,proy1);
		timerProyectil1.start();
		addKeyListener(this);
		verRanking vr = new verRanking();
		ranking.addActionListener(vr);
	}
	
	class verRanking implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Ranking rank = new Ranking();
			rank.setVisible(true);
			
		}
		
	}
	
	class moverNaves implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Controlador.getInstancia().moverNaves();
			navesView = Controlador.getInstancia().obtenerNaves();
			for (int i=0; i<navesView.size(); i++) {
				navesIcon.get(i).setBounds(navesView.get(i).getX(), navesView.get(i).getY(), navesView.get(i).getW(), navesView.get(i).getH());	
			}
		}
	}
	
	class moverProyectiles implements ActionListener{
		
		int indice = 0;
		int nave;
		boolean nivelSuperado;
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Controlador.getInstancia().moverProyectiles();
			proyectilAmigo = Controlador.getInstancia().obtenerProyAmigo();
			proyAmigoIcon.setBounds(proyectilAmigo.getX(), proyectilAmigo.getY(), 40, 40);
			if (!proyectilAmigo.isEnJuego())
				proyAmigoIcon.setVisible(false);
			proyectilEnemigo = Controlador.getInstancia().obtenerProyectilEnemigos();
			proyEnemigoIcon.setBounds(proyectilEnemigo.getX(), proyectilEnemigo.getY(), 40, 40);
			if (!proyectilEnemigo.isEnJuego())
				proyEnemigoIcon.setVisible(false);
			
			Controlador.getInstancia().detectarColisiones();
			proyectilAmigo = Controlador.getInstancia().obtenerProyAmigo();
			if (!proyectilAmigo.isEnJuego())
				proyAmigoIcon.setVisible(false);
			proyectilEnemigo = Controlador.getInstancia().obtenerProyectilEnemigos();
			if (!proyectilEnemigo.isEnJuego())
				proyEnemigoIcon.setVisible(false);
			navesView = Controlador.getInstancia().obtenerNaves();
			for (int i=0; i<navesView.size();i++) {
				if (!navesView.get(i).isEstaViva())
					navesIcon.get(i).setVisible(false);
			}
			murosView = Controlador.getInstancia().obtenerMuro();
			for (int i=0; i<murosView.size();i++) {
				if (!murosView.get(i).estaVivo())
					murosIcon.get(i).setVisible(false);
				else
					murosIcon.get(i).setVisible(true);
			}
			contPuntos = Controlador.getInstancia().getPuntos();
			puntos.setText(String.valueOf(contPuntos));
			contVidas = Controlador.getInstancia().getVidas();
			vidas.setText(String.valueOf(contVidas));
			
			if(Controlador.getInstancia().getNivelSuperado()) {
				pasarNivel();
				
			}
			
			if(Controlador.getInstancia().getPartidaPerdida()) {
				finalizarPartida();
			}
	}
	
	public void pasarNivel() {
		navesView = Controlador.getInstancia().obtenerNaves();
		for (int i=0; i<15; i++) {
			navesIcon.get(i).setBounds(navesView.get(i).getX(),navesView.get(i).getY(),navesView.get(i).getH(),navesView.get(i).getW());
			navesIcon.get(i).setVisible(true);
		}
		murosView = Controlador.getInstancia().obtenerMuro();
		for(int i=0; i<3; i++) {
			murosIcon.get(i).setBounds(murosView.get(i).getX(), murosView.get(i).getY(), murosView.get(i).getW(), murosView.get(i).getH());
		}
		contPuntos = Controlador.getInstancia().getPuntos();
		puntos.setText(String.valueOf(contPuntos));
		contVidas = Controlador.getInstancia().getVidas();
		vidas.setText(String.valueOf(contVidas));
		moverNaves movTimer = new moverNaves();
		timerMoverNaves = new Timer (Controlador.getInstancia().obtenerTiempo(), movTimer);
		timerMoverNaves.start();
		timerMoverProyectiles.restart();
		timerProyectil1.restart();
	}
	
	public void finalizarPartida() {
		ranking.setVisible(true);
		bateriaIcon.setVisible(false);
		timerMoverNaves.stop();
		timerMoverProyectiles.stop();
		timerProyectil1.stop();
		textoGameOver.setVisible(true);
		if (proyAmigoIcon.isVisible())
			proyAmigoIcon.setVisible(false);
		if (proyEnemigoIcon.isVisible())
			proyEnemigoIcon.setVisible(false);
		for (int i=0; i<15; i++) {
			if (i<3) {
				if (murosIcon.get(i).isVisible())
					murosIcon.get(i).setVisible(false);
			}
			if (navesIcon.get(i).isVisible())
				navesIcon.get(i).setVisible(false);
		}
	}
	
	}

	class generarProy1 implements ActionListener{
		
		private Random r = new Random();
		boolean visible = false;
		int nave;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			nave = r.nextInt(15);
			if (!navesView.get(nave).isEstaViva()) {
			while(!navesView.get(nave).isEstaViva())
				nave = r.nextInt(15);
			}
			if (!proyectilEnemigo.isEnJuego()) {
				Controlador.getInstancia().dispararProyectil(navesView.get(nave).getX(), navesView.get(nave).getY(),true);
				proyectilEnemigo = Controlador.getInstancia().obtenerProyectilEnemigos();
				proyEnemigoIcon.setBounds(proyectilEnemigo.getX(), proyectilEnemigo.getY(), 40, 40);
				proyEnemigoIcon.setVisible(true);
			}
					
		}
		
	}
		
	@Override
	public void keyPressed(KeyEvent e) {
		if( e.getKeyCode() == KeyEvent.VK_LEFT) {
			Controlador.getInstancia().moverBateria(0);
			bateria = Controlador.getInstancia().obtenerBateria();
			bateriaIcon.setBounds(bateria.getX(), bateria.getY(),bateria.getW(),bateria.getH());
		}
		else if( e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Controlador.getInstancia().moverBateria(1);
			bateria = Controlador.getInstancia().obtenerBateria();
			bateriaIcon.setBounds(bateria.getX(), bateria.getY(),bateria.getW(),bateria.getH());
		}
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (!proyectilAmigo.isEnJuego()) {
				Controlador.getInstancia().dispararProyectil(bateria.getX()+25, bateria.getY(),false);
				proyectilAmigo = Controlador.getInstancia().obtenerProyAmigo();
				proyAmigoIcon.setBounds(proyectilAmigo.getX(), proyectilAmigo.getY(), 40, 40);
				proyAmigoIcon.setVisible(true);
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stu


		
	}
		
}
