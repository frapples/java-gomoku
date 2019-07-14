package com.example.gomoku.board;

import com.example.gomoku.enums.CellState;

/**
 * @author Frapples <isfrapples@outlook.com>
 * @date 2019/6/22
 */
public class Checkerboard {

    private int row;
    private int col;

    private CellState[][] board;

    public Checkerboard(int row, int col) {
        this.row = row;
        this.col = col;
        this.board = new CellState[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = CellState.EMPTY;
            }
        }
    }

    public CellState getState(int i, int j) {
        return board[i][j];
    }

    public void placeWhite(int i, int j) {
        board[i][j] = CellState.WHITE_PLACED;
    }

    public void placeBlack(int i, int j) {
        board[i][j] = CellState.BLACK_PLACED;
    }

    public boolean isWin(int i, int j) {
        int a = countFor(i, j, 0, 1) + countFor(i, j, 0, -1);
        int b = countFor(i, j, 1, 0) + countFor(i, j, -1, 0);
        int c = countFor(i, j, 1, 1) + countFor(i, j, -1, -1);
        int d = countFor(i, j, 1, -1) + countFor(i, j, -1, 1);
        return a >= 4 || b >= 4 || c >= 4 || d >= 4;
    }

    private int countFor(int startI, int startJ, int rowStep, int colStep) {
        CellState s = getState(startI, startJ);

        int count = 0;
        for (int i = startI, j = startJ; ; i += rowStep, j += colStep) {
            if (!isIn(i, j) || !s.equals(getState(i, j))) {
                return count - 1;
            }
            count++;
        }
    }

    public boolean isIn(int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < col ;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
