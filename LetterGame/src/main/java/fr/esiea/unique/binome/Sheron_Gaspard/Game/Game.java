package src.main.java.fr.esiea.unique.binome.Sheron_Gaspard.Game;

import java.util.Random;
import java.util.Scanner;

import src.main.java.fr.esiea.unique.binome.Sheron_Gaspard.dictionary.Dictionary;

public class Game {

	private static Joueur J1;
	private static Joueur J2;
	char randomLetter;
	static Scanner scan;
	private Dictionary d = new Dictionary();
	static PotCommun PC = new PotCommun();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menuGame();

	}

	public static void menuGame() {
		String saisie = " ";

		while (!saisie.equals("q")) {

			System.out.println("Bienvenue, Que voulez vous faire ? (a pour aide / q pour quiter)\n");
			Scanner scan = new Scanner(System.in);
			saisie = scan.next();

			switch (saisie) {

			case "a": // aide
				System.out.println("a: Aide");
				System.out.println("l: Lancer une partie");
				;
				System.out.println("q: Quitter");

				break;

			case "l": // lancer partie
				
				
				startGame();

				break;

			case "q": // quitter le jeu
				break;
			}
		}
	}

	public static Joueur premierTour() {

		char c1 = randomChar();
		char c2 = randomChar();

		while (c1 == c2) {
			c1 = randomChar();
			c2 = randomChar();
		}
		PC.addCharacter(c1);
		PC.addCharacter(c2);
		System.out.println(J1.toString() + " a tiré la lettre " + c1);
		System.out.println(J2.toString() + " a tiré la lettre " + c2);
		if (c1 > c2)
			return J2;
		else
			return J1;
	}

	public static void startGame() {

		Joueur JG, JP;

		System.out.println("Veuillez saisir le nom du Joueur 1 :");
		scan = new Scanner(System.in);
		J1 = new Joueur(scan.next());
		System.out.println("Veuillez saisir le nom du Joueur 2 :");
		scan = new Scanner(System.in);
		J2 = new Joueur(scan.next());

		JG = premierTour();
		if (JG.equals(J1)) {
			JP = J2;
		} else {
			JP = J1;
		}
		System.out.println(JG.toString() + " commence.");

		CycleJeu(JG, JP);
	}

	public static void CycleJeu(Joueur FirstPlayer, Joueur SecondPlayer) {
		Joueur nextPlayer = FirstPlayer;
		Joueur otherPlayer = SecondPlayer;
		boolean someoneWon = false;
		while (!someoneWon) {
			char c1 = randomChar();
			char c2 = randomChar();
			PC.addCharacter(c1);
			PC.addCharacter(c2);

			System.out.println(nextPlayer.toString() + " a pioché les lettres " + c1 + " et " + c2);
			System.out.println("Contenu du Pot Commun : " + PC.getlistPotCommun().toString());

			System.out.println(nextPlayer.toString() + " avez-vous un mot ?");
			System.out.println("1.Faire un mot depuis les lettres du pot commun.\r" + "2.Rallonger un mot créé par "
					+ otherPlayer.toString() + ".\r" + "3.Rallonger un de mes précédent mots.\r" + "4.Passer le tour");

			OnChoixJoueur(nextPlayer, otherPlayer);
			System.out.println(J1.toString() + " a " + J1.motJoueur.size() + " points.");
			System.out.println("Les mots de "+J1.toString() + " sont : " + J1.getMotJoueur().toString()+"\n");
			System.out.println(J2.toString() + " a " + J2.motJoueur.size() + " points.");
			System.out.println("Les mots de "+J2.toString() + " sont : " + J2.getMotJoueur().toString()+"\n");
			
			Joueur tempPlayer = nextPlayer;
			nextPlayer = otherPlayer;
			otherPlayer = tempPlayer;
			
			if(J1.motJoueur.size() >= 10 || J2.motJoueur.size() >= 10)
				someoneWon = true;
		}
		System.out.println("Féliciations " + otherPlayer.toString() + ", vous avez gagné !!");
		return;
	}

	public static void OnChoixJoueur(Joueur player, Joueur otherPlayer) {
		Dictionary d = new Dictionary();
		scan = new Scanner(System.in);
		String input = scan.next();
		switch (input) {
		case "1":
			System.out.println("Veuillez saisir un mot à partir des lettres contenues dans le pot commun.");
			scan = new Scanner(System.in);
			String scannedWord = scan.next();
			if (PC.characterInPotCommun(scannedWord)) {
				if (d.isWord(scannedWord)) {
					player.addMotJoueur(scannedWord);
					PC.deleteCharacter(scannedWord);
					System.out.println("Bravo !");
					PC.addCharacter(randomChar());
				} else {
					System.out.println("Le mot " + scannedWord + " n'est pas dans le dictionnaire");
				}
			} else {
				System.out.println("Les lettres saisies ne sont pas contenues dans le pot commun.");
			}
			break;
		case "2":
			System.out.println("Veuillez saisir le mot de l'adversaire");
			scan = new Scanner(System.in);
			String ancientWord = scan.next();
			if (otherPlayer.isMotAlreadyTyped(ancientWord)) {
				System.out.println("Quelle(s) lettre(s) y ajoutez-vous ?");
				scan = new Scanner(System.in);
				String addedCharacters = scan.next();
				if (PC.characterInPotCommun(addedCharacters) && d.isWord(ancientWord + addedCharacters)) {
					player.addMotJoueur(ancientWord + addedCharacters);
					otherPlayer.deleteMotJoueur(ancientWord);
					PC.deleteCharacter(addedCharacters);
					System.out.println("Bravo !");
					PC.addCharacter(randomChar());
				} else {
					System.out.println("Le mot n'est pas dans le dictionnaire ou les lettres que vous avez tenté "
							+ "d'ajouter n'étaient pas dans le pot commun.");
				}
			} else {
				System.out.println("Le mot n'a pas été entré précédemment");
			}
			break;
		case "3":
			System.out.println("Veuillez saisir l'ancien mot");
			scan = new Scanner(System.in);
			ancientWord = scan.next();
			if (player.isMotAlreadyTyped(ancientWord)) {
				System.out.println("Quelle(s) lettre(s) y ajoutez-vous ?");
				scan = new Scanner(System.in);
				String addedCharacters = scan.next();
				if (PC.characterInPotCommun(addedCharacters) && d.isWord(ancientWord + addedCharacters)) {
					player.addMotJoueur(ancientWord+addedCharacters);
					PC.deleteCharacter(addedCharacters);
					PC.addCharacter(randomChar());
					System.out.println("Bravo !");
				} else {
					System.out.println("Le mot n'est pas dans le dictionnaire ou les lettres que vous avez tenté "
							+ "d'ajouter n'étaient pas dans le pot commun.");
				}
			} else {
				System.out.println("Le mot n'a pas été entré précédemment");
			}
			break;
			
		case "4":
			break;
		/*	case "SheatCode":
			player.addMotJoueur("ok");
			player.addMotJoueur("okazd");
			player.addMotJoueur("okdazaf");
			player.addMotJoueur("okdazd");
			player.addMotJoueur("offflk");
			player.addMotJoueur("okggbg");
			player.addMotJoueur("okgpg");
			player.addMotJoueur("okggg");
			player.addMotJoueur("ogggok");
			break;
		*/	
		default:
			break;
		}
	}

	// renvoie un caractère au hasard.
	public static char randomChar() {
		Random r = new Random();
		char c = (char) (r.nextInt(26) + 'a');
		return c;
	}

}