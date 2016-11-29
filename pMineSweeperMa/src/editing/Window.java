package editing;

import java.awt.Color;
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
		public Window(int ligne, int colonne)
		{
		// JFrame
		this.setTitle("Démineur");
		this.setSize(288, 288);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		texturePressed = new ImageIcon("src/editing/0.png");
		String s; // Format zerma pour le voila
		JButton bouton;
		//
		// JPanel
		JPanel pane = new JPanel();
		pane.setPreferredSize(new Dimension(ligne*32, colonne*32));
		pane.setLayout(null);
		pane.setBackground(Color.BLUE);
	    
	    // Icone
	    ImageIcon textureBloc = new ImageIcon("src/editing/case.png");

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
				((Component) liste.get(i).get(j)).setBounds(32*i, 32*j, 32, 32);
				pane.add((Component) liste.get(i).get(j));
			}
		}	   
	    
		// Ajout du JPanel dans la JFrame
	    this.setContentPane(pane);
	    this.pack();
	    this.setVisible(true);
		
	}
	
	  public void actionPerformed(ActionEvent e) {      
		  System.out.println("Bouton préssé " + e.getActionCommand()); // Format + recuperer i & x 
		  int j = Integer.parseInt(e.getActionCommand().substring(2,4));
		  int i = Integer.parseInt(e.getActionCommand().substring(0,2));
		  System.out.println("i: " + i + " j: "+ j);
		  
		  liste.get(i).get(j).setIcon(texturePressed);
		  liste.get(i).get(j).setEnabled(false);
	  }
}
