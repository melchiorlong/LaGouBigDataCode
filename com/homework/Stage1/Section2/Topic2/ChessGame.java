package com.homework.Stage1.Section2.Topic2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2. 编程实现控制台版并支持两人对战的五子棋游戏。
 * （1）绘制棋盘 - 写一个成员方法实现
 * （2）提示黑方和白方分别下棋并重新绘制棋盘 - 写一个成员方法实现。
 * （3）每当一方下棋后判断是否获胜 - 写一个成员方法实现。
 * （4）提示： 采用二维数组来模拟并描述棋盘，棋盘如下：
 */
public class ChessGame {

    private final char white = '\u25CB';  // white = ○
    private final char black = '\u25CF';  // black = ●
    private boolean isFinished = false;



    public void getPoint(){

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("白方下棋，请出入横纵坐标（如：1 2）");
            String inx = sc.next();
            String iny = sc.next();
            int x = (int) Long.parseLong(inx, 16);
            int y = (int) Long.parseLong(iny, 16);
            System.out.println("x=" + x + ", y=" + y);
//            更新棋盘
//            判断是否胜利
        }while (isFinished);{
            System.out.println("结束了");

        }
    }

    public void update(int x, int y){

    }


    public static void main(String[] args) {
        // 绘制棋盘
        ChessGame cg = new ChessGame();
        ChessBoardCons cbc = new ChessBoardCons();
        cbc.generating();
        String[][] chess_board = cbc.getChess_board();
        // 提示黑方和白方分别下棋、重新绘制棋盘
        cg.getPoint();
    }
}
