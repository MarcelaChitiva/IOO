package modelo;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Ranking{
	private boolean cambio = false;
    private ArrayList<Jugador> top20;
	public Ranking() {
		this.top20 = new ArrayList<Jugador>();
		try {
	    	Scanner input = new Scanner (new File("src/ranking.txt"));
	    	while (input.hasNextLine()) {
	    		String line = input.nextLine();
	    		line.replace(line, ""); // Que hace esto?
	    		String[] lista = line.split(";");
	    		Jugador aux = new Jugador(lista[0]);
	    		aux.actualizarPuntaje(Integer.valueOf(lista[1]));
	    		top20.add(aux);
	    		line.replace(line, "");
	    	}
	    	input.close();	
	    }
    	catch (Exception e) {
    	}
	}

    public void clasificarJugador(Jugador jugador) {
        if (top20.size()<20 || top20.get(19).getPuntaje() < jugador.getPuntaje()) {
        	if (top20.size()>=20)
        		top20.remove(19);
        	top20.add(jugador);
        	Collections.sort(top20, new compararJugadores());
        	cambio = true;
        }
        if (cambio) {
        	cambio = false;
        	try {
    			RandomAccessFile archivo = new RandomAccessFile("src/ranking.txt","rw");
        		for (int i=0; i<top20.size();i++) {
    	    		String line = top20.get(i).getNombre()+";"+String.valueOf(top20.get(i).getPuntaje());
    	    		archivo.writeBytes(line);
    	    		archivo.writeBytes("\r\n");	
    	    	}
        		archivo.close();
    		}
        	catch (Exception e) {
        	}
        }
    }
    
    private class compararJugadores implements Comparator<Jugador>{

		@Override
		public int compare(Jugador j1, Jugador j2) {
			if (j1.getPuntaje()>j2.getPuntaje())
				return -1;
			else if (j1.getPuntaje()<j2.getPuntaje())
				return 1;
			return 0;
		}
    }

    public ArrayList<Jugador> devolverTop20() {
    	return top20;
    }
}