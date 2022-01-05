package intro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class jeopardyBoard {
	
	private int gridWidth = 800;
	private int gridHeight = 600;
	private final int textHeight = 50;
	
	private final int NUMQUESTIONS = 4, NUMCATEGORIES = 6;
	
	private int score = 0;

	private int boxHeight, boxWidth, clickedBox; //declaring boxHeight, boxWidth and clickedBox(an indicator for the clicked box's location)
	
	public void draw(Graphics g) {
		boxHeight = gridHeight / NUMQUESTIONS; //update the box height in case of rescale
		boxWidth = gridWidth / NUMCATEGORIES; //update the box width in case of rescale
		for (int i = 0; i < NUMQUESTIONS; i++) { //loop through each row
			for (int j = 0; j < NUMCATEGORIES; j++) { //loop through each column
				g.setColor(Color.orange); //set the color of the rectangles' borders to orange
				g.drawRect(j * boxWidth, i * boxHeight, boxWidth, boxHeight); //draw the rectangles based on their index
				if (((i + 1) * 10 + j) == clickedBox) { //if the box is clicked on
					g.setColor(Color.red); //set text color to red if the box is clicked on
				}
				else {
					g.setColor(Color.blue); //set text color to blue if the box is not clicked on
				}
				g.drawString((i + 1) * 100 + "", (int)((j + 0.5) * boxWidth), (int)((i + 0.5) * boxHeight)); //draw the scores on boxes and make sure they appear in the middle
			}
		}
	}

	public void click(int mouseX, int mouseY) {
		for (int i = 0; i < NUMQUESTIONS; i++) { //loop through each row
			for (int j = 0; j < NUMCATEGORIES; j++) { //loop through each column
				int startX = j * boxWidth, endX = startX + boxWidth, startY = i * boxHeight, endY = startY + boxHeight; //getting the starting and ending coordinates of each boxes
				if (mouseX >= startX && mouseX <= endX && mouseY >= startY && mouseY <= endY) { //check if the box is clicked
					clickedBox = (i + 1) * 10 + j; //giving the clicked box a unique indicator
					score += (i + 1) * 100; //add to score based on the row the question is in
				}
			}
		}
	}
	
	public jeopardyBoard() {
		
		JFrame window = new JFrame();
		window.setTitle("Jeopardy!");
		window.setSize(gridWidth, gridHeight + textHeight);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		JTextArea scoreDisplay = new JTextArea();
		scoreDisplay.setEditable(false);
		scoreDisplay.setText("\t\tScore: 0");
		
		JPanel canvas = new JPanel() {
			public void paint(Graphics g) {
				gridWidth = window.getWidth();
				gridHeight = window.getHeight() - textHeight;
				draw(g);
			}
		};
		canvas.setPreferredSize(new Dimension(gridWidth, gridHeight));
		
		canvas.addMouseListener(new MouseListener() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				click(e.getX(), e.getY());
				scoreDisplay.setText("\t\tScore: " + score);
				window.getContentPane().repaint();
			}

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
		container.add(canvas);
		container.add(scoreDisplay);
		window.add(container);
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		new jeopardyBoard();
	}

}
