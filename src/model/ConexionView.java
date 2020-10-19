package model;


import com.google.gson.Gson;

import processing.core.PApplet;
import processing.core.PImage;

public class ConexionView extends Pantallas {
	PImage fondo,playerOneConnected,playerTwoConnected;
	private PartidaView logica;
	private String jugador1;
	private TCPLauncher tcp;
	private Jugador jugador;
	private String jugador2;
	private int pantalla;
	private boolean jugador1Conectado,jugador2Conectado;

	public ConexionView(PApplet app) {
		super(app);
		fondo=app.loadImage("./img/connectBg.png");
		playerOneConnected=app.loadImage("./img/playerOneConnect.png");
		playerTwoConnected=app.loadImage("./img/playerTwoConnect.png");
		logica=new PartidaView(app);
		pantalla=0;
		jugador1="jugadorUno";
		jugador2="jugadorDos";
	}
	public void load() {
	

	
	}
	
	public void drawIt() {
		app.image(fondo,0,0);
		conexion(logica);
		
		
	}
	
	public void conexion (PartidaView jugadorState) {
		
//		if(jugadorState!=null) {
//			if(jugador1.equals(jugadorState.getJugador().getJugador())) {
//				image(playerOneConnected,0,0);
//				jugador1Conectado=true;
//			}
//			if(jugador2.equals(jugadorState.getJugador().getJugador())) {
//				image(playerTwoConnected,0,0);
//				jugador2Conectado=true;
//			}
//			}
		
		if(jugador1Conectado&&jugador2Conectado==true) {
			pantalla=1;
		}
	}
	public int getPantalla() {
		return pantalla;
	}
	public void setPantalla(int pantalla) {
		this.pantalla = pantalla;
	}


//	@Override
//	public void readmsg(Session session, String alo) {
//		// TODO Auto-generated method stub
//		 Gson gson=new Gson();
//	 	  Generic generic=gson.fromJson(alo, Generic.class);
//	 	  switch(generic.type) {
//	 	  case "Jugador":
//	 		 jugador=gson.fromJson(alo, Jugador.class);
//	 		  break;
//	 	  }
		
	
		
//	}
	
	
	
	
}
