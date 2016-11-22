package editing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tableau{


	private int ligne;
	private int colonne;
	private int nbBomb;
	
	Random rand = new Random();
	boolean[][] jeu;
	
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
		jeu = new boolean[colonne][ligne];
		
		// Initialisation du tableau à false
		for(int i = 0; i < colonne; i++)
		{
			for(int y = 0; y < ligne; y++)
			{
				jeu[i][y] = false;
			}
		}
		
		// Remplissage de cases random avec des bombes (true)
		for(int i = 0; i < nbBomb; i++)
		{
			int randC = rand.nextInt(colonne);
			int randL = rand.nextInt(ligne);
			
			if(jeu[randC][randL] == false)
			{
				jeu[randC][randL] = true;
			}
			else
			{
				i--;
			}
	}
		
	}
	
	// Affiche la grille de jeu
	public void Afficher()
	{
		for(int i = 0; i < colonne; i++)
		{
			for(int y = 0; y < ligne; y++)
			{
				System.out.println(jeu[i][y]);
			}
			System.out.println("\n");
		}
	}
}


