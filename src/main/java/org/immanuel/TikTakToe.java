package org.immanuel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TikTakToe {

    Scanner scanner;
    private char player = 'X';
    private char player(char player) {
        return player == 'O' ? 'X' : 'O';
    }
    char[][] board;
    //creating the board
    public TikTakToe() {
        board = new char[3][3];
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '-';
            }
        }
    }

    //The moves
    int chances;
    int move1;
    int move2;

    //the start method
    public void startGame() {
        chances = 0;
        while (!gameOver()) {
            if (chances < 9) {
                play();
                chances++;
            } else {
                System.out.println("\n\nIts a Draw!!");
                break;
            }
        }
        printBoard();
    }

    //play method
    public void play() {
        printBoard();
        scanner = new Scanner(System.in);
        System.out.println("Player '" + player +"' Enter your move!");
        System.out.println("Enter first coordinate! Using the numbers on the edges!");
        try {
            move1 = scanner.nextInt();
        }
        catch (InputMismatchException imp) {
            System.out.println("Re-enter the move! Using the numbers on the edges!");
            play();
        }
        while (!(move1 > -1) || !(move1 <= 2)) {
            System.out.println("Re-enter the move! Using the numbers on the edges!");
            try {
                move1 = scanner.nextInt();
            }
            catch (InputMismatchException impl) {
                System.out.println("Game rules violated! \n Game Over!!");
                break;
            }
        }
        System.out.println("Enter second coordinate!  Using the numbers on the edges!");
        try {
            move2 = scanner.nextInt();
        }
        catch (InputMismatchException imp) {
            System.out.println("Re-enter the move! Using the numbers on the edges!");
            play();
        }
        while (!(move2 > -1) || !(move2 <= 2)) {
            System.out.println("Re-enter the move! Using the numbers on the edges!");
            try {
                move2 = scanner.nextInt();
            }
            catch (InputMismatchException impl) {
                System.out.println("Game rules violated! \n Game Over!!");
                break;
            }
        }
        if (checkForEmptyCells(move1, move2)) {
            board[move1][move2] = player;
        } else {
            System.out.println("Move already taken!!");
            play();
            player = player(player);
        }
        player = player(player);
    }
    //printing the board
    public void printBoard() {
        System.out.println("  0 | 1 | 2 ");
        System.out.println("0 " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("  --+---+--");
        System.out.println("1 " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("  --+---+--");
        System.out.println("2 " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }

    //logic for the game
    private boolean checkForEmptyCells(int move1, int move2) {
        return board[move1][move2] == '-';
    }
    //conclusion
    public boolean gameOver() {
        //rows
        if (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') {
            win();
            return true;
        }
        if (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') {
            win();
            return true;
        }
        if (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') {
            win();
            return true;
        }
        if (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') {
            win();
            return true;
        }
        if (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') {
            win();
            return true;
        }
        if (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') {
            win();
            return true;
        }

        //columns
        if (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') {
            win();
            return true;
        }
        if (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') {
            win();
            return true;
        }
        if (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') {
            win();
            return true;
        }
        if (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') {
            win();
            return true;
        }
        if (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') {
            win();
            return true;
        }
        if (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') {
            win();
            return true;
        }

        //the diagonals
        if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') {
            win();
            return true;
        }
        if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O') {
            win();
            return true;
        }
        if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
            win();
            return true;
        }
        if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') {
            win();
            return true;
        }
        return false;
    }

    private void win() {
        player = player == 'X' ? 'O' : 'X';
        System.out.println("\n\nPlayer '" + player + "' wins!!");
    }
}
