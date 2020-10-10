
package model;

import processing.core.PApplet;

public class MainView extends PApplet{

	PartidaView partida; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("model.MainView");

	}
	public void settings() {
			size(1200,700); 
	}

	public void setup() {
		partida = new PartidaView(this); 
		partida.load();

	}

	public void draw() {
		background(255,255,0); 
		partida.drawIt();

	}

}
