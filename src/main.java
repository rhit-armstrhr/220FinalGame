import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class main {

	public static void main(String[] args) {

		// Runs The Viewer Class
//	Game mainGame = new Game();
		Viewer view = new Viewer();
		view.createGUI();
//	SwingUtilities.invokeLater(() -> view.createGUI());
//	Player p = new Player();
//
//	Controller control = new Controller(view.getFrame(), p);
//	mainGame.setController(control);
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