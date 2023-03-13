package com.ticTacToe;

import java.util.Scanner;
public class TicTacToe {
    static Scanner sc = new Scanner(System.in);
    static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    static int turn = 0;

    public static void main(String[] args) {
        printBoard();
        while (true) {
            turn++;
            int row, col;
            do {
                System.out.print("Enter row for " + (turn % 2 == 1 ? "X" : "O") + " and press ENTER " + " : ");
                row = sc.nextInt() - 1;
                System.out.print("Enter column for " + (turn % 2 == 1 ? "X" : "O") + " and press ENTER " + " : ");
                col = sc.nextInt() - 1;
            } while (!isValid(row, col));
            board[row][col] = turn % 2 == 1 ? 'X' : 'O';
            printBoard();
            if (isWinning(row, col)) {
                System.out.println((turn % 2 == 1 ? "X" : "O") + " wins!");
                break;
            } else if (turn == 9) {
                System.out.println("Draw.");
                break;
            }
        }
    }

    static boolean isValid(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
            return true;
        }
        System.out.println("Invalid move, try again.");
        return false;
    }

    static boolean isWinning(int row, int col) {
        return (board[0][col] == board[1][col] && board[1][col] == board[2][col]) ||
                (board[row][0] == board[row][1] && board[row][1] == board[row][2]) ||
                (row == col && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                (row + col == 2 && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }

    static void printBoard() {
        System.out.println("  1  2  3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
