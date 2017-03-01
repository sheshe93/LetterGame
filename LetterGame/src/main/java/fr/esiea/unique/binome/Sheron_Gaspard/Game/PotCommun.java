package src.main.java.fr.esiea.unique.binome.Sheron_Gaspard.Game;

import java.util.ArrayList;


public class PotCommun {

	private ArrayList<Character> listPotCommun ;
	
	public static void main(String[] args){
	
	}
	
	public void addCharacter(char c){
		if((int)c==0){
			System.err.println("pas de character");
		}else{
			listPotCommun.add(c);
		}
	}
	
	public void deleteCharacter(String word){
		
		for( char c : word.toCharArray()){
			for(int i=0;i<listPotCommun.size();i++){
				if(listPotCommun.get(i)==c){
					listPotCommun.remove(i);
				}
			}
		}
	}
	
	public ArrayList<Character> getlistPotCommun(){
		return listPotCommun;
	}
	
	public boolean ResetPotCommun(){
		if(listPotCommun.isEmpty()){
		return true;
		}else{
			listPotCommun.clear();
			return true;
		}

	}
	
	
	public boolean 	characterInPotCommun(String word){
	boolean test=true;
		
	for(char c: word.toCharArray()){
		if(listPotCommun.contains(c)){
			return true;
		}else{
			test=false;
		}
	}
	return test;
		
	}
	
	
	
}