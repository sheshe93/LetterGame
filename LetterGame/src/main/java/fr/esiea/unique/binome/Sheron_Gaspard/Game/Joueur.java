package src.main.java.fr.esiea.unique.binome.Sheron_Gaspard.Game;
import java.util.ArrayList;



public class Joueur {
	private String name;
	public ArrayList<Character> listCharJoueur;
	public ArrayList<String> motJoueur ; 
	
	
	public Joueur(String name){
		this.name=name;
		this.listCharJoueur=new ArrayList<Character>();
		this.motJoueur=new ArrayList<String>();
	}
	
	public String toString(){
		return "nom: "+this.name+"; nombre de mots trouver: "+motJoueur.size()+"; lettre disponible : " +listCharJoueur.toString();
	}
	
	public ArrayList<String> getMotJoueur(){
		return motJoueur;
		
	}
	 
	
	
	public void addMotJoueur(String word){
		motJoueur.add(word);
	}
	
	
}
