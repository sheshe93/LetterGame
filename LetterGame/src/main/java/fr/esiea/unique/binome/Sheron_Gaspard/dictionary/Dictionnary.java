
import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import fr.esiea.unique.binome.name.dictionary.IDictionary;



public class Dictionnary implements IDictionary {
	
	//ouverture fichier 

	public BufferedReader OuvrirFichier(String motTester) {

		String fichier = "src/main/ressources/dico.txt";

		
		BufferedReader reader = null;

		try {

			InputStream ips = new FileInputStream(fichier);

			InputStreamReader ipsr = new InputStreamReader(ips);

			reader = new BufferedReader(ipsr);
			
		}
 
		catch (Exception e) {

			System.out.println(e.toString());

		}

		return reader;

	}
//+++++

//test mot
	
	public String isWord(String motTest, BufferedReader reader) throws IOException {

		String Line;

		do {

			Line = reader.readLine();

			if (Line.equals(motTest) || Line.equals(null)) {
				
				reader.close();

				return Line;
 
			}
		} while (reader.ready());

		System.out.println("Mot non reconnu");

		return "";

	}
//++++

	public boolean isWord(String word) {
		// TODO Auto-generated method stub
		return false;
	}
}