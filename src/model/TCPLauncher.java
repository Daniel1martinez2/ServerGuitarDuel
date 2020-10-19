package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.google.gson.Gson;

public class TCPLauncher extends Thread{
	
	private static TCPLauncher uniq; 
	
	
	private TCPLauncher() {
		
	}
	public void suscripcion(ObserverMessage obs) {
		this.obs = obs; 
	}
	
	public static TCPLauncher getInstance() {
		if(uniq == null) {
			uniq = new TCPLauncher(); 
			uniq.start();
		}
		return uniq; 
	}
	//globales 
	BufferedReader reader;
	private ObserverMessage obs; 
	private ServerSocket server;
	
	private ArrayList <Session> sessions; 
	// 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			 server = new ServerSocket(5000);
			
	            
			 sessions = new ArrayList<Session>(); 
			 if(sessions.size()>=1) {
					sessions.get(0).sendMessage("alo");
					}
					
			//esperando
			 while(true) {
				System.out.println("server esperando");  
				Socket socket = server.accept();
				Session  session = new Session(socket); 
				session.setObserver(obs); 
				session.start();
				sessions.add(session); 
				System.out.println("cliente conectado"+sessions.size());
				
				
				
				
				//reader
			 }
			 
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ArrayList<Session> getSessions() {
		return sessions;
	}
	public void setSessions(ArrayList<Session> sessions) {
		this.sessions = sessions;
	}


	

}
