package Module;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
    public List<Player> players;
    public int playerCount;
    public Board board;


    public GameManager(int playerCount, Board board)
    {
        this.playerCount = playerCount;
        this.players = new ArrayList<Player>(playerCount);
        this.board = board;
        int currentPlayerId = 0;

        while(playerCount-- > 0)
        {
            System.out.println("Please enter player details i.e Name");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            players.add(new Player(currentPlayerId, name,0));
            currentPlayerId++;
        }
    }

    public void play()
    {
       int playerId = 0;
//       boolean gameOver = false;

       while(true)
       {
           System.out.println("Below is the current board status");
           this.board.printBoard(this.players);
           int oldValue = players.get(playerId).getScore();
           int diceValue=this.chooseDice();
           int newValue = oldValue + diceValue;
           System.out.println("New Value in the cell for player" + playerId + ":" + newValue);
           int boardValue = this.board.cellValue(newValue);
           int boardSize = this.board.getBoardSize();
           if(boardValue == (boardSize*boardSize - 1))
           {
               String playerName = players.get(playerId).getName();
               System.out.println("Game Over :"+ playerName + " Won the game");
               break;
           }
           if (boardValue != -1)
           {
              players.get(playerId).setScore(boardValue);
           }
           System.out.println("Player "+playerId+" is complated playing & reached at : " + boardValue);
           playerId++;
           playerId%=playerCount;

       }
    }

    public int chooseDice()
    {
        System.out.println("Please enter a number between 1 and 6");
        Scanner sc = new Scanner(System.in);
        int diceValue = sc.nextInt();
        while(diceValue <1 || diceValue > 6)
        {
            System.out.println("Invalid input! Please enter a number between 1 and 6");
            diceValue = sc.nextInt();
        }
        return diceValue;
    }

}
