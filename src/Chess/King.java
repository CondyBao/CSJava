package Chess;

import java.awt.*;
import java.util.ArrayList;

public class King extends Piece{

    private int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}}; // all the possible directions a king can move towards

    public King(int turn, Image img) {
        super(turn, img);
    } // super constructor

    @Override
    public ArrayList<int[]> getMoves(Board board, int r, int c) {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        for (int i = 0; i < 8; i++) { // check all the directions
            int newr = r + directions[i][0], newc = c + directions[i][1]; // get the new coordinates
            if (newr < 0 || newc < 0 || newr > 7 || newc > 7) { // if out of bounds continue
                continue;
            }
            if (board.getBoard()[newr][newc].getTeam() == this.getTeam()) continue; // if the new coordinates belong to a piece from the same team
            moves.add(new int[]{newr, newc}); // add the new move to the moves arraylist
        }
        return moves; // return the moves
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean check(int kingr, int kingc, int r, int c, Board board) {
        return false;
    } // a king cannot put the other king in check
}
