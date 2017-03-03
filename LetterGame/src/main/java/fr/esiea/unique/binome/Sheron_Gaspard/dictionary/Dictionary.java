package src.main.java.fr.esiea.unique.binome.Sheron_Gaspard.dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dictionary implements IDictionary{
	private String path;

	public Dictionary() {
		this.path = System.getProperty("user.dir") + "/LetterGame/src/main/resources/dico.txt";
	}

	public Dictionary(String path) {
		this.path = path;
	}

	/**
	 * Permet de savoir si ce mot est dans le dictionnaire
	 * 
	 * @param mot
	 * @return
	 */
	public boolean isWord(String mot) {
		try {
			File f = new File(path);
			BufferedReader bfReader = new BufferedReader(new FileReader(f));
			String line;
			while ((line = bfReader.readLine()) != null) {
				if (line.contains(mot) && line.equals(mot)) {
					bfReader.close();
					return true;
				}
			}
			bfReader.close();
		} catch (IOException e) {
			System.out.println("Erreur en cherchant le mot dans le dico");
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<String> getMotsDico() {
		File f = new File(path);
		BufferedReader bfReader;
		ArrayList<String> motsDico = new ArrayList<String>();
		try {
			bfReader = new BufferedReader(new FileReader(f));
			String line;
			while ((line = bfReader.readLine()) != null) {
				motsDico.add(line);
			}
			bfReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return motsDico;
	}
}
