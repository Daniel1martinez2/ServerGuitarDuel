package model;

import com.google.gson.Gson;

import processing.core.PApplet;

import processing.core.PImage;
import processing.sound.SoundFile;

public class PartidaView extends Pantallas implements ObserverMessage{
	
	PImage fondo; 
	
	Board guitar1, guitar2; 
	private Jugador jugador1;
	private Jugador jugador2;
	private VerifNota verifnota1;
	private VerifNota verifnota2;
	private TCPLauncher tcp;
	private SoundFile efe; 
	public static boolean sound = false; 
	public static int scoreJugador1,scoreJugador2;
	private boolean blueNoteState,greenNoteState,orangeNoteState;
	private boolean barrera;
	
	public PartidaView(PApplet app) {
		super(app);
		
	
	}
	
	public void load() {
		tcp=TCPLauncher.getInstance();
		tcp.suscripcion(this);
		
	
	
		barrera=false;
		fondo = app.loadImage("img/juego.png"); 
		guitar1 = new Board(152,0,7,3, app); 
		guitar2 = new  Board(770,0,7,3, app);
		blueNoteState=false;
		greenNoteState=false;
		orangeNoteState=false; 
		scoreJugador1=0;
		scoreJugador2=0;
		efe = new SoundFile(app,"sfx/avril.mp3");
		sounds(); 
		
		
		
	}
	
	public void sounds() {
			new Thread(
					()->{
						try {
							Thread.sleep(300);
							efe.amp((float) 0.1);
							
							if(MainView.pantallita ==0) {
								efe.stop();  
							}
							if(MainView.pantallita == 1) {
								
								
								
							}
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					}
				).start();
	}
	
	public void drawIt() {
		app.image(fondo, 0, 0);
		
		app.text(scoreJugador1,45,160);
		app.text(scoreJugador2,1086,160);
		guitar1.paintIt();
		guitar2.paintIt();
		
		//VerifNota testNOta = new VerifNota(true, false, false); 
		verificarClicNota1(verifnota1, guitar1);
		verificarClicNota1(verifnota2, guitar2);
		if(scoreJugador1==10) {
			MainView.pantallita=4;
			efe.stop(); 
		}
		if(scoreJugador2==100) {
			MainView.pantallita=4;
			efe.stop(); 
		}
	
		
	}
	



//>>>>>>>>>>>>>
		public void verificarClicNota1(VerifNota currentState, Board guitar) {

			//iz: azul
			//mid: verde
			//der: naranja
			if (currentState != null){
			if (currentState.isBlue()){
				posicionNota( 0, blueNoteState, guitar);
			}
			if (currentState.isGreen()){
				posicionNota( 1, greenNoteState, guitar);
			}
			if (currentState.isOrange()){
				posicionNota( 2, orangeNoteState, guitar);
			}
	}

}	
		
		
		public void posicionNota(int posx, boolean nota, Board guitar) {
	
		for(int i = 0; i < guitar.getNotas().size();i++ ) {
			if(guitar.getNotas().get(i).getY()==6&&guitar.getNotas().get(i).getX()==posx) {
			
				nota=true;
				if(guitar == guitar1){
				scoreJugador1+=10;
				guitar.getNotas().remove(i);
				}else{	
				scoreJugador2+=10;
				guitar.getNotas().remove(i);
				}
			
				
			}
			if(guitar.getNotas().get(i).getY()!=6&&guitar.getNotas().get(i).getX()!=posx) {
				nota=false;
			}
			
			}
			
		}
			
		
				
		
		
		
		
	
	@Override
	public void readmsg(Session session, String alo) {
		
		
//		System.out.println(session.getID());
		  Gson gson=new Gson();
	 	  Generic generic=gson.fromJson(alo, Generic.class);
	 	  switch(generic.type) {
	 	  case "Jugador":
		   if(jugador1 == null){
 				jugador1=gson.fromJson(alo, Jugador.class);
		   }else{
 				jugador2=gson.fromJson(alo, Jugador.class);
		   }
	 		  break;
	 	  case "Note":
		   
	 		if (generic.id.equals(jugador1.getId()) ){
				
	 			verifnota1=gson.fromJson(alo, VerifNota.class);
	 			System.out.println(generic.id+" "+jugador1.getId());
	 			 if(MainView.pantallita==1 && verifnota1.isBlue()!=true && verifnota1.isOrange()!=true&&verifnota1.isGreen()!=true) {
			 		  MainView.pantallita=2;
			 		
			 		 
			 		  return;
			 	  }
		 		 if(MainView.pantallita==2 && verifnota1.isBlue()!=true && verifnota1.isOrange()!=true&&verifnota1.isGreen()!=true) {
			 		  MainView.pantallita=3;
			 		  efe.play();
			 		
			 		  
			 		  return;
			 	  }
		 		 
		 		 if(MainView.pantallita==3) {
		 			 barrera=false;
		 			  
		 			  
		 		 }
		 		 
		 		new java.util.Timer().schedule( 
		 		        new java.util.TimerTask() {
		 		            @Override
		 		            public void run() {
		 		            	if(MainView.pantallita==4&&barrera==false) {
		 		                
		 		            	barrera=true;
		 		            	}
		 		            }
		 		        }, 
		 		        5000 
		 		);
		 		 
		 		
		 		 if(barrera==true && MainView.pantallita==4 && verifnota1.isBlue()!=true && verifnota1.isOrange()!=true&&verifnota1.isGreen()!=true) {
			 		  MainView.pantallita=3;
			 		 efe.play();
			 		  scoreJugador1=0;
			 		  scoreJugador2=0;
			 		  return;
			 	  }
		 		 
		 		 
	 		}
//	 		if(generic.id.equals(jugador2.getId())) {
//	 			verifnota2=gson.fromJson(alo, VerifNota.class);
//	 			System.out.println(generic.id+" "+jugador2.getId());
//	 			
//	 			 if(MainView.pantallita==1 && verifnota2.isBlue()!=true && verifnota2.isOrange()!=true&&verifnota2.isGreen()!=true) {
//			 		  MainView.pantallita=2;
//			 		  System.out.println("marco");
//			 		  return;
//			 	  }
//		 		 if(MainView.pantallita==2 && verifnota2.isBlue()!=true && verifnota2.isOrange()!=true&&verifnota2.isGreen()!=true) {
//			 		  MainView.pantallita=3;
//			 		  System.out.println("polo");
//			 		  return;
//			 	  }
	 		
//			 } 
	 	  }
	}

	


	
}
