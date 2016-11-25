package editing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

	public Window()
	{
		// JFrame
		this.setTitle("Démineur");
		this.setSize(288, 288);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		//
		// JPanel
		JPanel pane = new JPanel();
		pane.setPreferredSize(new Dimension(288,288));
		pane.setLayout(null);
		pane.setBackground(Color.BLUE);
		this.setContentPane(pane);
	    
	    // Icone
	    ImageIcon textureBloc = new ImageIcon("src/editing/case.png");
	    
	    ArrayList<ArrayList<JButton>> liste = new ArrayList<ArrayList<JButton>>();
	    
		// JButton
	
		for(int i = 0; i < 9; i++)
		{
			liste.add(new ArrayList<JButton>());
			for(int j = 0; j < 9; j++)
			{
				
				liste.get(i).add(new JButton("", textureBloc));
				((Component) liste.get(i).get(j)).setBounds(32*i, 32*j, 32, 32);
				pane.add((Component) liste.get(i).get(j));
			}
		}	   
	    
	    this.setContentPane(pane);
	    this.pack();
	    this.setVisible(true);
		
	}
	
    // Evenements
/*    bouton.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		
    	}
    });*/
}
