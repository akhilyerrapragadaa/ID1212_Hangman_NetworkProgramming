package com.kth.id1212.hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class HangmanEntity {
	public static ArrayList dataGenerator() throws IOException 
	   {
	      File f1=new File("./resource/words.txt"); //Creation of File Descriptor for input file
	      String[] words=null;  //Intialize the word Array
	      FileReader fr = new FileReader(f1);  //Creation of File Reader object
	      BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
	     
	      //StringBuffer sb=new StringBuffer();
	      ArrayList<String>  sb = new ArrayList<String>();
	      
	      String s;     
	      //String input="Java";   // Input word to be searched
	      int count=0;   //Intialize the word to zero
	    
	      while((s=br.readLine())!=null)   //Reading Content from the file
	      {
	    	  
	    	  sb.add(s);      //appends line to string buffer  
	    	  //sb.add(",");
	    	  //sb.append("\n");
	    	 // System.out.println(sb);
	      }
	     return sb;

	   
	   }
	
	public ArrayList met() throws IOException{
		ArrayList result = HangmanEntity.dataGenerator();
		return result;
	}
	
	
}
