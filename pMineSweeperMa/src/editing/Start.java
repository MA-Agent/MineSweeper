package editing;


import java.util.Scanner;


public class Start {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Window fenetre = new Window();
		
		int difficulty = scan.nextInt();
		boolean difCorrect = true;
		
		System.out.println("Entrez une difficulté (1/2/3)");
		do
		{
		if(difficulty != 1 && difficulty != 2 && difficulty !=3)
		{
			System.out.println("Entrez une difficulté (1/2/3)");
			difCorrect = false;
		}
		else
		{
			difCorrect = true;
		}
		}while(!difCorrect);
		

		Tableau grille = new Tableau(difficulty);
		grille.Build();
		System.out.println(grille.toString());
		

		System.out.println();
		grille.nbBombesAdjacants();
		System.out.println(grille.toString());


		


		
	}

}
