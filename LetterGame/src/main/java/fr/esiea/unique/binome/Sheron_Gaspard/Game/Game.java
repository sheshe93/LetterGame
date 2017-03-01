package src.main.java.fr.esiea.unique.binome.Sheron_Gaspard.Game;

import java.util.Scanner;

public class Game {
	
	private Joueur J1,J2;
	private PotCommun PC;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public Game(){
		
		
	}
	
	public void menuGame(){
		String saisie = null;
		
		while(!saisie.equals("q")){

			System.out.println("Bienvenue, Que voulez vous faire ? (a pour aide)\n");
			Scanner scan=new Scanner(System.in);
			saisie=scan.next();

			switch(saisie){
			
			case "a":		// aide										

				System.out.println("a: Aide");
				System.out.println("l: Lancer une partie");;
				System.out.println("q: Quitter");

				break;

			case "l":		//	lancer partie									
				
				
				break;
				
			case "q":  // quitter le jeu
				break;
			}
		}
	}

}
