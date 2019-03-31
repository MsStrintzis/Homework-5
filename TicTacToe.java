
package tictactoe;
import java.util.Scanner ;

public class TicTacToe {
    public static void mark_update (String[] board,int mark_place ,String mark){
        for (int i = 1 ; i < 10 ; i++) {
            if (i == mark_place) {
                board[i] = mark ;
                break ;
               }
        }
        
    }     
  
    
    public static void board_update (String[] board) {
       
        /*        |         |           
         *     1  |     2   |   3
         *        |         |
         * -------|---------|-------
         *        |         |
         *     4  |     5   |   6
         *        |         |
         * -------|---------|-------
         *        |         |
         *     7  |    8    |   9
         *        |         |
         */
        //Board Print
 
     {       //Board Updater with the array
        System.out.println("       |         |       ") ;
        System.out.println("   "+board[1]+"   |    "+board[2]+"    |   "+board[3]+"   ") ;
        System.out.println("       |         |       ") ;
        System.out.println("-------|---------|-------") ;
        System.out.println("       |         |       ") ;
        System.out.println("   "+board[4]+"   |    "+board[5]+"    |   "+board[6]+"   ") ;
        System.out.println("       |         |       ") ;
        System.out.println("-------|---------|-------") ;
        System.out.println("       |         |       ") ;
        System.out.println("   "+board[7]+"   |    "+board[8]+"    |   "+board[9]+"   ") ;
        System.out.println("       |         |       ") ;
      }
     
    }
    
    public static void main(String[] args) {
        int player_Mark ;
        String[] board = new String[10] ;
        
        for (int i = 0 ; i < 10 ; i++) { // Fill the array with 1-9 for display purposes
            board[i] =String.valueOf(i) ;
         
       }
        //Intro message 
         
       
        System.out.println("Welcome to Tic-Tac-Toe !") ;
        System.out.println("Rules : \n 1.Place your mark on the coresponding number of the board cell "
                         + "\n 2.Win when you have a straight or diagonal lane crossed with your marks ") ;
        System.out.println("Choose which is Player X or Player O. X always goes first.\n") ;
        
        
        Scanner in = new Scanner(System.in) ;
        board_update(board) ;
            
       for (int i = 1 ; i < 10 ; i++) {                     
            if (i ==1 || i == 3 || i == 5 || i== 7 || i ==9) {  //Player X plays
            System.out.println("X player choose where you will mark your spot :\n") ;
            player_Mark = in.nextInt() ;
            
            do {
             if (player_Mark <= 0 || player_Mark >=10) {    //Check if the user inputs a valid mark
                System.err.println("The mark is out of bounds please choose again") ;
                player_Mark = in.nextInt() ;
            }        
            }while (player_Mark <= 0 || player_Mark >=10) ;
            
            String mark_X = "X";
          while("X".equals(board[player_Mark]) || "O".equals(board[player_Mark]) ) {
                System.err.println("The cell is already taken choose another") ;
                player_Mark = in.nextInt() ;
            }
            mark_update(board , player_Mark ,mark_X) ; 
            board_update(board) ;       //Update the board to the new conditions
           
            }
            
            else {  //Player O plays
           System.out.println("O player choose where you will mark your spot :\n") ;
            
            player_Mark = in.nextInt() ;
            
            do {
             if (player_Mark <= 0 || player_Mark >=10) {    //Check if the user inputs a valid mark
                System.err.println("The mark is out of bounds please choose again") ;
                player_Mark = in.nextInt() ;
            }        
            }while (player_Mark <= 0 || player_Mark >=10) ;
            
            String mark_O = "O";
           while ("X".equals(board[player_Mark]) || "O".equals(board[player_Mark]) ) {
                System.err.println("The cell is already taken choose another") ;
                player_Mark = in.nextInt() ;
                }
           mark_update(board , player_Mark ,mark_O) ; 
          
            board_update(board) ;       //Update the board to the new condtions
            
            }
             for (int j= 1 ; j < 9 ; j++) {       //Win condition
               if ((board[j].equals(board[j+1]) && board[j].equals(board[j+2])) ) {
                   System.out.println("Player " + board[j] + " has Won !! ") ;
                   return ;
                   
                   
               }
               else if (board[1].equals(board[5]) && board[1].equals(board[9])) {
                   System.out.println("Player " + board[j] + " has Won !! ") ;
                   break;
                   
               }
               else if(board[3].equals(board[5]) && board[3].equals(board[7])){
                   System.out.println("Player " + board[j] + " has Won !! ") ;
                   break ;
               }
               
              }         
       }}}
    

    
            
            



