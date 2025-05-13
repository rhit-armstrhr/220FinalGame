import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Controller {

	private JFrame frame;

	public Controller(JFrame jFrame) {
		// TODO Auto-generated constructor stub
		this.frame = jFrame;
		Timer animation = new Timer(20, e -> getAndHandleEvents());
		animation.start();
		addListeners();

	}

	private void addListeners() {
		// TODO Auto-generated method stub
		frame.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					// canvas.moveDelta(10);
					System.out.println("right");
					break;
				case KeyEvent.VK_LEFT:
//					canvas.moveDelta(-10);
					System.out.println("left");
					break;

				}
			};
		});
	}

	private void getAndHandleEvents() {
		// TODO Auto-generated method stub
System.out.println("run");
	}

	public void addFrame(JFrame frame) {
		// TODO Auto-generated method stub
		this.frame = frame;
	}

}
