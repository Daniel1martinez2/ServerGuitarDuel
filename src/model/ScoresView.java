package model;

import processing.core.PApplet;
import processing.core.PImage;

public class ScoresView extends Pantallas {
	private PImage fondo;
	public ScoresView(PApplet app) {
		super(app);
		
		
		
	}
	
	public void loadImage() {
		fondo=app.loadImage("img/score.png");
	}
	public void drawIt() {
		//app.image(fondo,0,0);
		
	}

}
