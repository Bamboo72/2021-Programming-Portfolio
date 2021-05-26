/**
 * This project prints the starting positions for a chess board.
 * 
 * @author Jacob Schwartz
 * @version 1.0
 * @since 2020-11-18
 */

public class ChessBoard {
    static String[][] board = new String[8][8];

    static public void startPosition(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                board[i][j] = "";
            }
        }
        
        // • = black, ○ = white (If you are using a dark theme it will be reversed)
        
        // Rooks
        board[0][0] = "• Rook •  ";
        board[0][7] = "• Rook •  ";
        board[7][0] = "○ Rook ○  ";
        board[7][7] = "○ Rook ○  ";
        // Knights
        board[0][1] = "• Knight • ";
        board[0][6] = "• Knight • ";
        board[7][1] = "○ Knight ○ ";
        board[7][6] = "○ Knight ○ ";
        // Bishops
        board[0][2] = "• Bishop • ";
        board[0][5] = "• Bishop • ";
        board[7][2] = "○ Bishop ○ ";
        board[7][5] = "○ Bishop ○ ";
        // Kings and Queens
        board[0][3] = "• Queen • ";
        board[0][4] = "• King •  ";
        board[7][3] = "○ Queen ○ ";
        board[7][4] = "○ King ○  ";

        // Pawns
        for(int i = 0; i < 8; i++){
            board[1][i] = "• Pawn •  ";
            board[6][i] = "○ Pawn ○  ";
        }

    }

// ┌ ┬ ┐
// ├ ┼ ┤
// └ ┴ ┘
// |│ ─
    static public void printBoard(){
        System.out.println("KEY:\n• = black, ○ = white (If you are using a dark theme it will be reversed)");
        System.out.println("┌────────────┬────────────┬────────────┬────────────┬────────────┬────────────┬────────────┬────────────┐");
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                System.out.printf("│%12s", board[i][j]);
            }
            System.out.println("│");
            if(i<=6){
                System.out.println("├────────────┼────────────┼────────────┼────────────┼────────────┼────────────┼────────────┼────────────┤");
            }
            
        }
        System.out.println("└────────────┴────────────┴────────────┴────────────┴────────────┴────────────┴────────────┴────────────┘");
    }

    public static void main(String[] args){
        
    

        startPosition();
        printBoard();
    }
}
