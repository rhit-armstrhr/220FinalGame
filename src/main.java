import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class main {

	public static void main(String[] args) {
		
	// Runs The Viewer Class
	Game mainGame = new Game();
	Viewer view = new Viewer();
	view.createGUI();
//	SwingUtilities.invokeLater(() -> view.createGUI());
	
	Controller control = new Controller(view.getFrame());
	mainGame.setController(control);

			
	}

}
