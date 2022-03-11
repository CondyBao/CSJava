package Chess;

import java.awt.*;
import java.util.ArrayList;

public class Knight extends Piece {

    private int[][] directions = new int[][]{{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, -1}, {2, 1}, {-2, 1}, {-2, -1}}; // all the possible directions a knight can move towards

    public Knight(int turn, Image img) {
        super(turn, img);
    } // inheritance constructor

    @Override
    public ArrayList<int[]> getMoves(Board board, int r, int c) {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        for (int i = 0; i < 8; i++) { // check all the directions
            int newr = r + directions[i][0], newc = c + directions[i][1]; // get the new directions
            if (newr < 0 || newc < 0 || newr > 7 || newc > 7) { // check if the new coordinate is out of bounds
                continue;
            }
            if (board.getBoard()[newr][newc].getTeam() == this.getTeam()) continue; // check if thew new coordinates belong to a piece of the same team
            moves.add(new int[]{newr, newc}); // add the new move to the arraylist
        }
        return moves; // return all the moves
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean check(int kingr, int kingc, int r, int c, Board board) {
        ArrayList<int[]> moves = getMoves(board, r, c);
        boolean flag = false;
        for (int[] m : moves) {
            int newr = m[0], newc = m[1];
            if (newr == kingr && newc == kingc) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
