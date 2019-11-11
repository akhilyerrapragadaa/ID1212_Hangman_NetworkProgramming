package com.kth.id1212.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


	public class HangRunnable implements Runnable {
		public int count = 0 ;
		HangmanService hangmanService =  new HangmanService();   
		protected Socket clientSocket = null;
		boolean flag = true;
		boolean datlost;
		public HangRunnable(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub

			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
			    String arg;
			    
			    while((arg = in.readLine())!= "Exit") {
			    	datlost = false;
			    	String str = arg;
			    	String[] part = str.split("(?<=\\D)(?=\\d)");
				    String arg1= part[0];
				  //  System.out.println(arg);
				    int bytes = Integer.parseInt(part[1]);
				    int byto =arg1.getBytes(StandardCharsets.UTF_8).length;
				   // System.out.println(bytes);
				    //System.out.println(byto);
				    //System.out.println(arg1);
			    	if(arg1.equals("Exit")) {
				    	
				    	in.close();
				    	out.close();
				    }
				    else {
				    	System.out.println("Client Says:"+ arg1);
					    if(bytes != byto ){
					    	String tag = "Some data has been lost in the network please resend the word";
					        out.println(tag);
					        datlost = true;
					    }
				    	//out.println("Thanks for the message");
					    else if(count == 0) {
				    		hangmanService.newGame();
				    		count = 1;
				    	}
				    	
					    if(!datlost) {
				    	String outP = hangmanService.play(arg1);
				    	out.println(outP);
				    	if(outP.contains("score"))
				    		count =0;
					    }
					    }
					    
				    
			    
			    }
			    
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Client left!");
				//e.printStackTrace();
			}
		}

	}


