package model;

import com.google.gson.Gson;

import processing.core.PApplet;
import processing.core.PImage;

public class PartidaView extends Pantallas implements ObserverMessage{
	
	PImage fondo; 
	
	Board guitar1, guitar2; 
	private Jugador jugador;
	private VerifNota verifnota;
	private TCPLauncher tcp;

	public PartidaView(PApplet app) {
		super(app);
		
	
		
	}
	
	public void load() {
		tcp=TCPLauncher.getInstance();
		tcp.suscripcion(this);
		fondo = app.loadImage("img/juego.png"); 
		guitar1 = new Board(152, 0,7,3, app); 
		guitar2 = new  Board(770,0,7,3, app);
		 
		
		
	}
	
	
	
	
	public void drawIt() {
		app.image(fondo, 0, 0);
		guitar1.paintIt();
		guitar2.paintIt();
		
	}

	@Override
	public void readmsg(Session session, String alo) {
		  Gson gson=new Gson();
	 	  Generic generic=gson.fromJson(alo, Generic.class);
	 	  switch(generic.type) {
	 	  case "Jugador":
	 		 jugador=gson.fromJson(alo, Jugador.class);
	 		 
	 		  break;
	 		
	 	  case "Nota":
	 		  verifnota=gson.fromJson(alo, VerifNota.class);
	 		  break;
	 	  }

		
	}
	
	
	
	


}
