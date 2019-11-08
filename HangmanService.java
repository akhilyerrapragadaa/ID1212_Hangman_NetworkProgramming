package com.kth.id1212.hangman;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class HangmanService {
	public static final Random RANDOM = new Random();
	public static final int MAX_ERRORS = 7;
	private String wordToFind;
	private char[] wordFound;
	private int nbErrors;
	public int nbCorrect=0;
	private  ArrayList<String> letters = new ArrayList<String>();
	private  ArrayList<String> duplicate = new ArrayList<String>();
	
	
	private HangmanEntity hangmanEntity = new HangmanEntity();
	
	private String nextWordToFind() throws IOException, ArrayIndexOutOfBoundsException {
		ArrayList ob = hangmanEntity.met();
		//String[] strArr = new String[] {ob.toString()};
		 int num =RANDOM.nextInt(ob.size());
		//System.out.println(ob.get(num).toString());
		//System.out.println("Value is"+strArr[RANDOM.nextInt(ob.length())]);
		 
		 
		return ob.get(num).toString(); 
	}
	
	public void newGame() throws IOException, ArrayIndexOutOfBoundsException  {
	nbErrors = 0;
	letters.clear();
	duplicate.clear();
	wordToFind = this.nextWordToFind();
	System.out.println(wordToFind);
	wordFound = new char[wordToFind.length()];
	for(int i =0; i< wordFound.length;i++) { 
	wordFound[i] = '_';
	//System.out.println(wordToFind);
	}
}
	
	public boolean wordFound() {
      return wordToFind.contentEquals(new String(wordFound));	
	}
	
	private void enter(String c) {
		boolean flag = false;
		 
		if(!letters.contains(c)){
			 flag = true;
			System.out.println(c);
			//if(!wordToFind.contentEquals(c)) {
				//System.out.println(c);
				//String m = wordFoundContent();
			//}
			//String f =c;
			if(wordToFind.contains(c)) {
				
				//System.out.println(c.length());
				if(c.length()!=1) {
					String[] v = new String[wordToFind.length()];
			        v = c.split("");
			        for(int i = 0 ;i<v.length;i++) {
			    	if(!duplicate.contains(v[i])) {
			    	   duplicate.add(v[i]);
			        int index = wordToFind.indexOf(v[i]);
					while(index>=0) {
						wordFound[index] = v[i].charAt(0);
						index = wordToFind.indexOf(v[i], index+1);
						//System.out.println(index);
						//System.out.println("1"+wordFound);
						}
			    	}
			    	}
			    
				}
				else {
				int index = wordToFind.indexOf(c);
				
				while(index>=0) {
					wordFound[index] = c.charAt(0);
					index = wordToFind.indexOf(c, index+1);
					//System.out.println(index);
				//	System.out.println("2"+wordFound);	
				}
				}
			}
			else {
				nbErrors++;
			}
			//System.out.println(letters);
			letters.add(c);
			//System.out.println(letters);
		}
		if(!flag)
			nbErrors++;
	}
	
	private String wordFoundContent(){
		StringBuilder build = new StringBuilder();
		
		for(int i=0;i<wordFound.length;i++) {
			build.append(wordFound[i]);
		  
		    if(i < wordFound.length-1) {
		    	build.append(" ");
		    }
		}
	      return build.toString();
	}
	
	
	public String play(String str) {
		String info ="";
		//while(nbErrors < MAX_ERRORS) {
			//if(str.length()>1) {
			//	str = str.substring(0,1);
			//}
			enter(str);
			
			System.out.println(wordFoundContent());
			//System.out.println(wordFound());
		if(wordFound()) {
			nbCorrect = nbCorrect+1;
			//int correct = nbCorrect+1;
			info = "You Win!"+" "+"Your score is - "+ nbCorrect;
			
			// break;
		}  else {
			info = "No. tries remaining - " +(MAX_ERRORS - nbErrors) + " "+"Words recognized so far "+wordFoundContent();
			//System.out.println("No tries remaining"+(MAX_ERRORS - nbErrors));
		    
		}
		if(nbErrors == MAX_ERRORS) { 
			info = "You Loose!"+" "+"Word to find was :" +wordToFind;
		}
	//}
	   return info;		
}
	/*public static void main(String args[]) throws ArrayIndexOutOfBoundsException, IOException {
		HangmanService HangmanService = new HangmanService();
		HangmanService.newGame();
		 
		
		String a = HangmanService.play("e");
		System.out.println(a);
		 
		 
		 }*/
}
