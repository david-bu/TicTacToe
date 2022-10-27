public class TicTacToe {

    public static void main(String[] args) {
        char[][] board = {
                {'x', ' ', 'o'},
                {' ', 'o', ' '},
                {'x', 'x', 'x'}
        };

        CheckWin(board);
    }

    /**
     *  Prüft, ob auf dem Board ein Gewinner existiert, falls das Layout korrekt ist und gibt diesen dann auf der
     *  Standardkonsole aus.
     *
     * @param board TicTacToe Board, bei dem ein Gewinner ermittelt werden soll
     */
    public static void CheckWin(char[][] board)
    {
        if (!checkBoardLayoutIsCorrect(board)) {
            System.out.println("Board layout is wrong!");
            return;
        }

        boolean xSieger, oSieger;
        oSieger = checkRows(board, 'o') || checkColumns(board, 'o') || checkDiagonals(board, 'o');
        xSieger = checkRows(board, 'x') || checkColumns(board, 'x') || checkDiagonals(board, 'x');

        if (xSieger && oSieger)
            System.out.println("Dieses Spielfeld kann im Spiel nicht entstehen! Es wären beide Sieger.");
        if (!xSieger && !oSieger)
            System.out.println("Kein Spieler hat gewonnen.");
        if (xSieger && !oSieger)
            System.out.println("Spieler x hat gewonnen.");
        if (oSieger && !xSieger)
            System.out.println("Spieler o hat gewonnen.");
    }

    /**
     * Prüft, ob der Spieler in mindestens einer Zeile gewonnen hat.
     *
     * @param board TicTacToe Board mit char[3][3], bei dem alle Felder anzeigen, ob und welcher Spieler
     *              sich darauf befindet
     * @param player Char vom Spieler, dessen Sieg getestet werden soll
     * @return true, wenn in mindestens einer Zeile der Spieler alle Felder markiert hat
     */
    public static boolean checkRows(char[][] board, char player) {
        for (int i = 0; i < 3; i++)
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;

        return false;
    }

    /**
     * Prüft, ob der Spieler in mindestens einer Spalte gewonnen hat.
     *
     * @param board TicTacToe Board mit char[3][3], bei dem alle Felder anzeigen, ob und welcher Spieler
     *              sich darauf befindet
     * @param player Char vom Spieler, dessen Sieg getestet werden soll
     * @return true, wenn in mindestens einer Spalte der Spieler alle Felder markiert hat
     */
    public static boolean checkColumns(char[][] board, char player) {
        for (int i = 0; i < 3; i++)
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                return true;

        return false;
    }

    /**
     * Prüft, ob der Spieler in einer der beiden Diagonalen gewonnen hat.
     *
     * @param board TicTacToe Board mit char[3][3], bei dem alle Felder anzeigen, ob und welcher Spieler
     *              sich darauf befindet
     * @param player Char vom Spieler, dessen Sieg getestet werden soll
     * @return true, wenn in mindestens einer Diagonalen der Spieler alle Felder markiert hat
     */
    public static boolean checkDiagonals(char[][] board, char player) {
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;

        return false;
    }

    /**
     * Prüft, ob das Board dem benötigten Layout entspricht.
     * Anordnung der Felder:
     * {
     *     { 0, 1, 2},
     *     { 3, 4, 5},
     *     { 6, 7, 8}
     * }
     * entspricht:
     * _______
     * |1|2|3|
     * -------
     * |4|5|6|
     * -------
     * |7|8|9|
     * -------
     * Dabei stehen anstatt der Ziffern Chars für die Spieler: entweder 'x' oder 'o'; oder ' ' für ein leeres Feld
     *
     * @param board TicTacToe Board, dessen Layout geprüft werden soll
     * @return true, wenn das Layout korrekt ist, sonst false
     */
    public static boolean checkBoardLayoutIsCorrect(char[][] board) {
        return (board != null && board.length == 3
                && board[0] != null && board[0].length == 3
                && board[1] != null && board[1].length == 3
                && board[2] != null && board[2].length == 3);
    }

}