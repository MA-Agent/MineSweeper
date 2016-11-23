package editing;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window extends JFrame {

	public Window()
	{
		// Attribut du JFrame
		this.setTitle("Démineur");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		// JPanel
		JPanel pane = new JPanel();
		
		// Attribut du JPanel
		pane.setBackground(Color.BLUE);
		
		this.setContentPane(pane);
		this.add(new JLabel(new ImageIcon("bomb.png")));
		this.setVisible(true);

		
	}
}
