package Model;

public class Board {
   public int size;
   public PeiceType[][] board;

   public Board(int size)
   {
       this.size=size;
       this.board= new PeiceType[size][size];
   }

public boolean addPeice(int row, int column, PeiceType p)
   {
       if(row<0 || row>=size ||column <0 ||column >=size ||board[row][column]!=null )
           return false;
       // if selected
       board[row][column] = p;
       return true;
   }

public void printBoard()
   {
       for(int i=0;i<size;i++)
       {
           for(int j=0;j<size;j++)
           {
               if(this.board[i][j]!=null)
               System.out.print(this.board[i][j] + " ");
               else System.out.print("_ ");
           }
           System.out.println();
       }
   }


}
