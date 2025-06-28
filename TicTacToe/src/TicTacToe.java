import java.util.*;


import Model.*;

public class TicTacToe {
    int playersCount;
    Queue<Player> playersTurn=new LinkedList<>() ;
    List<Player> players=new ArrayList<>();
    Board board;
    Set<PeiceType>choosenPeices=new HashSet<>();
    Scanner scanner = new Scanner(System.in);
    TicTacToe(int playersCount,int boardSize)
    {
        // scanner declared once
        this.board=new Board(boardSize);
         int currentPlayerCnt=0;
         while(currentPlayerCnt++ < playersCount) {
           System.out.println("Player:" + currentPlayerCnt + " Please Enter Your Name:");
           String currentPlayerName = scanner.nextLine();
           System.out.println("Kindly Choose available Peice Options");
           for (PeiceType peice : PeiceType.values()) {
               if (choosenPeices.isEmpty() || !choosenPeices.contains(peice)) {
                   System.out.println(peice);
               }
           }
           // Ask for piece input until valid
           PeiceType currentPlayerPeice = null;
           while (currentPlayerPeice == null) {
               System.out.println("Enter your piece from the available options (case-sensitive):");
               String input = scanner.nextLine().trim();

               try {
                   currentPlayerPeice = PeiceType.valueOf(input);
                   if (choosenPeices.contains(currentPlayerPeice)) {
                       System.out.println("That piece is already taken. Choose another.");
                       currentPlayerPeice = null; // reset
                   }
               } catch (IllegalArgumentException e) {
                   System.out.println("Invalid input. Please enter one of the displayed piece names.");
               }
           }

           choosenPeices.add(currentPlayerPeice);
           Player player = new Player(currentPlayerName, currentPlayerPeice);
           players.add(player);
           playersTurn.add(player);
       }
    }


    void announcePlayerTurn(Player p)
    {
        System.out.println(p.getName() + "please choose row and column");
    }
    boolean CheckAnyMatch(PeiceType piece,int row, int column) {
        int size = board.board.length;
        boolean allSame=true;

        // Row match

            for (int j = 0; j < size; j++) {
                if (board.board[row][j] != piece) {
                    allSame = false;
                    break;
                }
            }
            if (allSame) {
                System.out.println("Yeah Row is a match: " + (row));
                return true;
            }

           allSame=true;
        // Column match

            for (int i = 0; i < size; i++) {
                if (board.board[i][column] != piece) {
                    allSame = false;
                    break;
                }
            }
            if (allSame) {
                System.out.println("Yeah Column is a match: " + (column));
                return true;
            }


        // Diagonal top-left to bottom-right
        allSame = true;
        for (int i = 0; i < size; i++) {
            if (board.board[i][i] != piece) {
                allSame = false;
                break;
            }
        }
        if (allSame) {
            System.out.println("Yeah Diagonal (\\) is a match");
            return true;
        }

        // Diagonal top-right to bottom-left
        allSame = true;
        for (int i = 0; i < size; i++) {
            if (board.board[i][size - i - 1] != piece) {
                allSame = false;
                break;
            }
        }
        if (allSame) {
            System.out.println("Yeah Diagonal (/) is a match");
            return true;
        }

        return false;
    }

    boolean checkEmptyCellsAvailability()
    {
        int size = board.board.length;
        boolean cellEmpty=false;
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {
                if (board.board[i][j]==null) {
                   cellEmpty=true;
                    break;
                }
            }

        }
        return cellEmpty;
    }

    Move MakeMove(PeiceType p)
    {
        System.out.println("Please Enter Valid Moves by checking free row and columns");
        board.printBoard();

        System.out.println("Please Enter Valid Empty Row");
        Integer row = scanner.nextInt();
        System.out.println("Please Enter Valid Empty column");
        Integer column= scanner.nextInt();
        boolean success= board.addPeice(row,column,p);

        return new Move(row,column,p,success);

    }
    void StartGame()
    {
       while(true)
       {
           Player player=playersTurn.poll();
           announcePlayerTurn(player);
           PeiceType peice=player.getPeiceType();

           Move move=MakeMove(peice);

           while(!move.success)
           {
               System.out.println("Invalid Selection !!! Kindly Choose from the empty cells");
               move=MakeMove(peice);
           }

           boolean checkGameOver = CheckAnyMatch(peice,move.row,move.column);
           boolean isemptyCellAvailable=checkEmptyCellsAvailability();
           if(checkGameOver || !isemptyCellAvailable)
           {
               if(checkGameOver)
               System.out.print("Ohhooo !!! Player " + player.getName() + " Is Winner !!!" );
               else if(!isemptyCellAvailable) System.out.print("Ohhooo No !!! Game is draw" );
               break;
           }
           else
           {
               playersTurn.add(player);
           }

       }
    }



}
