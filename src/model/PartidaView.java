package model;

import processing.core.PApplet;
import processing.core.PImage;

public class PartidaView extends Pantallas{
	
	PImage fondo; 
	Board guitar1, guitar2; 

	public PartidaView(PApplet app) {
		super(app);
	
		
	}
	
	public void load() {
		fondo = app.loadImage("img/juego.png"); 
		guitar1 = new Board(152, 0,7,3, app); 
		guitar2 = new  Board(770,0,7,3, app);
		
	}
	
	public void drawIt() {
		app.image(fondo, 0, 0);
		guitar1.paintIt();
		guitar2.paintIt();
	}
	
	
	
	


}
