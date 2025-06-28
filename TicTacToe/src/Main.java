import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int playerCount = scanner.nextInt(); // Read integer input
        System.out.print("Enter size of your board ");
        int boardSize = scanner.nextInt(); // Read integer input
        TicTacToe game=new TicTacToe(playerCount,boardSize);
        System.out.print("Let's begin All the Best Guyss !!!");
        game.StartGame();
    }
}