package editing;

import java.util.Random;

public class Tableau{
	
	
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
			this.ligne = 30;
			this.colonne = 16;
			this.nbBomb = 99;
		}
		
	}
	
	// Ajout de bombe dans des cases aléatoires du tableau
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
	
	
		
		
	public int getColonne()
	{
		return colonne;
	}
	
	public int getLigne()
	{
		return ligne;
	}
	

	// Génération des nombres de bombes adjaçantes aux cases
	public void nbBombesAdjacants()
	{
		for(int i = 0; i < ligne; i++)
		{
			
			for(int j = 0; j < colonne ; j++)
			{

					int bombes = 0;
					if(jeu[i][j] != -1)
					{
						if(i-1 >= 0 && j-1 >= 0 && jeu[i-1][j-1] == -1)
							bombes++;
						if(j-1 >= 0 && jeu[i][j-1] == -1)
							bombes++;
						if(i+1 < ligne && j-1 >= 0 && jeu[i+1][j-1] == -1)
							bombes++;
						if(i-1 >= 0 && jeu[i-1][j] == -1)
							bombes++;
						if(i+1 < ligne && jeu[i+1][j] == -1)
							bombes++;
						if(i-1 >= 0 && j+1 < colonne && jeu[i-1][j+1] == -1)
							bombes++;
						if(j+1 < colonne && jeu[i][j+1] == -1)
							bombes++;
						if(i+1 < ligne && j+1 < colonne && jeu[i+1][j+1] == -1)
							bombes++;
						jeu[i][j] = bombes;
					}
			}
		}
	}
	
	public int getNum(int a, int b)
	{
		return jeu[a][b];
	}
	
	
}
	
	



