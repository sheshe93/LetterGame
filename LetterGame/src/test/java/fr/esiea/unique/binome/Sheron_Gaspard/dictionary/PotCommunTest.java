package src.test.java.fr.esiea.unique.binome.Sheron_Gaspard.dictionary;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import src.main.java.fr.esiea.unique.binome.Sheron_Gaspard.Game.PotCommun;

public class PotCommunTest {
	private ArrayList<Character> List;
	private PotCommun pot = new PotCommun();

	
	@Test
	
	public void testVide(){
		assertTrue(pot.getlistPotCommun().isEmpty());
	}
	
	@Test
	public void testAddLetter(){
		pot.addCharacter('a');
		char first =pot.getlistPotCommun().get(0);
		assertEquals('a', first);
	}
	@Test
	public void testRemoveLetter(){
		pot.addCharacter('a');
		pot.deleteCharacter("a");
		assertTrue(pot.getlistPotCommun().isEmpty());
	}
	
	
	
	
	
}
