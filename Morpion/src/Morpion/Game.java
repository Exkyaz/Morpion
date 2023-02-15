package Morpion;

public class Game {
    boolean isFinished;
    String Player1;
    String Player2;
    String[][] TicTacToe;

    public Game(String player1, String player2) {
        Player1 = player1;
        Player2 = player2;
        isFinished = false;
        TicTacToe = new String[3][3];
        for (int i=0; i<3; ++i) {
            for (int j = 0; j < 3; ++j) {
                assert false;
                TicTacToe[i][j] = " ";
            }
        }
    }
}
