
package model;

import processing.core.PApplet;

public class MainView extends PApplet{

	PartidaView partida; 
	ScoresView scorePantalla;
	ConexionView conexionPantalla;
	InstruccionesView instruccionesPantalla;
	StartView startPantalla;
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
		startPantalla = new StartView(this);
		scorePantalla = new ScoresView(this); 
		scorePantalla.loadImage();
		conexionPantalla = new ConexionView(this); 
		instruccionesPantalla = new InstruccionesView(this); 
		conexionPantalla.load();
		partida.load();
		pantallas=3;

	}

	public void draw() {
		background(255,255,0); 
	
		
		switch(pantallas) {
		case 0:
			//aqui conexion
			conexionPantalla.drawIt();
			pantallas=conexionPantalla.getPantalla();
			
			break;
		case 1:
			//aqui iria play
			startPantalla.drawIt();
			break;
		case 2:
			instruccionesPantalla.drawIt();
			break;
		case 3:
			//aqui iria partida
			partida.drawIt();
			break;
		case 4:
			scorePantalla.drawIt();
			break;
			
		}
	}

}
