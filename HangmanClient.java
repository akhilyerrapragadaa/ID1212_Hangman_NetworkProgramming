package com.kth.id1212.hangman;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import javax.sound.sampled.AudioFormat.Encoding;


public class HangmanClient {
	//PrintWriter out;
	int i=0;
	public void startConnection(String hostName, int portNumber) {
		boolean flag = true;
		//int i=0;
		// TODO Auto-generated method stub
       //String hostName ="127.0.0.1";
       //int portNumber = 8080;
       Socket clientSocket;
       PrintWriter out;
       BufferedReader in;
      // InputStreamReader ir;
       
       try {
    	   boolean info = true;
    	   clientSocket = new Socket(hostName, portNumber);
    	   //Create ourIO streams
    	   out = new PrintWriter(clientSocket.getOutputStream(), true);
    	   in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    	   // netStream = clientSocket.getOutputStream();
    	  // ByteArrayOutputStream byteOutputStream =  new ByteArrayOutputStream();
    	   //ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream);
    	   while(flag) {
    	   if(info) {
    	   System.out.println("Please remember that you can exit the game any time by typing - Exit");	   
    	   info = false;
    	   }
    	   System.out.println("Enter Word/Words:");
		   Scanner myObj1 = new Scanner(System.in);
		   String datain = myObj1.nextLine();
		 //  System.out.println(datain.getBytes(StandardCharsets.UTF_8));
		   int a =datain.getBytes(StandardCharsets.UTF_8).length;
		 //  System.out.println(datain.getBytes().length);
		   out.println(datain+a);
    	   
    	   System.out.println(in.readLine());
    	   if(datain.equals("Exit")) {
    		   flag = false;
    		   out.println("Thanks for playing!");
    		   in.close();
    		   out.close();
    		   clientSocket.close();
    	   }
    	   }
       } catch(UnknownHostException e) {
    	   System.exit(1);
       } catch(IOException e) {
    	   System.exit(1);
       }
       
	}
   // int i=0;
	/*public int frameMsg(byte[] message) {
	  	  for(byte b:message) {
	  		  i++;
	  	  }
	  	  return i;
 }*/
	
}

