package model;

import processing.core.PApplet;
import processing.core.PImage;

public class ScoresView extends Pantallas {
	private PImage fondo;
	public ScoresView(PApplet app) {
		super(app);
		fondo=loadImage("./img/score.png");
		
		
	}
	
	
	public void drawIt() {
		image(fondo,0,0);
		
	}

}
