package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Welcome to tic tac toe! Press 1 for easy mode. Press 2 for hard");
        int difficulty = userInput.nextInt();
        ticTacToeBoard board = new ticTacToeBoard();
        int aiRow = -1, aiColumn = -1;

        while(board.winner() != 1 || board.winner() != 2){
            System.out.print("What row?");
            int userRow = userInput.nextInt();
            System.out.print("What Column?");
            int userColumn = userInput.nextInt();
            board.addValue(board.getTurn(), userColumn, userRow);
            board.printBoard();
            if(difficulty == 1){
                aiRow = (int) (Math.random() * 3);
                aiColumn = (int) (Math.random() * 3);
                while(board.getValue(aiRow, aiColumn) != 0) {
                    aiRow = (int) (Math.random() * 3);
                    aiColumn = (int) (Math.random() * 3);
                }

                board.addValue(board.getTurn(), aiRow, aiColumn);
            }
        }
        System.out.println(board.winner());

    }
}