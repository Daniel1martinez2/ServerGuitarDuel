
package model;

import processing.core.PApplet;
import processing.core.PFont;
import processing.sound.SoundFile;

public class MainView extends PApplet{

	PartidaView partida; 
	ScoresView scorePantalla;
	ConexionView conexionPantalla;
	InstruccionesView instruccionesPantalla;
	StartView startPantalla;
	private PFont font;
	

	public static int pantallita;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("model.MainView");

	}
	public void settings() {
			size(1200,700); 
	}

	
	
	public void setup() {
		
		font=createFont("./img/axis.otf", 20);	
		partida = new PartidaView(this); 
		startPantalla = new StartView(this);
		scorePantalla = new ScoresView(this); 
		conexionPantalla = new ConexionView(this); 
		instruccionesPantalla = new InstruccionesView(this); 
		partida.load();
		pantallita=0;
		

	}

	public void draw() {
		background(255,255,0); 
	
		textFont(font);
		
		
		
		switch(pantallita) {
		case 0:
			//aqui conexion
			conexionPantalla.drawIt();
			
			
			break;
		case 1:
			//aqui iria play
			startPantalla.drawIt();
			PartidaView.sound = true; 
			
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
	
	
	public void mousePressed() {
		System.out.println(mouseX+"posX"+mouseY+"poxY");
		
	}
	

}
