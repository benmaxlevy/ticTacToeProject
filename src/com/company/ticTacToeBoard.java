package com.company;

public class ticTacToeBoard {
    //private vars
    private int[][] board;
    private int turn;
    private int winner;

    //players: 1 and 2
    //

    //constructor
    public ticTacToeBoard() {
        board = new int[3][3];
        turn = 0;
        winner = -1;
    }

    //get board
    public int[][] getBoard() {
        return this.board;
    }

    //print board
    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            if (i != 0)
                System.out.println("---------");
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0)
                    System.out.print(" ");
                else if(board[i][j] == 1)
                    System.out.print("O");
                else if(board[i][j] == 2)
                    System.out.print("X");
                if (j != 2)
                    System.out.print(" | ");
            }
            System.out.println();
        }
    }

    //add value to board
    public void addValue(int player, int x, int y) {
        board[x][y] = player;
        if (turn == 1)
            turn = 2;
        else
            turn = 1;
    }

    //get turn
    public int getTurn() {
        return this.turn;
    }

    //calculate winner and return value of winner
    public int winner() {
        int overall1 = 0;
        int overall2 = 0;
        //check board for three in a row, column, or diagonal
        //check rows
        for(int[] r: board) {
            for (int p : r)
                //check for three in a row
                if (p == 1)
                    overall1++;
                else if (p == 2)
                    overall2++;
            if(overall1 == 3)
                return 1;
            else if(overall2 == 3)
                return 2;
            else
                //tie
                return -1;
        }

        return -1;
    }
}
