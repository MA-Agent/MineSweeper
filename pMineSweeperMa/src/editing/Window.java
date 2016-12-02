package editing;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame implements ActionListener{

	ArrayList<ArrayList<JButton>> liste;
	ImageIcon texturePressed;
	ImageIcon texturePressed1;
	ImageIcon texturePressed2;
	ImageIcon texturePressed3;
	ImageIcon texturePressed4;
	ImageIcon texturePressed5;
	ImageIcon texturePressed6;
	ImageIcon texturePressed7;
	ImageIcon texturePressed8;
	ImageIcon textureBomb;
	Tableau grille;
	int pos, ligne, colonne;

	public Window(int colonne, int ligne, Tableau grille)
	{
		this.grille = grille;
		this.ligne = ligne;
		this.colonne = colonne;
		String s;
		JButton bouton;
		// JFrame
		this.setTitle("Démineur");
		this.setSize(288, 288);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		texturePressed = new ImageIcon("resources/0.png");
		texturePressed1 = new ImageIcon("resources/1.png");
		texturePressed2 = new ImageIcon("resources/2.png");
		texturePressed3 = new ImageIcon("resources/3.png");
		texturePressed4 = new ImageIcon("resources/4.png");
		texturePressed5 = new ImageIcon("resources/5.png");
		texturePressed6 = new ImageIcon("resources/6.png");
		texturePressed7 = new ImageIcon("resources/7.png");
		texturePressed8 = new ImageIcon("resources/8.png");
		textureBomb = new ImageIcon("resources/bomb.png");


		// JPanel
		JPanel pane = new JPanel();
		pane.setPreferredSize(new Dimension(ligne*32, colonne*32));
		pane.setLayout(null);

		// Icone
		ImageIcon textureBloc = new ImageIcon("resources/case.png");

		// Liste de liste boutons
		liste = new ArrayList<ArrayList<JButton>>();

		// Ajout d'autant de bouton qu'il faut de ligne et de colonne sous forme de liste de liste.
		for(int i = 0; i < ligne; i++)
		{
			liste.add(new ArrayList<JButton>());
			for(int j = 0; j < colonne; j++)
			{
				s = String.format("%02d", i) + String.format("%02d", j);
				bouton = new JButton("", textureBloc);
				bouton.addActionListener(this);
				bouton.setActionCommand(s);
				liste.get(i).add(bouton);
				((Component) liste.get(i).get(j)).setBounds(32*j, 32*i, 32, 32);
				pane.add((Component) liste.get(i).get(j));
			}
		}	   

		// Ajout du JPanel dans la JFrame
		this.setContentPane(pane);
		this.pack();
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {      
		System.out.println("Bouton préssé " + e.getActionCommand()); // TMP
		int i = Integer.parseInt(e.getActionCommand().substring(0,2));
		int j = Integer.parseInt(e.getActionCommand().substring(2,4));
		System.out.println("i: " + i + " j: "+ j); // TMP
		pos = grille.getNum(i, j);
		if(pos == -1)
		{
			lose();
		}
		else
		{
			changeIcon(pos, i, j);
			changeIconClear(pos, i, j);
		}
	}

	private void lose()
	{
		for(int i = 0; i < ligne; i++)
		{
			for(int j = 0; j < colonne; j++)
			{
				pos = grille.getNum(i, j);
				changeIcon(pos, i, j);

			}
		}	   
	}

	private void changeIcon(int pos, int i, int j)
	{
		switch(pos)
		{
		case 0: liste.get(i).get(j).setIcon(texturePressed);
		break;

		case 1: liste.get(i).get(j).setIcon(texturePressed1);
		break;
		case 2: liste.get(i).get(j).setIcon(texturePressed2);
		break;
		case 3: liste.get(i).get(j).setIcon(texturePressed3);
		break;
		case 4: liste.get(i).get(j).setIcon(texturePressed4);
		break;
		case 5: liste.get(i).get(j).setIcon(texturePressed5);
		break;
		case 6: liste.get(i).get(j).setIcon(texturePressed6);
		break;
		case 7: liste.get(i).get(j).setIcon(texturePressed7);
		break;
		case 8: liste.get(i).get(j).setIcon(texturePressed8);
		break;
		default: liste.get(i).get(j).setIcon(textureBomb);	
		}
	}

	// Le but de cette fonction est d'afficher les icones des cases adjacante a celle donnée en paramètre
	private void reveal()
	{

	}

	private void changeIconClear(int pos, int i, int j)
	{
		switch(pos)
		{
		case 0: liste.get(i).get(j).setIcon(texturePressed);
		clearCaseAdj(i, j);
		break;
		case 1: liste.get(i).get(j).setIcon(texturePressed1);
		break;
		case 2: liste.get(i).get(j).setIcon(texturePressed2);
		break;
		case 3: liste.get(i).get(j).setIcon(texturePressed3);
		break;
		case 4: liste.get(i).get(j).setIcon(texturePressed4);
		break;
		case 5: liste.get(i).get(j).setIcon(texturePressed5);
		break;
		case 6: liste.get(i).get(j).setIcon(texturePressed6);
		break;
		case 7: liste.get(i).get(j).setIcon(texturePressed7);
		break;
		case 8: liste.get(i).get(j).setIcon(texturePressed8);
		break;
		default: liste.get(i).get(j).setIcon(textureBomb);	
		}
	}
	private void clearCaseAdj(int i,int j){


		if(i-1 >= 0 && j-1 >= 0 && grille.getNum(i-1,j-1) >= 0){
			changeIcon(grille.getNum(i-1,j-1), i-1, j-1);

		}

		if(j-1 >= 0 && grille.getNum(i,j-1) >= 0){

			changeIcon(grille.getNum(i,j-1), i, j-1);

		}

		if(i+1 < ligne && j-1 >= 0 && grille.getNum(i+1,j-1) >= 0){

			changeIcon(grille.getNum(i+1,j-1), i+1, j-1);

		}

		if(i-1 >= 0 && grille.getNum(i-1,j) >= 0){

			changeIcon(grille.getNum(i-1,j), i-1, j);

		}

		if(i+1 < ligne && grille.getNum(i+1,j) >= 0){

			changeIcon(grille.getNum(i+1,j), i+1, j);

		}

		if(i-1 >= 0 && j+1 < colonne && grille.getNum(i-1,j+1) >= 0){

			changeIcon(grille.getNum(i-1,j+1), i-1, j+1);

		}

		if(j+1 < colonne && grille.getNum(i,j+1) >= 0){

			changeIcon(grille.getNum(i,j+1), i, j+1);

		}

		if(i+1 < ligne && j+1 < colonne && grille.getNum(i+1,j+1) >= 0){

			changeIcon(grille.getNum(i+1,j+1), i+1, j+1);

		}


	}



}