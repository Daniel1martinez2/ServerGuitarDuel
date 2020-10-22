package model;


import com.google.gson.Gson;

import processing.core.PApplet;
import processing.core.PImage;

public class ConexionView extends Pantallas implements ObserverMessage {
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
		tcp=TCPLauncher.getInstance();
		tcp.suscripcion(this);
	
		fondo=app.loadImage("./img/connectBg.png");
		playerOneConnected=app.loadImage("./img/playerOneConnect.png");
		playerTwoConnected=app.loadImage("./img/playerTwoConnect.png");
		logica=new PartidaView(app);
		pantalla=0;
		jugador1="jugadorUno";
		jugador2="jugadorDos";
	}
	
	
	public void drawIt() {
		app.image(fondo,0,0);
		conexion();
		
		
	}
	
	public void conexion () {
		
		for(int i=0;i<tcp.getSessions().size();i++) {
			if(tcp.getSessions().size()==1) {
				MainView.pantallita=1;
				
	
			}
		
		}
	
		
		
		
		


	}

	@Override
	public void readmsg(Session session, String alo) {
		// TODO Auto-generated method stub
		System.out.println(session.getID());
		  Gson gson=new Gson();
	 	  Generic generic=gson.fromJson(alo, Generic.class);
	 	  switch(generic.type) {
	 	  case "Jugador":
	 		 jugador=gson.fromJson(alo, Jugador.class);
	 		  break;
	 	  case "Note":
	 		  VerifNota verifnota = gson.fromJson(alo, VerifNota.class);
	 		 
	 		
	 		  break;
	 	  }
	 	  
		
	}

	
	
	
	
}
