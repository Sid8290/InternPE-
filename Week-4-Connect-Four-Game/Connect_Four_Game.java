import java.util.Scanner;
public class ConnectFour {
    static char[][] board = new char[6][7];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for(int i =0;i<6;i++){
            for(int j =0;j<7;j++){
                board[i][j]='.';
            }
        }
        char player = 'X';
        while(true){
            printBoard();
            System.out.print("Player"+player+",enter column (0-6):");
            int col = sc.nextInt();
            
            if (col<0||col>6) {
                System.out.println("Invalid Column!");
                continue;
            }
            if(!dropPiece(col,player)){
                System.out.println("Column is full!");
                continue;
            }
            if(checkWin(player)){
                printBoard();
                System.out.println("Player"+player+"wins!");
                break;
            }
            player = (player=='X')?'0':'X';
        }
        sc.close();
    }
    static void printBoard(){
        System.out.println();
        
for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("0 1 2 3 4 5 6");
    }
    static boolean dropPiece(int col, char player) {
        for (int i = 5; i >= 0; i--) {
            if (board[i][col] == '.') {
                board[i][col] = player;
                return true;
            }
        }
        return false;
    }
    static boolean checkWin(char p) {

        // Horizontal
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == p &&
                    board[i][j + 1] == p &&
                    board[i][j + 2] == p &&
                    board[i][j + 3] == p)
                    return true;
            }
        }

        // Vertical
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j] == p &&
                    board[i + 1][j] == p &&
                    board[i + 2][j] == p &&
                    board[i + 3][j] == p)
                    return true;
            }
        }

        // Diagonal (\)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == p &&
                    board[i + 1][j + 1] == p &&
                    board[i + 2][j + 2] == p &&
                    board[i + 3][j + 3] == p)
                    return true;
            }
        }

        // Diagonal (/)
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == p &&
                    board[i - 1][j + 1] == p &&
                    board[i - 2][j + 2] == p &&
                    board[i - 3][j + 3] == p)
                    return true;
            }
        }

        return false;
    }
}
