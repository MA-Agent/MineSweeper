package editing;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	ImageIcon textureBloc;
	Tableau grille;
	int pos, ligne, colonne;
	JLabel score;
	JPanel pane;

	public Window(int ligne, int colonne, Tableau grille)
	{
		this.grille = grille;
		this.ligne = ligne;
		this.colonne = colonne;
		String s; // ActionCommand
		JButton bouton;
		
		// JFrame
		this.setTitle("Démineur");
		this.setSize(colonne*32, 20+ligne*32);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		// Textures des boutons
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
		textureBloc = new ImageIcon("resources/case.png");

		// JPanel
		pane = new JPanel();
		pane.setPreferredSize(new Dimension(colonne*32, 20+ligne*32));
		pane.setLayout(null);
		
		// JLabel
		score = new JLabel("Nombre de bombes restantes: ");
		score.setBounds(0,0,50,25);
		pane.add(score);


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
				((Component) liste.get(i).get(j)).setBounds(32*j, 20+32*i, 32, 32);
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
		if(pos == 9)
		{
			lose();
		}
		else
		{
			reveal(i, j);
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


		switch((pos < 0)? Math.abs(pos)-1 : pos)
		{
		case 9: liste.get(i).get(j).setIcon(textureBomb);
		break;
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
		default: liste.get(i).get(j).setIcon(texturePressed);	
		}
	}

	// Le but de cette fonction est d'afficher les icones des cases adjacante a celle donnée en paramètre
	private void reveal(int i, int j)
	{
		pos = grille.getNum(i, j);
		if(pos >= 0)
		{

			changeIcon(pos, i, j);
			grille.setNum(i, j, (-1*pos) -1);
			if(pos == 0)
			{
				if(i-1 >= 0 && j-1 >= 0)
				{
					reveal(i-1, j-1);

				}
				if(i-1 >= 0)
				{
					reveal(i-1, j);
				}
				if(j-1 >= 0)
				{
					reveal(i, j-1);
				}
				if(j+1 < colonne)
				{
					reveal(i, j+1);
				}
				if(i+1 < ligne)
				{
					reveal(i+1, j);
				}
				if(i+1 < ligne && j+1 < colonne)
				{
					reveal(i+1, j+1);
				}
				if(i+1 < ligne && j-1 >= 0)
				{
					reveal(i+1, j-1);
				}
				if(i-1 >= 0 && j+1 < colonne)
				{
					reveal(i-1, j+1);
				}
			} 
		}
	}

}