package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to tic tac toe!");
        ticTacToeBoard board = new ticTacToeBoard();
        int aiRow = -1, aiColumn = -1;

        while(true){
            if(board.isFull()) {
                System.out.println("The game is a draw!");
                break;
            }

            System.out.println("What row?");
            int userRow = userInput.nextInt();
            System.out.println("What Column?");
            int userColumn = userInput.nextInt();
            while(board.getValue(userRow, userColumn) != 0) {
                System.out.println("That spot is filled. Try again.");
                System.out.println("What row?");
                userRow = userInput.nextInt();
                System.out.println("What Column?");
                userColumn = userInput.nextInt();
            }
            board.addValue(1, userRow, userColumn);

            if(board.isFull()) {
                System.out.println("The game is a draw!");
                break;
            }

            board.printBoard();
            //check for winner
            if(board.winner() == 1){
                System.out.println("You win!");
                break;
            }
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
        System.out.println("Game over.");
    }
}