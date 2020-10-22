package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Note {

	//constructor solo pos en grid
	int x, y, tamX, tamY, aumentoX, aumentoY; 
	PApplet app; 
	PImage noteImg;
	public Note(int x, int y) {
		this.x = x; 
		this.y = y; 	
		this.noteImg=noteImg;
	}
	
	//info de su guitarra
	public void bringBoardScale( int tamX, int tamY, int aumentoX, int aumentoY) {
		this.tamX = tamX; 
		this.tamY = tamY; 
		this.aumentoX = aumentoX; 
		this.aumentoY = aumentoY; 
	
		
	}
	//movimiento de las notas
	public void moved(int stop) {
		
		if(app.frameCount%30==0) {
			if(y+1 < stop) {
				
				y+=1;
			}
		}
	
	}
	
	//pintarlaa
	public void paintNote() {
		app.fill(0,255,255);
		app.image(noteImg,aumentoX+(x*tamX), aumentoY+(y*tamY));
		
	}
	
	
	//get---set
	public void appInstance(PApplet app) {
		this.app = app; 
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public PImage getNoteImg() {
		return noteImg;
	}

	public void setNoteImg(PImage noteImg) {
		this.noteImg = noteImg;
	}

	
	

}
