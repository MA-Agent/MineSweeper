package editing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class FenetreAvecMenu extends JFrame
{
	//Nom des "menu"
	private JMenuBar menuBar = new JMenuBar();
	private JMenuBar menuFichier = new JMenuBar();
	private JMenuBar menuDifficulté = new JMenuBar();
	private JMenuBar menuAide = new JMenuBar();
	
	//Nom des onglets
	private JMenuItem item1 = new JMenuItem ("Ouvrir");
	private JMenuItem item2 = new JMenuItem ("Fermer");
	private JMenuItem item3 = new JMenuItem ("Facile");
	private JMenuItem item4 = new JMenuItem ("Normal");
	private JMenuItem item5 = new JMenuItem ("Difficile");
	private JMenuItem item6 = new JMenuItem ("Aide");
	
	public FenetreAvecMenu ()
	{
		setSize(800,500);// taille de la fenêtre
		setTitle("Démineur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Permet de fermer la fenêtre avec la croix
		setLocationRelativeTo(null);//Centre la fenêtre au millieu
		
		menuFichier.add(item1);
		item2.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dispose();
					}
				});
		
		menuFichier.add(item2);
		menuDifficulté.add(item3);
		menuDifficulté.add(item4);
		menuDifficulté.add(item5);	
		menuAide.add(item6);
		menuBar.add(menuFichier);
		menuBar.add(menuDifficulté);
		menuBar.add(menuAide);
		
		setJMenuBar(menuBar);
	
		setVisible(true);
				
	}

}
