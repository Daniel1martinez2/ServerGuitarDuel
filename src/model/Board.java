package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Board {
	PApplet app; 
	//Note re; 
	//Note f; 
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
		
		
		
		/*
		re = new Note(0,0); 
		re.bringBoardScale(tamX, tamY, x, y); 
		re.appInstance(app);
		
		f.appInstance(app);
		f = new Note(0,1); 
		f.bringBoardScale(tamX, tamY, x, y); 
		
		*/
		notas = new ArrayList<Note>(); 
	
		
	
	
		
		
		
			
	}
	
	public void paintIt() {
		
		for(int i = 0; i<columnas; i++) {
			for(int o = 0 ; o < filas; o++) {
				app.fill(255,0,255); 
				app.rect((i*tamX)+x, (o*tamY)+y, tamX, tamY);
			}
		}
		/*re.paintNote();
		re.moved(9);
		
		f.paintNote();
		f.moved(5);*/
		
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
		
		if(notas!=null) {
			for(int i = 0; i < notas.size();i++ ) {
				notas.get(i).paintNote();
				notas.get(i).moved(9);
				if(notas.get(i).getY()>6) {
					notas.remove(i); 
				}
				
				
		}
	
			
		}
		
		//System.out.println(notas.size());
	
	}

	
}

