package model;

import com.google.gson.Gson;

import processing.core.PApplet;

public class StartView extends Pantallas implements ObserverMessage {
	private TCPLauncher tcp;
	private Jugador jugador;
	public StartView(PApplet app) {
		super(app);
		
	}
	
	public void load() {
		tcp=TCPLauncher.getInstance();
		tcp.suscripcion(this);
	}
	
	public void drawIt() {
		
	}

	@Override
	public void readmsg(Session session, String alo) {
		// TODO Auto-generated method stub
		 Gson gson=new Gson();
	 	  Generic generic=gson.fromJson(alo, Generic.class);
	 	  switch(generic.type) {
	 	  case "Jugador":
	 		 jugador=gson.fromJson(alo, Jugador.class);
	 		  break;
	 	  }
		
	}
	
	

}
