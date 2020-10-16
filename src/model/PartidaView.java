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
	private int score;
	private boolean blueNoteState,greenNoteState,orangeNoteState;
	
	public PartidaView(PApplet app) {
		super(app);
		
	
		
	}
	
	public void load() {
		tcp=TCPLauncher.getInstance();
		tcp.suscripcion(this);
		fondo = app.loadImage("img/juego.png"); 
		guitar1 = new Board(152, 0,7,3, app); 
		guitar2 = new  Board(770,0,7,3, app);
		blueNoteState=false;
		greenNoteState=false;
		orangeNoteState=false; 
		score=0;
	
		
		
		
	}
	
	public void drawIt() {
		app.image(fondo, 0, 0);
		guitar1.paintIt();
		guitar2.paintIt();
		
		//VerifNota testNOta = new VerifNota(true, false, false); 
		verificarClicNota1(verifnota); 
	}
	


//>>>>>>>>>>>>>
		public void verificarClicNota1(VerifNota currentState) {

			//iz: azul
			//mid: verde
			//der: naranja
			if (currentState != null){
			if (currentState.isBlue()){
				posicionNota( 0, blueNoteState);
			}
	}

}	
		
		
		public void posicionNota(int posx, boolean nota) {

		for(int i = 0; i < guitar1.getNotas().size();i++ ) {
			if(guitar1.getNotas().get(i).getY()==6&&guitar1.getNotas().get(i).getX()==posx) {
				nota=true;
				score+=10;
				guitar1.getNotas().remove(i);
				System.out.println(score);
			}
			if(guitar1.getNotas().get(i).getY()!=6&&guitar1.getNotas().get(i).getX()!=posx) {
				nota=false;
			}
			}
		}

	
	@Override
	public void readmsg(Session session, String alo) {
		System.out.println(alo);
		  Gson gson=new Gson();
	 	  Generic generic=gson.fromJson(alo, Generic.class);
	 	  switch(generic.type) {
	 	  case "Jugador":
	 		 jugador=gson.fromJson(alo, Jugador.class);
	 		  break;
	 	  case "Note":
	 		  verifnota=gson.fromJson(alo, VerifNota.class);
	 		  break;
	 	  }
	 	
	}
}
