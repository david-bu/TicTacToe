public class Main {

    public static void main(String[] args)
    {
        char[][] board = {
                {'x', ' ', 'o'},
                {'x', 'x', ' '},
                {'o', 'x', 'x'},
        };

        ZeigedenSieger(board);
    }

    public static boolean checkRows(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
        }

        return false;
    }

    public static boolean checkColumns(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                return true;
        }

        return false;
    }

    public static boolean checkDiagonals(char[][] board, char player) {
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;

        return false;
    }

    public  static void ZeigedenSieger(char[][] board)
    {
        boolean xSieger = false, oSieger = false;

        oSieger = checkRows(board, 'o') || checkColumns(board, 'o') || checkDiagonals(board, 'o');
        xSieger = checkRows(board, 'x') || checkColumns(board, 'x') || checkDiagonals(board, 'x');

        if (xSieger && oSieger)
        {
            System.out.println("Dieses Feld ist nicht nach den Regeln! Kein Spieler hat damit gewonnen.");
            return;
        }
        if (!xSieger && !oSieger)
        {
            System.out.println("Kein Spieler hat gewonnen");
            return;
        }

        if (xSieger)
            System.out.println("Spieler x hat gewonnen");
        if (oSieger)
            System.out.println("Spieler o hat gewonnen");
    }

}