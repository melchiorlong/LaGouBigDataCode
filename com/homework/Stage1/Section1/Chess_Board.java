package com.homework.Stage1.Section1;

public class Chess_Board {

//    使用双重循环实现五子棋游戏棋盘的绘制棋盘界面
//
// 解题思路
// 1、看图确定为二维数组
// 2、将坐标行列与中间“+”剥离，分别处理
// 3、因坐标非正整数，所以新增坐标数组，以便后期处理
// 4、二位数组将棋盘中心部分确定
// 5、打印部分添加坐标，并打印棋盘中心部分

    // 新增棋盘二维数组、坐标数组、棋盘边长
    private String[][] chess_board;
    private String[] str = new String[]{"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
    private final int size = str.length;

    public void setChess_board() {
        // 初始化棋盘中心二维数组
        chess_board = new String[size][size];
        // 用“+”填充
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                chess_board[i][j] = "+";
            }
        }
    }

    private void print(){
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
        // 实例化
        Chess_Board chessboard = new Chess_Board();
        chessboard.setChess_board();
        chessboard.print();
    }
}
