
package model;

import processing.core.PApplet;

public class MainView extends PApplet{

	PartidaView partida; 
	ScoresView scorePantalla;
	ConexionView conexionPantalla;
	InstruccionesView instruccionesPantalla;
	private int pantallas;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("model.MainView");

	}
	public void settings() {
			size(1200,700); 
	}

	public void setup() {
		partida = new PartidaView(this); 
		scorePantalla = new ScoresView(this); 
		conexionPantalla = new ConexionView(this); 
		instruccionesPantalla = new InstruccionesView(this); 
		partida.load();
		pantallas=0;

	}

	public void draw() {
		background(255,255,0); 
	
		
		switch(pantallas) {
		case 0:
			//aqui conexion
			partida.drawIt();
			break;
		case 1:
			//aqui iria play
			conexionPantalla.drawIt();
			break;
		case 2:
			instruccionesPantalla.drawIt();
			break;
		case 3:
			//aqui iria partida
			
			break;
		case 4:
			scorePantalla.drawIt();
			break;
			
		}
	}

}
