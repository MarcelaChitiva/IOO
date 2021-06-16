package gui;

import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import controlador.Controlador;
import views.JugadorView;

public class Ranking extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTitulo;
	ArrayList<JLabel> lblJugadores = new ArrayList<JLabel>();
	ArrayList<JugadorView> top10;
	public Ranking() {
		
		configurar();
		this.setSize(800,700);
		this.setVisible(true);
	}
	
	private void configurar() {
		Container c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.black);
		this.setTitle("Ranking");
		
		lblTitulo = new JLabel("MEJORES 10 PUNTAJES");
		lblTitulo.setForeground(Color.green);
		lblTitulo.setFont(new java.awt.Font("Agency FB",1,52));
		lblTitulo.setBounds(220,1,500,80);
		
		top10 = Controlador.getInstancia().obtenerRanking();
		int y = 50;
		for (int i = 0; i<top10.size();i++) {
			lblJugadores.add(new JLabel());
			lblJugadores.get(i).setForeground(Color.white);
			lblJugadores.get(i).setFont(new java.awt.Font("Agency FB",1,30));
			y+=50;
			lblJugadores.get(i).setBounds(200, y, 400, 50);
			c.add(lblJugadores.get(i));
			lblJugadores.get(i).setText(i+1+":   "+top10.get(i).getNombre()+"   -   "+top10.get(i).getPuntaje()+"  puntos");
		}
		c.add(lblTitulo);
		
	}
	
	

}
