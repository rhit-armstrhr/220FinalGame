import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/*
 * Author Hayden Armstrong and Frank LaMontia. This starts the game and creates the timer for the game.
 */
public class main {

	public static void main(String[] args) {

		// Runs The Viewer Class
		Viewer view = new Viewer();
		view.createGUI();
// Creates the timer that runs the updates in the game. 
		Timer timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.update();
				view.drawScreen();
			}

		});

		timer.start();

	}

}