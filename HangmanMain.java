package com.kth.id1212.hangman;

//import org.springframework.beans.factory.annotation.Autowired;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

public class HangmanMain {
    
	 
	public static void main(String[] args) {
		// String datain ="";
		//public void givenClient1_whenServerResponds_thenCorrect() {		    
			HangmanClient client1 = new HangmanClient();
			System.out.println("Connect with IP and Port to play hangman:");
			Scanner myObj = new Scanner(System.in);
			String ip = myObj.nextLine();
			while (!myObj.hasNextInt()) myObj.next();
			int port = myObj.nextInt();
			client1.startConnection(ip, port);
	}

}
