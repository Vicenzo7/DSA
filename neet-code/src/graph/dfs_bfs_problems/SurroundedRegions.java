package graph.dfs_bfs_problems;

import java.util.Arrays;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    //We will use boundary DFS to solve this problem

    // Let's analyze when an 'O' cannot be flipped,
    // if it has at-least one 'O' in its adjacent, AND ultimately this chain of adjacent 'O's is connected to some 'O' which lies on boundary of board

    //consider these two cases for clarity :
      /*
        O's won't be flipped          O's will be flipped
        [X O X X X]                   [X X X X X]
        [X O O O X]                   [X O O O X]
        [X O X X X]                   [X O X X X]
        [X X X X X]                   [X X X X X]

      So we can conclude if a chain of adjacent O's is connected some O on boundary then they cannot be flipped

      */

    //Steps to Solve :
    //1. Move over the boundary of board, and find O's
    //2. Every time we find an O, perform DFS from its position
    //3. In DFS convert all 'O' to '#'      why?? so that we can differentiate which 'O' can be flipped and which cannot be
    //4. After all DFSs have been performed, board contains three elements,#,O and X
    //5. 'O' are left over elements which are not connected to any boundary O, so flip them to 'X'
    //6. '#' are elements which cannot be flipped to 'X', so flip them back to 'O'


    static int ROWS = 0;
    static int COLS = 0;

    public static void solve(char[][] board) {

        ROWS = board.length;
        COLS = board[0].length;

        boolean[][] visit = new boolean[ROWS][COLS];
        //  top and bottom boundary dfs
        for (int col = 0; col < COLS; col++) {
            if (board[0][col] == 'O') {
                dfs(0, col, board, visit);
            }
            if (board[ROWS - 1][col] == 'O') {
                dfs(ROWS - 1, col, board, visit);
            }
        }

        // left and right boundary dfs
        for (int row = 0; row < ROWS; row++) {
            if (board[row][0] == 'O') {
                dfs(row, 0, board, visit);
            }
            if (board[row][COLS - 1] == 'O') {
                dfs(row, COLS - 1, board, visit);
            }
        }

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (board[row][col] == '#') {
                    board[row][col] = 'O';
                } else if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
            }
        }
        System.out.println();
    }

    private static void dfs(int row, int col, char[][] board, boolean[][] visit) {
        if (Math.min(row, col) < 0 || row == ROWS || col == COLS || visit[row][col] ||
                board[row][col] == 'X') {
            return;
        }


        visit[row][col] = true;
        board[row][col] = '#';
        dfs(row, col - 1, board, visit);
        dfs(row, col + 1, board, visit);
        dfs(row - 1, col, board, visit);
        dfs(row + 1, col, board, visit);
    }
}
