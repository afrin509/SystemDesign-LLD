//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import Module.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome let's start our snake and ladder game");
        Board gameBoard = new Board(4);
        gameBoard.createBoard();
        System.out.println("Board has been created: Let's start the game choose number of players b/w 1 to 5");
        Scanner sc = new Scanner(System.in);
        int playerCount = sc.nextInt();
        GameManager gameManager = new GameManager(playerCount,gameBoard);
        gameManager.play();

    }
}