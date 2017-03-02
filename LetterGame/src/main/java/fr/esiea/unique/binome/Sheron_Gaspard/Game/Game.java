package src.main.java.fr.esiea.unique.binome.Sheron_Gaspard.Game;

import java.util.Random;
import java.util.Scanner;

import src.main.java.fr.esiea.unique.binome.Sheron_Gaspard.dictionary.Dictionary;

public class Game {
	
	private static Joueur J1;
	private static Joueur J2;
	char randomLetter;
	static Scanner scan;
	private Dictionary d =new Dictionary();
	static PotCommun PC = new PotCommun() ;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menuGame();
		
	}
	
	
 
	
	public  static void menuGame(){
		String saisie =" ";
		
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
				startGame();
			
				break;
				
			case "q":  // quitter le jeu
				break;
			}
		}
	}
	
	public static Joueur premierTour(){
		
		char c1= randomChar();
		char c2=randomChar();
		
		while (c1==c2){
			c1= randomChar();
			c2=randomChar();
			
		} if(c1>c2){
			PC.addCharacter(c1);
			PC.addCharacter(c2);
			return J2;
		}else{
			PC.addCharacter(c1);
			PC.addCharacter(c2);
			return J1;
		}
			
	}
	
	
	
	
	public static void startGame(){
		
		 Joueur JG,JP;
		
		System.out.println("Veuillez saisir le nom du Joueur1 :");
		scan= new Scanner(System.in);
		J1= new Joueur(scan.next());
		System.out.println("Veuillez saisir le nom du Joueur2 :");
		scan= new Scanner(System.in);
		J2= new Joueur(scan.next());
		
		JG=premierTour();
		if(JG.equals(J1)){
			JP=J2;
		}else{
			JP=J1;
		}
		System.out.println("Premier tour gagné par : "+JG.toString());
		
		CycleJeu(JG,JP);
		
		
	}
	
	public static void CycleJeu(Joueur FirstPlayer,Joueur SecondPlayer){
		
		while(J1.motJoueur.size()<10 ||J2.motJoueur.size()<10){
			System.out.println("Nombre de mot Joueur 1: "+J1.motJoueur.size());
			System.out.println("Les mots sont :"+J1.motJoueur.toString());
			System.out.println("Nombre de mot Joueur 2: "+J2.motJoueur.size());
			System.out.println("Les mots sont :"+J2.motJoueur.toString());
		
			PC.addCharacter(randomChar());
			PC.addCharacter(randomChar());
			System.out.println("Lettre du Pot Commun : "+PC.getlistPotCommun().toString());
			
			System.out.println(FirstPlayer.toString()+" avez vous un mot ?");
			System.out.println("1.mot du pot commun/ 2. mot de l'autre joueur allongé /3.Un de mes mots allongé");
			scan= new Scanner(System.in);
			String choix=scan.next();
			
			switch (choix){
			
			case "1": 
				System.out.println("Veuillez saisir le mot du pot commun");
				scan= new Scanner(System.in);
				String mot=scan.next();
				if(PC.characterInPotCommun(mot)){
					FirstPlayer.addMotJoueur(mot);
					PC.deleteCharacter(mot);
					System.out.println("bravo");
				}else{
					System.out.println("mot n'existe pas");
				}
				
			break;
			
			case "2": 
				System.out.println("Veuillez saisir le mot de l'adversaire");
				scan= new Scanner(System.in);
				String mot2=scan.next();
				if(PC.characterInPotCommun(mot2)){
					FirstPlayer.addMotJoueur(mot2);
					PC.deleteCharacter(mot2);
					System.out.println("bravo");
				}else{
					System.out.println("mot n'existe pas");
				}
				
			break;
			
			}
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	public static char randomChar(){
		Random r = new Random();
		char c = (char)(r.nextInt(26) + 'a');
		return c;
	}

}
