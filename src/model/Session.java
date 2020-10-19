package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.UUID;

import com.google.gson.Gson;

public class Session extends Thread{
	Socket socket; 
	BufferedWriter writer;
	private ObserverMessage app; 
	private String id; 
	

	
	public Session(Socket socket) {
		this.socket = socket; 
		this.id = UUID.randomUUID().toString(); 
		
	}
	
	@Override
	public void run() {
		 
		
		try {
			socket = new Socket("10.0.2.2", 5000);
		  InputStream is = socket.getInputStream(); 
		  InputStreamReader isr = new InputStreamReader(is); 
		  BufferedReader reader = new BufferedReader(isr);
		  
		  //writer
		  OutputStream os = socket.getOutputStream(); 
		  OutputStreamWriter osw = new OutputStreamWriter(os); 
		  writer = new BufferedWriter(osw); 
		  
				
		  
		  while(true) {
			  String line = reader.readLine(); 
			  app.readmsg(this,line);
			 	
			 
		  }
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
	}
	
	public void sendMessage(String ms) {
		new Thread(
				()->{
					try {
						writer.write(ms+"\n");
						writer.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				).start();
	}

	public void setObserver(ObserverMessage observer) {
		this.app = observer; 
		// TODO Auto-generated method stub
		
	}

	public String getID() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	

}
