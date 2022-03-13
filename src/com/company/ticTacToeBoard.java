package com.company;

public class ticTacToeBoard {
    //private vars
    private int[][] board;
    private int turn;
    //player 1 and 2: 1 is user, 2 is AI

    //constructor
    public ticTacToeBoard() {
        board = new int[3][3];
        turn = 0;
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
        if (this.turn == 1)
            this.turn = 2;
        else
            this.turn = 1;
    }

    //get turn
    public int getTurn() {
        return this.turn;
    }

    //calculate winner and return value of winner
    public int winner() {
        //loop through rows to find winner with 3 in a row
        for (int[] ints : board) {
            if (ints[0] == ints[1] && ints[1] == ints[2]) {
                if (ints[0] == 1)
                    return 1;
                else if (ints[0] == 2)
                    return 2;
            }
        }   

        //loop through columns to find winner with 3 in a column
        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if (board[0][i] == 1)
                    return 1;
                else if (board[0][i] == 2)
                    return 2;
            }
        }

        //check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] == 1)
                return 1;
            else if (board[0][0] == 2)
                return 2;
        }


        return -1;
    }

    //get value at coordinate
    public int getValue(int x, int y) {
        return board[x][y];
    }

    //check if board is filled
    public boolean isFull() {
        for (int[] ints : board) {
            for (int anInt : ints) {
                if (anInt == 0)
                    return false;
            }
        }
        return true;
    }
}
