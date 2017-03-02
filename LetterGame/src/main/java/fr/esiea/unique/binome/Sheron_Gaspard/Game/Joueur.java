package src.main.java.fr.esiea.unique.binome.Sheron_Gaspard.Game;
import java.util.ArrayList;



public class Joueur {
	private String name;
	public ArrayList<String> motJoueur ; 
	
	
	public Joueur(String name){
		this.name=name;
		this.motJoueur=new ArrayList<String>();
	}
	
	public String toString(){
		return this.name;
	}
	
	public ArrayList<String> getMotJoueur(){
		return motJoueur;
		
	}

	public void addMotJoueur(String word){
		motJoueur.add(word);
	}
	
	public void deleteMotJoueur(String word){
		motJoueur.remove(word);
	}
	
	
}
