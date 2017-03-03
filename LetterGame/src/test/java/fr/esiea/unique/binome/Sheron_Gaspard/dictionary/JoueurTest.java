package src.test.java.fr.esiea.unique.binome.Sheron_Gaspard.dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

import src.main.java.fr.esiea.unique.binome.Sheron_Gaspard.Game.Joueur;

public class JoueurTest {
	Joueur Joueur = new Joueur("testJ");
	@Test
	public void test() {
		
		
	}
	
	@Test
	public void testToString() {
		String s =Joueur.toString();
		assertTrue(s.equals("testJ"));
	}
	
	@Test
	public void testaddMotJoueur() {
		Joueur.addMotJoueur("ok");
		assertTrue(Joueur.motJoueur.contains("ok"));
	}
	
	@Test
	public void testdeleteMotJoueur() {
		Joueur.addMotJoueur("ok");
		Joueur.deleteMotJoueur("ok");
		
		assertTrue(Joueur.motJoueur.isEmpty());
	}

	public void isMotAlreadyTyped() {
		Joueur.addMotJoueur("ok");
		assertTrue(Joueur.isMotAlreadyTyped("ok"));
	}
	
	 
	
	

}
