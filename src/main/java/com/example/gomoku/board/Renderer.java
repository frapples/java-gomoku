package com.example.gomoku.board;

import com.example.gomoku.enums.CellState;
import java.io.PrintStream;

/**
 * @author Frapples <isfrapples@outlook.com>
 * @date 2019/6/22
 */
public class Renderer {

    public void render(Checkerboard board, PrintStream out) {
        for (int i = 0; i < board.getRow(); i++) {
            out.println(drawLine(i, board.getRow(), board.getCol()));
            for (int j = 0; j < board.getCol(); j++) {
                if (j == 0) {
                    out.print("|");
                }
                CellState s = board.getState(i, j);

                String c;
                switch (s) {
                    case WHITE_PLACED:
                        c = "○";
                        break;
                    case BLACK_PLACED:
                        c = "●";
                        break;
                    case EMPTY:
                        c = " ";
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + s);
                }
                out.print(" " + c + " " + "|");
            }
            out.println();
        }
        out.println(drawLine(board.getRow(), board.getRow(), board.getCol()));
    }

    private String drawLine(int i, int row, int col) {
        StringBuilder s = new StringBuilder();
        for (int j = 0; j <= col; j++) {
            if (i == 0) {
                if (j == 0) {
                    s.append("┏").append("---");
                } else if (j == col) {
                    s.append("┓");
                } else {
                    s.append("┳").append("---");
                }
            } else if (i == row) {
                if (j == 0) {
                    s.append("┗").append("---");
                } else if (j == col) {
                    s.append("┛");
                } else {
                    s.append("┷").append("---");
                }
            } else {
                if (j == 0) {
                    s.append("┠").append("---");
                } else if (j == col) {
                    s.append("┨");
                } else {
                    s.append("┼").append("---");
                }
            }
        }
        return s.toString();
    }

}
