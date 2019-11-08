package com.kth.id1212.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


	public class HangRunnable implements Runnable {
		public int count = 0 ;
		HangmanService hangmanService =  new HangmanService();   
		protected Socket clientSocket = null;
		boolean flag = true;
		public HangRunnable(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub

			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
			    String arg1;
			    
			    while((arg1 = in.readLine())!= "Exit") {
			    	
				    if(arg1.equals("Exit")) {
				    	
				    	in.close();
				    	out.close();
				    }
				    else {
				    	System.out.println("Client Says:"+ arg1);
					    //out.println("Thanks for the message");
				    	if(count == 0) {
				    		hangmanService.newGame();
				    		count = 1;
				    	}
				    		
				    	String outP = hangmanService.play(arg1);
				    	out.println(outP);
				    	if(outP.contains("score"))
				    		count =0;
				    }
				    
			    
			    }
			    
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Client left!");
				//e.printStackTrace();
			}
		}

	}


