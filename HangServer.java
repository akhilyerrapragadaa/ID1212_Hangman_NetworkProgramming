package com.kth.id1212.hangman;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HangServer {
	int portNumber = 8080 ;
	ServerSocket serverSocket = null;
	
	public void runServer() {
		try {
			serverSocket = new ServerSocket(portNumber);
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		while(true) {
			try {
				Socket clientSocket = serverSocket.accept();
				HangRunnable m = new HangRunnable(clientSocket);
				new Thread(m).start();
			} catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

   public static void main(String[] args) {
	   System.out.println("Server up and listening!");
	   HangServer s = new HangServer();
	   s.runServer();
   }


}
