package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                board[row][col] = '.';
            }
        }

        List<List<String>> result = new ArrayList<>();
//        boolean[] colOccupied = new boolean[n];
//        dfs(0, n, board, colOccupied, result);


        Set<Integer> colOccupied = new HashSet<>();
        Set<Integer> up_leftDiagonal = new HashSet<>(); // row - col
        Set<Integer> up_rightDiagonal = new HashSet<>(); // row + col

        dfs_Optimised(0, n, board, colOccupied, up_leftDiagonal, up_rightDiagonal, result);
        return result;
    }

    private static void dfs_Optimised(int row, int n, char[][] board, Set<Integer> colOccupied, Set<Integer> upLeftDiagonal, Set<Integer> upRightDiagonal, List<List<String>> result) {
        if (row == n) {
            addAns(board, result);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (colOccupied.contains(col) || upLeftDiagonal.contains(row - col) || upRightDiagonal.contains(row + col)) {
                continue; // queen already placed here
            }

            colOccupied.add(col);
            upLeftDiagonal.add(row - col);
            upRightDiagonal.add(row + col);
            board[row][col] = 'Q';

            dfs_Optimised(row + 1, n, board, colOccupied, upLeftDiagonal, upRightDiagonal, result);

            // backtrack
            colOccupied.remove(col);
            upLeftDiagonal.remove(row - col);
            upRightDiagonal.remove(row + col);
            board[row][col] = '.';
        }
    }



    /*
        The queen moves in 8 direct up, down,left,right,up-left diagonal,up-right diagonal
        down-left diagonal,down-right-diagonal.

        To check if the queen can be place or not we just have to check if a queen already exist
        at up-left and up-right diagonal. The left direct is checked using a rowOccupied array, and we don't need to check
        up directions because we are moving a column forward every time.

         down,right,down-left diagonal,down-right-diagonal are not needed to be checked as we are moving from top to bottom.

        But int the below problem we need to iterate to check if queen exist how can we reduce that thing using sets.
    */

    private static void dfs(int row, int n, char[][] board, boolean[] colOccupied, List<List<String>> result) {
        if (row == n) {
            addAns(board, result);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!colOccupied[col] && isSafe(row, col, n, board)) {
                board[row][col] = 'Q';
                colOccupied[col] = true;
                dfs(row + 1, n, board, colOccupied, result);
                board[row][col] = '.';
                colOccupied[col] = false;
            }
        }
    }

    private static boolean isSafe(int row, int col, int n, char[][] board) {
        int x, y;


//         Checking in the left direction
//        for (y = 0; y < col; y++) {
//            if (board[row][y] == 'Q') {
//                return false;
//            }
//        }

        // Checking in the leftmost diagonal
        for (x = row, y = col; x >= 0 && y >= 0; x--, y--) {
            if (board[x][y] == 'Q') {
                return false;
            }
        }

        // Checking in the rightmost diagonal
        for (x = row, y = col; x >= 0 && y < n; x--, y++) {
            if (board[x][y] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private static void addAns(char[][] board, List<List<String>> result) {
        List<String> ans = new ArrayList<>();
        for (char[] chars : board) {
            String s = String.valueOf(chars);
            ans.add(s);
        }
        result.add(ans);
    }

}
