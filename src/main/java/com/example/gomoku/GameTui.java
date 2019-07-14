package com.example.gomoku;

import com.example.gomoku.board.Checkerboard;
import com.example.gomoku.board.Renderer;
import com.example.gomoku.enums.CellState;
import java.util.Scanner;

/**
 * @author Frapples <isfrapples@outlook.com>
 * @date 2019/6/22
 */
public class GameTui {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Renderer renderer = new Renderer();

        System.out.print("请输入棋盘大小: ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        Checkerboard board = new Checkerboard(row, col);
        renderer.render(board, System.out);
        System.out.printf("棋盘大小为%sx%s\n", row, col);

        boolean currentWhite = true;
        while (true) {
            System.out.printf("现轮到%s方，请输入落子坐标：", currentWhite ? "白" : "黑");
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            if (!board.isIn(i, j)) {
                System.out.print("错误，坐标超过了棋盘边界\n");
                continue;
            } else if (!board.getState(i, j).equals(CellState.EMPTY)) {
                System.out.print("错误，该处已有棋子\n");
                continue;
            }

            if (currentWhite) {
                board.placeWhite(i, j);
            } else {
                board.placeBlack(i, j);
            }
            renderer.render(board, System.out);

            if (board.isWin(i, j)) {
                System.out.printf("游戏结束，%s方胜利\n", currentWhite ? "白" : "黑");
                return;
            }

            currentWhite = !currentWhite;
        }
    }

    public static void main(String[] args) {
        new GameTui().start();
    }
}
