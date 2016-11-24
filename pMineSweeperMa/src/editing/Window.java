package editing;

import java.awt.Color;
import java.awt.Component;
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
		
		// JPanel
		JPanel pane = new JPanel();
		pane.setLayout(null);
		pane.setBackground(Color.BLUE);
		this.setContentPane(pane);
	    
	    // Icone
	    ImageIcon icone = new ImageIcon("D:\\Users\\MIKE-COMPUTER\\git\\MineSweeper\\pMineSweeperMa\\src\\editing\\case.png");
	    List liste = new ArrayList();
	    
	    
		// JButton
		JButton bouton = new JButton("", icone);
		JButton bouton2 = new JButton("", icone);

		
		for(int i = 0; i < 9; i++)
		{
				liste.add(new JButton("", icone));
				((Component) liste.get(i)).setBounds(32*i, 0, 32, 32);
				pane.add((Component) liste.get(i));
		}	
			
		//bouton.setBounds(0, 0, 32, 32);
	    //pane.add(bouton);
	    //bouton2.setBounds(0, 32, 32, 32);
	    //pane.add(bouton2);
	    
	    
	    
	    
	    this.setContentPane(pane);
	    this.setVisible(true);
		
	    // Evenements
/*	    bouton.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		
	    	}
	    });
*/	}
}
