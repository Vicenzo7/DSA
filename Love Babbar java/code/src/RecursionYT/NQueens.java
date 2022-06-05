package RecursionYT;
//https://www.codingninjas.com/codestudio/problems/n-queens_759332?leftPanelTab=0
//https://leetcode.com/problems/n-queens/

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }

    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {

        //create board
        int[][] board = new int[n][n];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        solve(0, board, ans, n);

        return ans;
    }

    private static void solve(int col, int[][] board, ArrayList<ArrayList<Integer>> ans, int n) {

        //base case
        if (col == n) {
            addSolution(ans, board, n);
            return;
        }

        //solve one case rest recursion wil take care of
        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board, n)) {
                // if placing queen is safe
                board[row][col] = 1;
                solve(col + 1, board, ans, n);
                //backtracking
                board[row][col] = 0;
            }
        }
    }

    private static boolean isSafe(int row, int col, int[][] board, int n) {

        int x = row;
        int y = col;

        //check for row
        while (y >= 0) {
            if (board[x][y] == 1)
                return false;

            y--;
        }

        //check for diagonals
        //first diagonal
        x = row;
        y = col;
        while (x >= 0 && y >= 0) {
            if (board[x][y] == 1)
                return false;

            x--;
            y--;
        }

        //second diagonal
        x = row;
        y = col;
        while (x < n && y >= 0) {
            if (board[x][y] == 1)
                return false;

            x++;
            y--;
        }
        return true;
    }

    private static void addSolution(ArrayList<ArrayList<Integer>> ans, int[][] board, int n) {

        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp.add(board[i][j]);
            }
        }
        ans.add(temp);
    }

}
