package editing;

public class Game {

	public Game(int difficulty)
	{
		// Génération et affichage du tableau de bombes
		Tableau grille = new Tableau(difficulty);
		grille.Build();
		System.out.println(grille.toString());
		System.out.println();
		
		// Génération et affichage du tableau solution
		grille.nbBombesAdjacants();
		System.out.println(grille.toString());
		
		// Affichage de la fenêtre de jeu
		Window fenetre = new Window(grille.getLigne(), grille.getColonne());
	}
}
