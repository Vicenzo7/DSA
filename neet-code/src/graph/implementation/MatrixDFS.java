package graph.implementation;

public class MatrixDFS {

    /*
        Q. Count the unique path from top left to bottom right. A single path may only move
        along 0's and can't visit the same cell more than once.
    */


    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 0}
        };
        System.out.println(dfs(grid, 0, 0, new int[grid.length][grid[0].length]));
    }

    // count paths
    // TC = 4^(height of tree) height of tree = (row.col)
    // sc = O(row.col)
    public static int dfs(int[][] grid, int row, int col, int[][] visit) {
        int ROWS = grid.length, COLS = grid[0].length;

        if (Math.min(row, col) < 0 || row == ROWS || col == COLS ||
                visit[row][col] == 1 || grid[row][col] == 1) {
            return 0;
        }

        // check if reached the target
        if (row == ROWS - 1 && col == COLS - 1) {
            return 1;
        }

        visit[row][col] = 1;

        int count = 0;
        count += dfs(grid, row, col - 1, visit); // left
        count += dfs(grid, row, col + 1, visit); // right
        count += dfs(grid, row - 1, col, visit); // up
        count += dfs(grid, row + 1, col, visit); // down

        visit[row][col] = 0;
        return count;
    }
}
