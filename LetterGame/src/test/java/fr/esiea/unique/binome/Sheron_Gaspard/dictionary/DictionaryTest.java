package src.test.java.fr.esiea.unique.binome.Sheron_Gaspard.dictionary;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.main.java.fr.esiea.unique.binome.Sheron_Gaspard.dictionary.Dictionary;
import src.main.java.fr.esiea.unique.binome.Sheron_Gaspard.dictionary.IDictionary;

/**
 * Unit test sample for Dictionary.
 */
public class DictionaryTest {

    private IDictionary dictionary;

    @Before
    public void setup() {
        dictionary= new Dictionary();
    }

	
	@Test
	public void testIsWord() {
		assertTrue(dictionary.isWord("maman"));
        assertFalse(dictionary.isWord("namam"));
    }
}
