package model;

import com.google.gson.Gson;

import processing.core.PApplet;
import processing.core.PImage;

public class StartView extends Pantallas {
	
	private PImage bg;
	
	
	public StartView(PApplet app) {
		super(app);
	
		bg=app.loadImage("./img/rock.png");
	}

	
	public void drawIt() {
		app.image(bg, 0, 0);
		
		
	}

	
	

}
