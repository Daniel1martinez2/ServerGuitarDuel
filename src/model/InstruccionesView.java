package model;

import processing.core.PApplet;
import processing.core.PImage;

public class InstruccionesView extends Pantallas {
	PImage instruccionesVid[];
	private int estado;
	public InstruccionesView(PApplet app) {
		super(app);
		estado=0;
		instruccionesVid = new PImage[184];
		for (int i = 0; i <184; i++) { 
		    instruccionesVid[i] = app.loadImage("./img/instructionsGif/"+"1 ("+(i+1)+").jpg");

		}

		
	}
	
	public void drawIt() {
		app.background(0,0,0);
		  app.image(this.instruccionesVid[this.estado], 0,0);
	      if(frameCount %2 == 0){
	        this.estado++;
	    }
	    if(this.estado == 184){
	        this.estado=0;
	        
	    }
		
	
	}






}
