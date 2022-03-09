package Chess;

import java.awt.*;
import java.util.ArrayList;

public class Knight extends Piece {

    private int[][] directions = new int[][]{{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, -1}, {2, 1}, {-2, 1}, {-2, -1}};

    public Knight(int turn, Image img) {
        super(turn, img);
    }

    @Override
    public ArrayList<int[]> getMoves(Board board, int r, int c) {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        for (int i = 0; i < 8; i++) {
            int newr = r + directions[i][0], newc = c + directions[i][1];
            if (newr < 0 || newc < 0 || newr > 7 || newc > 7) {
                continue;
            }
            if (board.getBoard()[newr][newc].getTeam() == this.getTeam()) continue;
            moves.add(new int[]{newr, newc});
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
            int newr = r + m[0], newc = c + m[1];
            if (newr == kingr && newc == kingc) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
