package src.test.java.fr.esiea.unique.binome.Sheron_Gaspard.dictionary;


import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;

import src.main.java.fr.esiea.unique.binome.Sheron_Gaspard.dictionary.IDictionary;

/**
 * Unit test sample for Dictionary.
 */
public class DictionaryTest {

    private IDictionary dictionary;

    @Before
    public void setup() {
        //TODO
    }

    @SuppressWarnings("deprecation")
	public void testIsWord() {
        assertTrue(dictionary.isWord("maman"));
        assertFalse(dictionary.isWord("namam"));
    }
}
