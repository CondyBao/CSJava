package Chess;

import java.awt.*;
import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(int turn, Image img) {
        super(turn, img);
    }

    @Override
    public ArrayList<int[]> getMoves(Board board, int r, int c) {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        boolean eligibleF = true, eligibleB = true, eligibleF2 = true, eligibleB2 = true;
        for (int i = 1; i < 8; i++) { // check diagonals
            boolean temp1 = true, temp2 = true, temp3 = true, temp4 = true;
            int newr = r + i, newc = c + i, newbr = r - i, newbc = c - i;
            if (newr < 0 || newr > 7 || newc < 0 || newc > 7) temp1 = false;
            if (newbr < 0 || newbr > 7 || newbc < 0 || newbc > 7) temp2 = false;
            if (newr < 0 || newr > 7 || newbc < 0 || newbc > 7) temp3 = false;
            if (newbr < 0 || newbr > 7 || newc < 0 || newc > 7) temp4 = false;
            if (temp1 && board.getBoard()[newr][newc].getTeam() == this.getTeam()) eligibleF = false;
            if (temp2 && board.getBoard()[newbr][newbc].getTeam() == this.getTeam()) eligibleB = false;
            if (temp3 && board.getBoard()[newr][newbc].getTeam() == this.getTeam()) eligibleF2 = false;
            if (temp4 && board.getBoard()[newbr][newc].getTeam() == this.getTeam()) eligibleB2 = false;
            if (temp1 && eligibleF) {
                moves.add(new int[]{newr, newc});
                if (!board.getBoard()[newr][newc].isEmpty()) eligibleF = false;
            }
            if (temp2 && eligibleB) {
                moves.add(new int[]{newbr, newbc});
                if (!board.getBoard()[newbr][newbc].isEmpty()) eligibleB = false;
            }
            if (temp3 && eligibleF2) {
                moves.add(new int[]{newr, newbc});
                if (!board.getBoard()[newr][newbc].isEmpty()) eligibleF2 = false;
            }
            if (temp4 && eligibleB2) {
                moves.add(new int[]{newbr, newc});
                if (!board.getBoard()[newbr][newc].isEmpty()) eligibleB2 = false;
            }
        }
        return moves;
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
