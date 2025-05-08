/**
* @author Frank LaMantia
* Used only 220 materials
*/

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Viewer {

	public static void createGUI() {
		JFrame frame = new JFrame("Viewer");
		
		Courses c = new Courses();
		
		frame.add(c.getHole());
		
		
		frame.setSize(600, 400);
		frame.pack();
		frame.setLocationRelativeTo(null);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}