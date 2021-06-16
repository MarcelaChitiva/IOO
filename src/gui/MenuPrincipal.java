package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.Controlador;

public class MenuPrincipal extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnJugar, btnRanking, btnInfo, btnPartida;
	private JLabel lblTitulo, lblNombre, lblNivel;
	private JTextField txtNombre;
	private JComboBox<String> niveles;
	
	public MenuPrincipal() {
		configurar();
		asignarEventos();
		this.setVisible(true);
		this.setSize(800,600);
	}
	
	private void configurar() {
		Container c = this.getContentPane();
		c.setLayout(null);
		this.setTitle("Space Invaders");
		c.setBackground(Color.black);
		
		btnJugar = new JButton("JUGAR");
		btnRanking = new JButton("RANKING");
		btnInfo = new JButton("CONTROLES");
		btnPartida = new JButton("COMENZAR PARTIDA");
		lblTitulo = new JLabel("SPACE INVADERS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre = new JLabel("NOMBRE: ");
		lblNivel = new JLabel("NIVEL : ");
		txtNombre = new JTextField("Ingrese su nombre");
		niveles = new JComboBox<String>();
		
		lblTitulo.setBounds(250, 100, 300, 150);
		btnJugar.setBounds(50, 300, 200, 80);
		btnRanking.setBounds(300, 300, 200, 80);
		btnInfo.setBounds(550, 300, 200, 80);
		btnPartida.setBounds(300,450,200,80);
		lblNombre.setBounds(100, 100, 200, 50);
		lblNivel.setBounds(100,300,200,80);
		txtNombre.setBounds(300, 90, 300, 80);
		niveles.setBounds(300, 300, 300, 80);
		
		btnJugar.setBackground(Color.green);
		btnRanking.setBackground(Color.green);
		btnPartida.setBackground(Color.green);
		btnInfo.setBackground(Color.green);
		lblNombre.setForeground(Color.green);
		lblNivel.setForeground(Color.green);
		txtNombre.setBackground(Color.green);
		lblTitulo.setForeground(Color.green);
		niveles.setBackground(Color.green);
		txtNombre.setFont(new java.awt.Font("Agency FB",1,22));
		lblNombre.setFont(new java.awt.Font("Agency FB",1,40));
		lblNivel.setFont(new java.awt.Font("Agency FB",1,40));
		lblTitulo.setFont(new java.awt.Font("Agency FB",1,52));
		btnInfo.setFont( new java.awt.Font("Agency FB",1,22));
		btnJugar.setFont( new java.awt.Font("Agency FB",1,22));
		btnRanking.setFont( new java.awt.Font("Agency FB",1,22));
		btnPartida.setFont(new java.awt.Font("Agency FB",1,22));
		niveles.setFont(new java.awt.Font("Agency FB",1,22));
		
		niveles.addItem("NIVEL");
		niveles.addItem("CADETE");
		niveles.addItem("GUERRERO");
		niveles.addItem("MASTER");
		niveles.setSelectedIndex(0);
		
		btnPartida.setVisible(false);
		lblNombre.setVisible(false);
		lblNivel.setVisible(false);
		txtNombre.setVisible(false);
		niveles.setVisible(false);
		
		c.add(lblTitulo);
		c.add(btnJugar);
		c.add(btnRanking);
		c.add(btnInfo);
		c.add(lblNombre);
		c.add(lblNivel);
		c.add(txtNombre);
		c.add(btnPartida);
		c.add(niveles);
	}
	
	private void asignarEventos() {
		ManejoBotones mb = new ManejoBotones();
		btnJugar.addActionListener(mb);
		btnInfo.addActionListener(mb);
		btnRanking.addActionListener(mb);
		btnPartida.addActionListener(mb);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	class ManejoBotones implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent boton) {
			if (boton.getSource().equals(btnInfo)) {
				Ayuda a = new Ayuda();
				a.setVisible(true);
			}
			else if (boton.getSource().equals(btnRanking)) {
				Ranking rank = new Ranking();
				rank.setVisible(true);
			}
			else if (boton.getSource().equals(btnPartida)){
				btnJugar.setVisible(true);
				btnInfo.setVisible(true);
				btnRanking.setVisible(true);
				lblNombre.setVisible(false);
				btnPartida.setVisible(false);
				lblNivel.setVisible(false);
				txtNombre.setVisible(false);
				lblTitulo.setVisible(true);
				niveles.setVisible(false);
				Controlador.getInstancia().crearPartida(800, 600);
				Controlador.getInstancia().cargarNivel(niveles.getSelectedItem());
				Controlador.getInstancia().crearJugador(txtNombre.getText());
				Partida p1 = new Partida();
				p1.setVisible(true);
			}
			else if (boton.getSource().equals(btnJugar)) {
				btnJugar.setVisible(false);
				btnInfo.setVisible(false);
				btnRanking.setVisible(false);
				lblNombre.setVisible(true);
				btnPartida.setVisible(true);
				lblNivel.setVisible(true);
				txtNombre.setVisible(true);
				lblTitulo.setVisible(false);
				niveles.setVisible(true);
			}
		}
		
		
	}
}