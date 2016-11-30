package editing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FenetreAvecMenu extends JFrame
{
	//Nom des "menu"
	private JMenuBar menuBar = new JMenuBar();
	private JMenuBar menuFichier = new JMenuBar();
	private JMenuBar menuDifficulté = new JMenuBar();
	private JMenuBar menuAide = new JMenuBar();
	
	//Nom des onglets
	private JMenuItem item2 = new JMenuItem ("Fermer");
	private JMenuItem item3 = new JMenuItem ("Facile");
	private JMenuItem item4 = new JMenuItem ("Normal");
	private JMenuItem item5 = new JMenuItem ("Difficile");
	private JMenuItem item6 = new JMenuItem ("Aide");
	
	public FenetreAvecMenu ()
	{
		setSize(800,500);
		setTitle("Démineur");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		// Bouton "ouvrir"
		item2.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dispose();
					}
				});
		
		// Bouton "Facile"
		item3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Game jeu = new Game(1);
				dispose();
			}
		});
		
		// Bouton "Normal"
		item4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Game jeu = new Game(2);
				dispose();
			}
		});
		
		// Bouton "Difficile"
		item5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Game jeu = new Game(3);
				dispose();
			}
		});
		
		// Affichage des menus
		menuFichier.add(item2);
		menuDifficulté.add(item3);
		menuDifficulté.add(item4);
		menuDifficulté.add(item5);	
		menuAide.add(item6);
		menuBar.add(menuFichier);
		menuBar.add(menuDifficulté);
		menuBar.add(menuAide);
		
		this.setJMenuBar(menuBar);
		this.setVisible(true);
				
	}

}
