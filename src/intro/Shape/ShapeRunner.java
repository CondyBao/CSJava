package intro.Shape;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class ShapeRunner {
	
	private Shape[] shapes;

	private int timer = 0;
	
	// this method should move all the shapes in the list
	public void moveShapes() {
		for (Shape i : shapes) {
			if (timer % 100 < 50) i.move(3, 3);
			else i.move(-3, -3);
		}
		timer++;
	}
	
	// fill in your shape list here
	public void setup() {
		Rect a = new Rect(100, 100, 10, 20);
		Oval b = new Oval(50, 50, 30, 40);
		Line c = new Line(150, 0, 10, 20);
		shapes = new Shape[] {a, b, c};
	}
	
	// DON'T TOUCH BELOW CODE
	
	public void run() {
		while (true ) {
			moveShapes();
			frame.repaint();
			try {
				Thread.sleep(75);
			} catch (Exception ex) {}
		}
	}
	
	public static void main(String[] args) {
		new ShapeRunner(); 
	}
	private JFrame frame;
	public ShapeRunner() {
		setup();
		frame = new JFrame() {
			public void paint(Graphics g) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, 600, 600);
				
				for (Shape s: shapes)
					s.draw(g);
			}
		};
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		run();
	}
}