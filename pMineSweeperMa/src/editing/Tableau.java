package editing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tableau{
	// changement tab en double
	

	private int ligne;
	private int colonne;
	private int nbBomb;
	
	Random rand = new Random();
	int [][] jeu;
	
	public Tableau(int difficulty){
		
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
	
	
	public void Build()
	{
		jeu = new int [ligne][colonne];
		
		// Initialisation du tableau à 0 (no bombe)
		for(int i = 0; i < ligne; i++)
		{
			for(int y = 0; y < colonne; y++)
			{
				jeu[i][y] = 0;
			}
		}
		
		// Remplissage de cases random avec des bombes (-1)
		for(int i = 0; i < nbBomb; i++)
		{
			int randC = rand.nextInt(colonne);
			int randL = rand.nextInt(ligne);
			
			if(jeu[randL][randC] == 0)
			{
				jeu[randL][randC] = -1;
			}
			else
			{
				i--;
			}
	}
		
	}
	
	// Affiche la grille de jeu
	public String toString()
	{
		String s ="";
		for(int i = 0; i < ligne; i++)
		{
			s+="|";
			for(int y = 0; y < colonne; y++)
			{
				
				s+= String.format("%7d", jeu[i][y]);
				s+="|";
				if(y == colonne-1){
					s+= "\n";
				}
			}
		}
		return s;
	}
	
	public void nbBombesAdjacants(){
		for(int i = 0 ; i < ligne ; i++){
			for( int j = 0; j < colonne ; j++){
				
				if(i>0 && i < ligne-1 && j >0 && j< colonne-1){
//					
					if(jeu[i][j] == -1){
						jeu[i-1][j]++; 
						jeu[i+1][j]++;
						jeu[i][j-1]++  ;
						jeu[i][j+1]++ ;
						jeu[i-1][j-1] ++;
						jeu[i-1][j+1] ++ ;
						jeu[i+1][j-1] ++;
						jeu[i+1][j+1] ++;
					}
					
					
				}
			}
		}
	}
	
	
}


