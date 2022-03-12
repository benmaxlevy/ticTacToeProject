package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to tic tac toe! Press 1 for easy mode. Press 2 for hard");
        int difficulty = userInput.nextInt();
        ticTacToeBoard board = new ticTacToeBoard();
        int aiRow = -1, aiColumn = -1;

        while(true){
            System.out.println("What row?");
            int userRow = userInput.nextInt();
            System.out.println("What Column?");
            int userColumn = userInput.nextInt();
            board.addValue(1, userRow, userColumn);
            board.printBoard();
            //check for winner
            if(board.winner() == 1){
                System.out.println("You win!");
                break;
            }
            if(difficulty == 1){
                aiRow = (int) (Math.random() * 3);
                aiColumn = (int) (Math.random() * 3);
                while(board.getValue(aiRow, aiColumn) != 0) {
                    aiRow = (int) (Math.random() * 3);
                    aiColumn = (int) (Math.random() * 3);
                }

                board.addValue(2, aiRow, aiColumn);
                System.out.println("AI's turn");
                board.printBoard();
                //check for winner
                if(board.winner() == 2){
                    System.out.println("AI wins!");
                    break;
                }
            }
            
            // else if(difficulty == 2) {

            //     board.executeBest(2);
            //     System.out.println("AI's turn");
            //     board.printBoard();
            //     //check for winner
            //     if(board.winner() == 2){
            //         System.out.println("AI wins!");
            //         break;
            //     }
            // }
        }
    }
}