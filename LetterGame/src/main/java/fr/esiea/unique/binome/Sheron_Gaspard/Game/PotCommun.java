package src.main.java.fr.esiea.unique.binome.Sheron_Gaspard.Game;

import java.util.ArrayList;
import java.util.Random;


public class PotCommun {

	private ArrayList<Character> listPotCommun ;
	
	public static void main(String[] args){
		
		
	
	}
	public PotCommun(){
		this.listPotCommun=new ArrayList<Character>();
	}
	public void addCharacter(char c){
		if((int)c==0){
			System.err.println("pas de character");
		}else{
			this.listPotCommun.add(c);
		}
	}
	
	public void deleteCharacter(String word){
		
		for( char c : word.toCharArray()){
			for(int i=0;i<this.listPotCommun.size();i++){
				if(listPotCommun.get(i)==c){
					this.listPotCommun.remove(i);
				}
			}
		}
	}
	
	public ArrayList<Character> getlistPotCommun(){
		return this.listPotCommun;
	}
	
	public boolean ResetPotCommun(){
		if(this.listPotCommun.isEmpty()){
		return true;
		}else{
			this.listPotCommun.clear();
			return true;
		}

	}
	
	
	public boolean 	characterInPotCommun(String word){
	boolean test=true;
		
	for(char c: word.toCharArray()){
		if(this.listPotCommun.contains(c)){
			return true;
		}else{
			test=false;
		}
	}
	return test;
		
	}
	

	
	
}