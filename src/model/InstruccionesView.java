package model;

import processing.core.PApplet;
import processing.core.PImage;

public class InstruccionesView extends Pantallas {
	PImage instruccionesVid[];
	
	public InstruccionesView(PApplet app) {
		super(app);
		instruccionesVid = new PImage[184];
	}
	
	public void drawIt() {
		
		for (int i = 0; i <184; i++) { 
		    instruccionesVid[i] = loadImage("./img/instructionsGif/"+"000"+(i+1)+".png");

		}
		
	}
	

}
