package model;

import processing.core.PApplet;
import processing.core.PImage;

public class ConexionView extends Pantallas {
	PImage fondo,playerOneConnected,playerTwoConnected;
	public ConexionView(PApplet app) {
		super(app);
		fondo=loadImage("./img/connectBg.png");
		playerOneConnected=loadImage("./img/playerOneConnect.png");
		playerTwoConnected=loadImage("./img/playerTwoConnect.png");
	}

	public void drawIt() {
		image(fondo,0,0);
//		if(playerOne==connected) {
//			image(playerOneConnected,0,0);
//		}
//		if(playerTwo==connected) {
//			image(playerOneConnected,0,0);
//		}
	}
}
