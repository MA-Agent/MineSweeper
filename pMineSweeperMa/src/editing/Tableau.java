package editing;

import java.util.ArrayList;
import java.util.List;

public class Tableau {
	private List<List<Integer>> matrice;
	private int ligne;
	private int colonne;
	private int nbBomb;
	
	public Tableau(int difficulty){
		matrice = new ArrayList<>();
		
		if(difficulty == 1){
			this.ligne= 9;
			this.colonne = 9;
			this.nbBomb = 10;
		}else if(difficulty == 2){
			this.ligne = 16;
			this.colonne = 16;
			this.nbBomb = 40;
			
		}else if(difficulty == 3 ){
			this.ligne = 16;
			this.colonne = 30;
			this.nbBomb = 99;
		}
		
		
	}

}
