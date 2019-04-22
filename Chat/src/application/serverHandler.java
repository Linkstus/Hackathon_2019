package application;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class serverHandler extends Thread{
	private Server server = new Server();
	
	@Override
	public void run() {
		int port = 60000;
	    
	    try  {
	    	ServerSocket serverSocket = new ServerSocket(port);
	      System.out.println("Server is running.");
	      server.serverIsOn();
	      while (true) {
	        Socket socket = serverSocket.accept();
	        ClientHandler user = new ClientHandler(socket, server);
	        server.addToThreadsList(user);
	        user.start();
	      }

	    } catch (IOException ex) {
	      System.out.println("Error in the server.");
	    }
	}
}
