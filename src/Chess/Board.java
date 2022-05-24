package Chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;

public class Board {
	
	// keeps track of the position of each king. First row is the position of the white king, 
	// second row is the black king.
	private int[][] kingPositions = new int[2][2];

	// represents the entire board - make sure to initialize!.
	private Piece[][] board = new Piece[8][8];
	
	public Board() {
		
		// loads the images into a map
		HashMap<String, Image> images = loadImages();
		// initializing the board
		for (int i = 0; i < 8; i++) for (int j = 0; j < 8; j++) board[i][j] = new Empty();
		board[0][4] = new King(1, images.get("BlackKing"));
		board[7][4] = new King(0, images.get("WhiteKing"));
		kingPositions[1] = new int[]{0, 4};
		kingPositions[0] = new int[] {7, 4};
		board[0][0] = new Rook(1, images.get("BlackRook"));
		board[0][7] = new Rook(1, images.get("BlackRook"));
		board[7][0] = new Rook(0, images.get("WhiteRook"));
		board[7][7] = new Rook(0, images.get("WhiteRook"));
		board[0][1] = new Knight(1, images.get("BlackKnight"));
		board[0][6] = new Knight(1, images.get("BlackKnight"));
		board[7][1] = new Knight(0, images.get("WhiteKnight"));
		board[7][6] = new Knight(0, images.get("WhiteKnight"));
		board[0][2] = new Bishop(1, images.get("BlackBishop"));
		board[0][5] = new Bishop(1, images.get("BlackBishop"));
		board[7][2] = new Bishop(0, images.get("WhiteBishop"));
		board[7][5] = new Bishop(0, images.get("WhiteBishop"));
		board[0][3] = new Queen(1, images.get("BlackQueen"));
		board[7][3] = new Queen(0, images.get("WhiteQueen"));
		for (int i = 0; i < 8; i++) {
			board[1][i] = new Pawn(1, images.get("BlackPawn"));
			board[6][i] = new Pawn(0, images.get("WhitePawn"));
		}
	}
	
	// draws the board. There should be a grid of 8x8 squares, and each piece in their location. 
	// the last clicked piece (curr) should be drawn on a yellow background.
	public void draw(Graphics g, Piece curr) {
		int sw = Chess.SQUARE_WIDTH;	// the width of each square on the board
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 != j % 2) { // fill every other grid with a different color
					g.setColor(Color.GREEN);
					g.fillRect(j * sw, i * sw, sw, sw);
				}
				board[i][j].draw(g, j * sw, i * sw);
				g.setColor(Color.BLACK); // set the borders to black
				if (board[i][j] == curr) {
					g.setColor(Color.YELLOW); //if the current piece is selected, set the color to yellow
				}
				g.drawRect(j * sw, i * sw, sw, sw); // draw the grid
			}
		}
		
	}
	
	// moves the piece currently at (r, c) to (newR, newC), filling 
	// in the vacated space with an empty square.
	// returns 0 for a normal move, 1 for a check move, 2 for a checkmate move
	public int move(int r, int c, int newR, int newC) {
		int curTeam = board[r][c].getTeam(), opTeam = (curTeam + 1) % 2; // number the teams
		if (newR == kingPositions[opTeam][0] && newC == kingPositions[opTeam][1]) return 2; // if the opposite king is taken, checkmate
		if (r == kingPositions[0][0] && c == kingPositions[0][1]) { // if it is the white king, update the white king's position
			kingPositions[0][0] = newR;
			kingPositions[0][1] = newC;
		}
		if (r == kingPositions[1][0] && c == kingPositions[1][1]) { // if it is the black king, update the black king's position
			kingPositions[1][0] = newR;
			kingPositions[1][1] = newC;
		}
		board[newR][newC] = board[r][c]; // update the board
		board[r][c] = new Empty(); // set the original position to an empty piece
		if (check()) return 1; // check if there is any checks after the move, return 1 if there is
		return 0; // normal move
	}
	
	// determines if the either team is in check.
	public boolean check() {
		for (int i = 0; i < 8; i++) { // go through every piece
			for (int j = 0; j < 8; j++) {
				int curTeam = board[i][j].getTeam(), opTeam = (curTeam + 1) % 2; // number the teams
				if (board[i][j].check(kingPositions[opTeam][0], kingPositions[opTeam][1], i, j, this)) return true; // return true if there is a check
			}
		}
		return false; // return false if there is no check after checking all the grids
	}
	
	
	/******** DON'T TOUCH THE BELOW CODE ****************/
	
	// loads all necessary images into a map. Key = piece name, value = corresponding image
	public HashMap<String, Image> loadImages() {
		String[] pieces = {"King", "Queen", "Rook", "Bishop", "Knight", "Pawn"};
		
		HashMap<String, Image> images = new HashMap<String, Image>();
		
		for (String p : pieces) {
			for (String color : new String[] {"Black", "White"}) {
				Image img = Toolkit.getDefaultToolkit().getImage("src/Chess/Images/" + color + p + ".png");
				images.put(color + p, img.getScaledInstance(Chess.IMG_WIDTH, Chess.IMG_WIDTH, Image.SCALE_SMOOTH));
			}
		}
		return images;
	}
	
	public Piece[][] getBoard() {
		return board;
	}
}
