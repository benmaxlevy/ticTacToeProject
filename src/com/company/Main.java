package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ticTacToeBoard board = new ticTacToeBoard();
        board.addValue(board.getTurn(), 0, 1);
        Scanner userInput = new Scanner(System.in);
        System.out.print()
        Integer userRow = userInput.nextInt();
        board.addValue(board.getTurn(), 0, 1);
        board.printBoard();
        System.out.println(board.winner());
    }
}