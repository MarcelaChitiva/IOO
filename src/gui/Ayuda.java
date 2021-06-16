package gui;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ayuda extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel izquierda, derecha, espacio;
	
	public Ayuda() {
		this.setSize(500,300);
		Container c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.black);
		this.setVisible(true);
		JLabel izquierda = new JLabel("Flecha izquierda:   Mueve hacia la izquierda");
		JLabel espacio = new JLabel("Barra espaciadora:    Dispara proyectiles");
		izquierda.setForeground(Color.green);
		izquierda.setFont(new java.awt.Font("Agency FB",1,30));
		c.add(izquierda);
		izquierda.setBounds(10, 10, 400, 80);
		espacio.setForeground(Color.white);
		espacio.setFont(new java.awt.Font("Agency FB",1,30));
		c.add(espacio);
		espacio.setBounds(10, 190, 400, 80);
		JLabel derecha = new JLabel("Flecha derecha:   Mueve hacia la derecha");
		derecha.setForeground(Color.green);
		derecha.setFont(new java.awt.Font("Agency FB",1,30));
		c.add(derecha);
		derecha.setBounds(10, 100, 400, 80);
	}

}
