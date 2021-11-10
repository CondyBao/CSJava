package intro;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FallingBlocks extends JPanel {
	
	private int WIDTH = 800, HEIGHT = 600, NUMBLOCKS = 50, NUMCOLORS = 5, BOXSIZE = 10;
	private int[] arrayX = new int[NUMBLOCKS];
	private int[] arrayY = new int[WIDTH];

	// instance variables (what kind of data structure should we use?)

	// your code here
	
	// fills in your arrays with random x and y values
	public void initializeArrays() {
		for (int i = 0; i < WIDTH; i++) {
			arrayY[i] = (int)(Math.random() * HEIGHT);
		}
		for (int i = 0; i < NUMBLOCKS; i++) {
			arrayX[i] = (int)(Math.random() * WIDTH);
		}
	}
	
	// change your arrays here to make the blocks move
	public void moveblocks() {

		// your code here
		for (int i = 0; i < WIDTH; i++) {
			arrayY[i] += (int)(Math.random() * 5);
			if (arrayY[i] >= HEIGHT) arrayY[i] = 0;
		}
	}
	
	// change the last part of this method!
	public void paint(Graphics g) {
		// give a white background
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// color the rectangles blue - you can change this
		g.setColor(Color.blue);
		
		// draw your rectangles here! 
		for (int i = 0; i < NUMBLOCKS; i++) {
			if (i % NUMCOLORS == 0) {
				g.setColor(Color.red);
			}
			if (i % NUMCOLORS == 1) {
				g.setColor(Color.yellow);
			}
			if (i % NUMCOLORS == 2) {
				g.setColor(Color.green);
			}
			if (i % NUMCOLORS == 3) {
				g.setColor(Color.blue);
			}
			if (i % NUMCOLORS == 4) {
				g.setColor(Color.magenta);
			}
			g.fillRect(arrayX[i], arrayY[arrayX[i]], BOXSIZE, BOXSIZE);
		}
	}
	
	// ******** DON'T TOUCH BELOW CODE ***************
	
	// don't touch this method!
	public FallingBlocks() {
		initializeArrays();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setVisible(true);

		while (true) {
			moveblocks();
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			WIDTH = frame.getSize().width;
			HEIGHT = frame.getSize().height;
		}
	}

	// don't touch this method!
	public static void main(String[] args) {
		new FallingBlocks();
	}

}