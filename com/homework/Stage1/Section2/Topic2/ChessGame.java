package com.homework.Stage1.Section2.Topic2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 2. 编程实现控制台版并支持两人对战的五子棋游戏。
 * （1）绘制棋盘 - 写一个成员方法实现
 * （2）提示黑方和白方分别下棋并重新绘制棋盘 - 写一个成员方法实现。
 * （3）每当一方下棋后判断是否获胜 - 写一个成员方法实现。
 * （4）提示： 采用二维数组来模拟并描述棋盘，棋盘如下：
 */
public class ChessGame {

    private boolean isFinished = false;
    private int count = 0;
    private int winner = 0;
    private int whichOne = 1;
    private final int length = 16;
    private final String[] str = new String[length];
    private final int size = str.length;
    private final String[] edge = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public void start(String[][] chess_board) {

        List<String> edge_list = Arrays.asList(edge);
        do {
            System.out.println(count<=256?"":"和棋啦！");
            Scanner sc = new Scanner(System.in);
            System.out.println(whichOne > 0 ? "白方下棋，请出入横纵坐标（如：1 2）" : "黑方下棋，请出入横纵坐标（如：1 2）");
            String inx = sc.next();
            String iny = sc.next();
//            判断输入坐标是否越界
            if (!edge_list.contains(inx) || !edge_list.contains(iny)) {
                System.out.println("位置越界，请重新输入坐标");
                continue;
            }
            int x = (int) Long.parseLong(inx, 16);
            int y = (int) Long.parseLong(iny, 16);
//            判断输入坐标是否已经被使用
            if (!chess_board[x][y].equals("+")) {
                System.out.println("位置已经被使用，请重新输入坐标");
                continue;
            }
//          更新数组
            update(x, y, whichOne, chess_board);
//          交换对手
            whichOne *= -1;
//            打印棋盘
            insert();
            print(chess_board);

//          判断是否结束及胜者
            winner = whoIsWinner(chess_board);

        } while (isFinished);
        {
            System.out.println("结束了");
            if (winner == 0) {
                System.out.println("平局");
            } else if (winner > 0) {
                System.out.println("黑方胜利");
            } else {
                System.out.println("白方胜利");
            }

        }
    }


    /**
     * 更新棋盘，根据输入坐标更新二维数组元素值为white或black
     *
     * @param x
     * @param y
     */
    public void update(int x, int y, int whichOne, String[][] chess_board) {
        if (whichOne > 0) {
            // white = ○
            char white = '\u25CB';
            chess_board[x][y] = String.valueOf(white);
        } else {
            // black = ●
            char black = '\u25CF';
            chess_board[x][y] = String.valueOf(black);
        }
        count += 1;
    }

    /**
     * 判断胜负
     * winner：
     * 1：黑胜
     * 0：平局
     * -1：白胜
     *
     * @return
     */
    public int whoIsWinner(String[][] chess_board) {
        // 水平判断
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {






            }
        }

        isFinished = true;
        return 0;
    }

    private void insert() {
        for (int i = 0; i < size; i++) {
            str[i] = Integer.toHexString(i);
        }
    }

    private void print(String[][] chess_board) {
        // 打印图中左上角空格
        System.out.print(" ");
        // 循环打印坐标数组作为行坐标
        for (int i = 0; i < size; i++) {
            System.out.print("  " + str[i]);
        }
        // 换行
        System.out.println();

        // 双重for循环打印其余部分
        for (int i = 0; i < size; i++) {
            // 打印坐标数组作为列坐标
            System.out.print(str[i] + "  ");
            for (int j = 0; j < size; j++) {
                // 打印棋盘中心“+”
                System.out.print(chess_board[i][j] + "  ");
            }
            // 换行
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 绘制棋盘
        ChessGame cg = new ChessGame();
        ChessBoardCons cbc = new ChessBoardCons();
        cbc.generating();
        String[][] chess_board = cbc.getChess_board();
        // 提示黑方和白方分别下棋、重新绘制棋盘
        cg.start(chess_board);
    }
}
