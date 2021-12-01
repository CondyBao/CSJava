package intro.whack_a_mole;

// Filler-code for Whack a Mole by Mr. Friedman

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class WhackAMole extends JPanel{
    Image background = Toolkit.getDefaultToolkit().createImage("background.png");
    Image mole_hole = Toolkit.getDefaultToolkit().createImage("mole_hole.png");
    Image mole = Toolkit.getDefaultToolkit().createImage("mole.png");

	// size of the display area
    private final int textHeight = 35, holeNum = 10, moleNum = 3, timeChange = 3000, moleHeight = 80, moleWidth = 77;
    private int score, windowWidth = 1024, windowHeight = 500;
    private boolean [] molePlacement = new boolean[holeNum];
    private int[][] map = new int[windowWidth][windowHeight], holePlacement = new int[holeNum][2];

    public void updateHoles() {
        Random rand = new Random();
        for (int i = 0; i < windowWidth; i++) {
            for (int j = 0; j < windowHeight; j++) {
                map[i][j] = 0;
            }
        }
        for (int i = 0; i < holeNum; i++) {
            molePlacement[i] = false;
            int random_x, random_y;
            do {
                random_x = rand.nextInt(windowWidth - moleWidth);
                random_y = rand.nextInt(windowHeight - textHeight - moleHeight);
            } while (map[random_x][random_y + textHeight] != 0 || map[random_x + moleWidth][random_y + textHeight + moleHeight] != 0 || map[random_x][random_y + textHeight + moleHeight] != 0 || map[random_x + moleWidth][random_y + textHeight] != 0);
            holePlacement[i][0] = random_x;
            holePlacement[i][1] = random_y + textHeight;
            for (int k = 0; k < moleWidth; k++) {
                for (int j = 0; j < moleHeight; j++) {
                    if ((k + random_x) < windowWidth && (j + random_y + textHeight) < windowHeight) {
                        map[k + random_x][j + random_y + textHeight] = i + 1;
                    }
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
   

    public void draw(Graphics g) {
        g.drawImage(background, 0, 0, windowWidth, windowHeight, null);
        for (int i = 0; i < holeNum; i++) {
            if (molePlacement[i]) {
                g.drawImage(mole, holePlacement[i][0], holePlacement[i][1],null);
            }
            else {
                g.drawImage(mole_hole, holePlacement[i][0], holePlacement[i][1], null);
            }
        }
    }


    // what you want to happen when the mouse is clicked
    public void click(int mouseX, int mouseY) {
    	int holeID = map[mouseX][mouseY];
        if (molePlacement[holeID - 1]) {
            molePlacement[holeID - 1] = false;
            score++;
            repaint();
        }
    }
    
    // reset the game
    public void reset() {
        score = 0;
        updateHoles();
    }


    public WhackAMole() {
        updateHoles();
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
        try {
            Thread.sleep(70);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.getContentPane().repaint();
        new javax.swing.Timer(timeChange, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                updateHoles();
                window.getContentPane().repaint();
            }
        }).start();
    }


    public static void main(String[] args) {
        new WhackAMole();
    }
}