package model;

import java.util.ArrayList;
import java.util.Iterator;

import processing.core.PApplet;
import processing.core.PImage;


public class Board {
	PApplet app; 
	PImage blueNote;
	PImage greenNote;
	PImage orangeNote;
	ArrayList<Note> notas; 
	int x,y, filas, columnas, tamX, tamY; 
	public Board(int x, int y, int filas, int columnas, PApplet app) {
		
		this.columnas= columnas;
		this.filas = filas; 
		tamX  = 90;
		tamY = 100; 
		this.x = x; 
		this.y = y; 
		this.app = app; 
		blueNote=app.loadImage("./img/blue_1.png");
		greenNote=app.loadImage("./img/green_1.png");
		orangeNote=app.loadImage("./img/orange_1.png");
		
		

		notas = new ArrayList<Note>(); 
			
	}
	
	public void paintIt() {
		
		for(int i = 0; i<columnas; i++) {
			for(int o = 0 ; o < filas; o++) {
				app.noStroke();
				app.fill(255,0,255,0); 
				app.rect((i*tamX)+x, (o*tamY)+y, tamX, tamY);
				
			}
		}
	
		paintMoved(); 
		
	}
	
	public void crearNotas() {
			
				if(app.frameCount%100==0) {
					
					notas.add(new Note((int) app.random(0,3),0)); 
				}
	
		
	}
	
	public void paintMoved() {
		crearNotas(); 
		if(notas!=null) {
			for(int i = 0; i < notas.size();i++ ) {
				notas.get(i).appInstance(app);
				notas.get(i).bringBoardScale(tamX, tamY, x, y);
				
			}
		}
		
		Iterator<Note> i = notas.iterator();
		
		while (i.hasNext()) {
			  Note n = i.next();
			  if(n.getX()==0) {
			    n.setNoteImg(blueNote);
			  }
			  if(n.getX()==1) {
				  n.setNoteImg(greenNote);
			  }
			  if(n.getX()==2) {
				  n.setNoteImg(orangeNote);
			  }
				n.paintNote();
				n.moved(9);
				if(n.getY()>6) {
					i.remove(); 
				}

	
			
		}
		
	
	}

	public ArrayList<Note> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Note> notas) {
		this.notas = notas;
	}
	
	
	
	

	
}

