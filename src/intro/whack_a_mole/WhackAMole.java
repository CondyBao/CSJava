package intro.whack_a_mole;

// Filler-code for Whack a Mole by Mr. Friedman

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.*;

public class WhackAMole extends JPanel{
    Image background = Toolkit.getDefaultToolkit().createImage("background.png");
    Image mole_hole = Toolkit.getDefaultToolkit().createImage("mole_hole.png");
    Image mole = Toolkit.getDefaultToolkit().createImage("mole.png");

	// size of the display area
    private final int textHeight = 35, holeNum = 10, moleNum = 3, timeChange = 1000, moleHeight = 80, moleWidth = 77;
    private int timer, score, windowWidth = 1024, windowHeight = 500;
    private boolean [] molePlacement = new boolean[holeNum];
    private int[][] map = new int[windowWidth][windowHeight], holePlacement = new int[holeNum][2];

    // more instance variables...?

    public void updateHoles() {
        if (timer % timeChange == 0) {
            Random rand = new Random();
            for (int i = 0; i < holeNum; i++) {
                int random_x = rand.nextInt(windowWidth), random_y = rand.nextInt(windowHeight - textHeight);
                while (map[random_x][random_y + textHeight] != 0 || map[random_x + moleWidth][random_y + textHeight + moleHeight] != 0){
                    random_x = rand.nextInt(windowWidth);
                    random_y = rand.nextInt(windowHeight - textHeight);
                }
                holePlacement[i][0] = random_x;
                holePlacement[i][1] = random_y + textHeight;
                for (int k = 0; k < moleWidth; k++) {
                    for (int j = 0; j < moleHeight; j++) {
                        map[k + random_x][j + random_y + textHeight] = i + 1;
                    }
                }
            }
            for (int i = 0; i < moleNum; i++) {
                int currentMole = rand.nextInt(holeNum);
                while (molePlacement[currentMole]) {
                    currentMole = rand.nextInt(holeNum);
                }
                molePlacement[currentMole] = true;
            }
        }
    }
   

    public void draw(Graphics g) {
        g.drawImage(background, 0, 0, null);
        for (int i = 0; i < holeNum; i++) {
            if (molePlacement[i]) {
                g.drawImage(mole, holePlacement[i][0], holePlacement[i][1], null);
            }
            else {
                g.drawImage(mole_hole, holePlacement[i][0], holePlacement[i][1], null);
            }
        }
        // your code here
    }


    // what you want to happen when the mouse is clicked
    public void click(int mouseX, int mouseY) {
    	
    	// your code here
    }
    
    // reset the game
    public void reset() {
    	
    	// your code here
        score = 0;
        timer = 0;
        updateHoles();
    }

    public void run() {
        while (true) {

            // redraws the game
            repaint();
            timer += 100;
            //rests for a portion of a second
        }
    }


    // MAYBE TOUCH THE BELOW CODE? //

    public WhackAMole() {
        JFrame window = new JFrame();
        window.setTitle("Whack A Mole");
        window.setSize(windowWidth, windowHeight + textHeight);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JTextArea scoreDisplay = new JTextArea();
        scoreDisplay.setEditable(false);
        scoreDisplay.setText("\t\tScore: 0");
        
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
                window.getContentPane().repaint();
			}
        });
        
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(windowWidth, textHeight));
        topPanel.add(resetButton);
        scoreDisplay.setBackground(topPanel.getBackground());
        
        topPanel.add(scoreDisplay);

        

        JPanel canvas = new JPanel() {
            public void paint(Graphics g) {
                draw(g);
            }
        };
        canvas.setPreferredSize(new Dimension(windowWidth, windowHeight));

        canvas.addMouseListener(new MouseListener() {

            @Override
            public void mousePressed(MouseEvent e) {
                click(e.getX(), e.getY());
                scoreDisplay.setText("\t\tScore: ");
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
        
        window.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                windowWidth = window.getWidth();
                windowHeight = window.getHeight() - textHeight;
                topPanel.setPreferredSize(new Dimension(windowWidth, textHeight));
                canvas.setPreferredSize(new Dimension(windowWidth, windowHeight));
            }
        });

        container.add(topPanel);
        container.add(canvas);
        window.add(container);
        window.setVisible(true);
        canvas.revalidate();
        run();
        window.getContentPane().repaint();
    }
    

    public static void main(String[] args) {
        new WhackAMole();
    }

}