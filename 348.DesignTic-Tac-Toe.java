class TicTacToe {
    int n;
    int[][] rows;
    int[][] cols;
    int[][] diag;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
       this.n = n;
       rows = new int[3][n];
       cols = new int[3][n];
       diag = new int[3][2];
    }

    public int move(int row, int col, int player) {
        if(++rows[player][row] == n) return player;
        if(++cols[player][col] == n) return player;
        if(row == col && ++diag[player][0] == n) return player;
        if(row + col == n - 1 && ++diag[player][1] == n) return player;
        return 0;
    }
}
