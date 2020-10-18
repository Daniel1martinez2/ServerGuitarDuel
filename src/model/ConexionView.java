package model;

import processing.core.PApplet;
import processing.core.PImage;

public class ConexionView extends Pantallas {
	PImage fondo,playerOneConnected,playerTwoConnected;
	public ConexionView(PApplet app) {
		super(app);
		fondo=app.loadImage("./img/connectBg.png");
		playerOneConnected=app.loadImage("./img/playerOneConnect.png");
		playerTwoConnected=app.loadImage("./img/playerTwoConnect.png");
	}

	
	public void drawIt() {
		app.image(fondo,0,0);
//		if(playerOne==connected) {
//			image(playerOneConnected,0,0);
//		}
//		if(playerTwo==connected) {
//			image(playerOneConnected,0,0);
//		}
	}
}
