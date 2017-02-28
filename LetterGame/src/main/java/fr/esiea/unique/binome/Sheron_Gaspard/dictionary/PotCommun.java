import java.util.ArrayList;

public class PotCommun {

	private ArrayList listchar = new ArrayList();
	
	//lettre présente sysout
	public void Listlettre(){
	
		System.out.println("Les lettres présente sont :");
		for (char l: this.Listlettre()) {
			System.out.println( l+";");
		}
	}
	
	public void ajouterlettre(char c){
		
		listchar.add(c);
		
	}
	
	
}