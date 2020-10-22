package model;

import processing.core.PApplet;
import processing.core.PImage;

public class ScoresView extends Pantallas {
	
	private PImage fondo,kurt,avril;
	public ScoresView(PApplet app) {
		super(app);
		fondo=app.loadImage("img/score.png");
		kurt=app.loadImage("img/kurt.png");
		avril=app.loadImage("img/avril.png");
		
		
	}
	
	public void drawIt() {
		app.image(fondo,0,0);
		System.out.println();
		
		if(PartidaView.scoreJugador1==10) {
			app.image(avril, 0, 0);	
			app.text(PartidaView.scoreJugador1,720,450);	
		}
		if(PartidaView.scoreJugador2==100) {
			app.image(avril, 0, 0);	
			app.text(PartidaView.scoreJugador2,700,420);	
		}
		
	}

}
