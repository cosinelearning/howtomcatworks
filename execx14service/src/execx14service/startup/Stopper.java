package execx14service.startup;

import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;

public class Stopper {

	public static void main(String[] args){
		int port = 8005;
		
		try{
			Socket socket = new Socket("127.0.0.1", port);
			OutputStream output = socket.getOutputStream();
			String shutdown = "SHUTDOWN";
			for (int i = 0; i < shutdown.length(); i++){
				output.write(shutdown.charAt(i));
			}
			output.flush();
			output.close();
			socket.close();
			
			System.out.println("the server was successfully killed");
		}
		catch(IOException e){
			System.out.println("error the server has not been started");
		}
	}
	
}
