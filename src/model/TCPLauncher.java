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
	public void suscripcion(ObserverMessage app) {
		this.app = app; 
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
	private ObserverMessage app; 
	private ServerSocket server;
	private ArrayList <Session> sessions; 
	// 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			 server = new ServerSocket(6000);
			 sessions = new ArrayList<Session>(); 
			//esperando
			 while(true) {
				System.out.println("server esperando");  
				Socket socket = server.accept();
				Session  session = new Session(socket); 
				session.setObserver(app); 
				session.start();
				sessions.add(session); 
				System.out.println("cliente conectado");
				  //reader
			 }
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
