package Module;
import java.util.List;
import java.util.Random;

public class Board {
    public int boardSize;
   public int [][]board;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.board = new int[boardSize][boardSize];
    }

    public int  getBoardSize() {
        return this.boardSize;
    }
    public void setBoardSize(int boardSize) {}

    public void createBoard()
    {
        Random rand = new Random(System.currentTimeMillis());
        int[] options = {-1, 0, 1};
        int lo=0,hi=boardSize*boardSize - 1;

        System.out.println("Creating board with random snakes and ladders...");
        int snakes = 0, ladders = 0, normal = 0;

        for(int i=0;i<boardSize;i++)
        {
            for(int j=0;j<boardSize;j++)
            {
                int selected = options[rand.nextInt(3)];// Random index: 0, 1, or 2
                int value = i*boardSize + j;
                System.out.print("Selected: " + selected + " value: " + value + " ");
                if(selected==-1)
                {
                    board[i][j] = lo + rand.nextInt(value);
                }
                else if(selected==1)
                {
                    board[i][j] = value + rand.nextInt(hi-value+1);
                }
                else
                {
                    board[i][j] = value;
                    normal++;
                }
                System.out.print("board[i][j]: " + board[i][j] + "  ");
            }
            System.out.println();
        }

       
        
        System.out.println("Board created: " + snakes + " snakes, " + ladders + " ladders, " + normal + " normal cells");
    }

    public int cellValue(int cellValue)
    {
        if(cellValue > (boardSize * boardSize - 1))
        {
            return -1;
        }
        int row=cellValue / boardSize;
        int column=cellValue % boardSize;
        return board[row][column];
    }

    public void printBoard(List<Player> players) {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                int cellNumber = i * boardSize + j;
                StringBuilder cellDisplay = new StringBuilder(board[i][j] + ":");

                for (Player p : players) {
                    if (p.getScore() == cellNumber) {
                        cellDisplay.append("P").append(p.playerId);
                    }
                }
                System.out.print(cellDisplay + "\t");
            }
            System.out.println();
        }
    }

}
