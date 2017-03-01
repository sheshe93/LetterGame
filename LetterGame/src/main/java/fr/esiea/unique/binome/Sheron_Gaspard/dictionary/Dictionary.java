package src.main.java.fr.esiea.unique.binome.Sheron_Gaspard.dictionary;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;
import java.util.ArrayList;



public class Dictionary implements IDictionary {
	
	private ArrayList<String> listDictionary;
	
	public Dictionary(){
		listDictionary = new ArrayList<String>();
		
		
			File file= new File("/Users/mac/git/TP_4A_2017_Letter_Game/LetterGame/src/main/resources/dico.txt");

			 try {
		        	BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));	
		        	String line = null;
					while ((line = r.readLine()) != null)
		            {
						if(line.length()>1){
							listDictionary.add(line);
						}
						         
		            }
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
	/*
	public static void main(String[] args){
		
	    Dictionary d = new Dictionary();
		if(d.isWord("maman")){
			System.out.println("maman existe");
		}
		
		if(!d.isWord("mamana")){
			System.out.println("pas comme mamana");
		}
		

	}
	*/

//test mot

	public boolean isWord(String word) {
		// TODO Auto-generated method stub
		
		if(listDictionary.contains(word)){
			return true;
		}else{
			
		return false;
		}
	}
}