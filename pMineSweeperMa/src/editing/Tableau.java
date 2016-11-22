package editing;

import java.util.ArrayList;
import java.util.List;

public class Tableau {
	private List<List<Integer>> matrice;
	private int ligne;
	private int colonne;
	
	public Tableau(int difficulty){
		matrice = new ArrayList<>();
		
		if(difficulty == 1){
			this.ligne= 9;
			this.colonne = 9;
		}else if(difficulty == 2){
			this.ligne = 16;
			this.colonne = 16;
			
		}else if(difficulty == 3 ){
			this.ligne = 16;
			this.colonne = 30;
		}
		
		
	}

}
