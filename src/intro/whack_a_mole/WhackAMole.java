package intro.whack_a_mole;

// Filler-code for Whack a Mole by Mr. Friedman

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class WhackAMole extends JPanel{
    //importing images
    Image background = Toolkit.getDefaultToolkit().createImage("background.png");
    Image mole_hole = Toolkit.getDefaultToolkit().createImage("mole_hole.png");
    Image mole = Toolkit.getDefaultToolkit().createImage("mole.png");
    Image bonus = Toolkit.getDefaultToolkit().createImage("bonus.png");
    Image bomb = Toolkit.getDefaultToolkit().createImage("bomb.png");

	// creating variables
    private final int textHeight = 35;
    private final int holeNum = 10;
    private final int moleNum = 3;
    private final int timeChange = 5000;
    private final int moleHeight = 80;
    private final int moleWidth = 77;
    private int score, windowWidth = 1024, windowHeight = 500;
    private final boolean [] molePlacement = new boolean[holeNum];
    private final boolean [] bombPlacement = new boolean[holeNum];
    private final boolean [] bonusPlacement = new boolean[holeNum];
    private final int[][] map = new int[windowWidth][windowHeight];
    private final int[][] holePlacement = new int[holeNum][2];

    public void updateHoles() {
        Random rand = new Random(); //generating random
        for (int i = 0; i < windowWidth; i++) { //clear map
            for (int j = 0; j < windowHeight; j++) {
                map[i][j] = 0;
            }
        }
        for (int i = 0; i < holeNum; i++) { //find holes to place
            //reset all the boolean arrays
            molePlacement[i] = false;
            bonusPlacement[i] = false;
            bombPlacement[i] = false;
            int random_x, random_y; //two randomly generated integers for the next hole's coordinates
            do {
                //generating values
                random_x = rand.nextInt(windowWidth - moleWidth);
                random_y = rand.nextInt(windowHeight - textHeight - moleHeight);
            } while (map[random_x][random_y + textHeight] != 0 || map[random_x + moleWidth][random_y + textHeight + moleHeight] != 0 || map[random_x][random_y + textHeight + moleHeight] != 0 || map[random_x + moleWidth][random_y + textHeight] != 0); //assuming each hole takes the area of a rectangle, making sure the area is not taken by judging the four vertices
            holePlacement[i][0] = random_x; //recording the successful values
            holePlacement[i][1] = random_y + textHeight; //adding the top bar's texts' height too
            for (int k = 0; k < moleWidth; k++) { //updating the map by coloring each rectangle to its id(i + 1)
                for (int j = 0; j < moleHeight; j++) {
                    if ((k + random_x) < windowWidth && (j + random_y + textHeight) < windowHeight) { //making sure the selected value is not out of bounds
                        map[k + random_x][j + random_y + textHeight] = i + 1; //setting to i + 1 to avoid 0(which is the original value)
                    }
                }
            }
        }
        int random_num = rand.nextInt(4); //generate a random number to determine if a bonus or a bomb will be placed
        if (random_num == 0 || random_num == 1) { //1/2 chance of getting a bomb each round
            int currentBomb = 0;
            do {
                currentBomb = rand.nextInt(holeNum);
            } while (bombPlacement[currentBomb]); //selecting an empty hole
            bombPlacement[currentBomb] = true; //setting the hole to a bomb
        }
        if (random_num == 2) {
            int currentBonus = 0;
            do {
                currentBonus = rand.nextInt(holeNum);
            } while (bombPlacement[currentBonus] || bonusPlacement[currentBonus]); //selecting an empty hole
            bonusPlacement[currentBonus] = true; //setting the hole to a gift box
        }
        for (int i = 0; i < moleNum; i++) {
            int currentMole = 0;
            do {
                currentMole = rand.nextInt(holeNum);
            } while (molePlacement[currentMole] || bombPlacement[currentMole] || bonusPlacement[currentMole]); // selecting an empty hole
            molePlacement[currentMole] = true; //setting the hole to a mole
        }
    }
   

    public void draw(Graphics g) {
        g.drawImage(background, 0, 0, windowWidth, windowHeight, null); // draw background
        for (int i = 0; i < holeNum; i++) {
            if (molePlacement[i]) { // if the hole is a mole
                g.drawImage(mole, holePlacement[i][0], holePlacement[i][1],null); // draw mole
            }
            else {
                if (bombPlacement[i]) { // if the hole is a bomb
                    g.drawImage(bomb, holePlacement[i][0], holePlacement[i][1], null); // draw bomb
                }
                else {
                    if (bonusPlacement[i]) { // if the hole is a gift box
                        g.drawImage(bonus, holePlacement[i][0], holePlacement[i][1], null); // draw gift box
                    }
                    else g.drawImage(mole_hole, holePlacement[i][0], holePlacement[i][1],null); // if the hole is just a hole, draw nothing
                }
            }
        }
    }


    // what you want to happen when the mouse is clicked
    public void click(int mouseX, int mouseY) {
    	int holeID = map[mouseX][mouseY]; // getting the hole's id using the map array initiated earlier
        if (holeID == 0) return; // if there's nothing, return
        if (molePlacement[holeID - 1]) { // if it is a mole
            molePlacement[holeID - 1] = false; // make the mole disappear
            score++; // add to the score
        }
        if (bombPlacement[holeID - 1]) {
            bombPlacement[holeID - 1] = false; // make the bomb disappear
            score = 0; // clear the score
        }
        if (bonusPlacement[holeID - 1]) {
            bonusPlacement[holeID - 1] = false; // make the gift box disappear
            score += 5; // add to the score
        }
    }
    
    // reset the game
    public void reset() {
        score = 0; // clear the score
        updateHoles(); // regenerate holes
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
                scoreDisplay.setText("\t\tScore: " + score + "       " + "Don't Click on Bombs and Click on Gifts");
            }
        };
        canvas.setPreferredSize(new Dimension(windowWidth, windowHeight));

        canvas.addMouseListener(new MouseListener() {

            @Override
            public void mousePressed(MouseEvent e) {
                click(e.getX(), e.getY());
                scoreDisplay.setText("\t\tScore: " + score + "       " + "Don't Click on Bombs and Click on Gifts");
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
        canvas.revalidate();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.getContentPane().repaint();
        window.setVisible(true);
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