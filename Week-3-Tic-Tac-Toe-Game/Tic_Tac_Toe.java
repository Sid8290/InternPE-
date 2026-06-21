import java.util.Scanner;

public class TicTacToe {

    static char[][] board = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
    };

    static char currentPlayer = 'X';

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean gameEnded = false;

        System.out.println("=== TIC TAC TOE GAME ===");

        while (!gameEnded) {

            printBoard();

            System.out.print("Player " + currentPlayer + ", enter position (1-9): ");
            int position = sc.nextInt();

            if (!placeMove(position)) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            if (checkWinner()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                gameEnded = true;
            } else if (isBoardFull()) {
                printBoard();
                System.out.println("Game Draw!");
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        sc.close();
    }

    static void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) {
                System.out.println("--+---+--");
            }
        }
        System.out.println();
    }

    static boolean placeMove(int position) {

        int row = (position - 1) / 3;
        int col = (position - 1) % 3;

        if (position < 1 || position > 9) {
            return false;
        }

        if (board[row][col] == 'X' || board[row][col] == 'O') {
            return false;
        }

        board[row][col] = currentPlayer;
        return true;
    }

    static boolean checkWinner() {

        for (int i = 0; i < 3; i++) {

            if (board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]) {
                return true;
            }

            if (board[0][i] == board[1][i] &&
                board[1][i] == board[2][i]) {
                return true;
            }
        }

        if (board[0][0] == board[1][1] &&
            board[1][1] == board[2][2]) {
            return true;
        }

        return board[0][2] == board[1][1] &&
               board[1][1] == board[2][0];
    }

    static boolean isBoardFull() {

        for (char[] row : board) {
            for (char cell : row) {
                if (cell != 'X' && cell != 'O') {
                    return false;
                }
            }
        }
        return true;
    }
}
