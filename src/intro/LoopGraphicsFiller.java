// filler code for pong provided by Mr. David
package intro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoopGraphicsFiller extends JPanel {
	
	// constants that are predefined and won't change as the program runs
	private final int WIDTH = 1000, HEIGHT = 590;
	private int diam = 0;
	private boolean shrink = false;

	// defines what we want to happen anydiam we draw the graphics

	public void tenTencircles(Graphics g) {
		g.setColor(Color.green);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				g.fillOval(10 + i * 10, 10 + j * 10, 5, 5);
			}
		}
	}

	public void shrinkCircle(Graphics g) {
		g.setColor(Color.red);
		for (int i = 0; i < 5; i++) {
			g.fillOval(160 + i * 100, 10, diam, diam);
		}
	}

	public void rowCircle(Graphics g) {
		g.setColor(Color.black);
		for (int i = 0; i < 10; i++) {
			g.fillOval(10 + i * 60, 120, (60 - 10 * Math.abs(5 - i)), (60 - 10 * Math.abs(5 - i)));
		}
	}

	public void drawShapes(Graphics g) {
		g.setColor(Color.blue);
		for (int i = 0; i < 10; i++) {
			if (i % 3 == 0) {
				g.fillOval(10 + i * 70, 210, 30, 30);
			}
			if (i % 3 == 1) {
				g.fillRect(10 + i * 70, 210, 30, 10);
			}
			if (i % 3 == 2) {
				g.drawPolygon(new int[] {10 + i * 70, i * 70, 50 + i * 70}, new int[] {210, 240, 240}, 3);
			}
		}
	}

	public void rectLine(Graphics g) {
		for (int i = 0; i < 10; i++) {
			if (i % 4 == 0) {
				g.setColor(Color.red);
			}
			if (i % 4 == 1) {
				g.setColor(Color.pink);
			}
			if (i % 4 == 2) {
				g.setColor(Color.green);
			}
			if (i % 4 == 3) {
				g.setColor(Color.yellow);
			}
			g.fillRect(10 + i * 80, 280, 50, 20);
		}
	}

	public void paint(Graphics g) {
		
		// background color is gray
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		// call your methods here
		tenTencircles(g);
		shrinkCircle(g);
		rowCircle(g);
		drawShapes(g);
		rectLine(g);
		if (diam > 110) {
			shrink = true;
		}
		if (diam < 10) {
			shrink = false;
		}
		if (shrink) diam -= 2;
		else diam += 2;
	}

	//////////////////////////////////////
	//////////////////////////////////////
	
	// DON'T TOUCH THE BELOW CODE
	
	
	// this method runs the actual program.
	public void run() {

		// while(true) should rarely be used to avoid infinite loops, but here it is ok because
		// closing the graphics window will end the program
		while (true) {
	
			// draws
			repaint();
			
			//rests for a hundredth of a second
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
		}
	}
	
	// very simple main method to get the game going
	public static void main(String[] args) {
		new LoopGraphicsFiller();
	}
 
	// does complicated stuff to initialize the graphics and key listeners
	// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
	// GRAPHICS!
	public LoopGraphicsFiller() {
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		this.setFocusable(true);
		
		run();
	}
}