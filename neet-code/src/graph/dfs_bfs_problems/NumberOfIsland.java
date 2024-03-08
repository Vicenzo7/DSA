package graph.dfs_bfs_problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfIsland {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslandsBFS(grid2));
        System.out.println(numIslands(grid2));
    }


    // DFS
    public static int numIslands(char[][] grid) {
        int island = 0;
        int[][] visit = new int[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1' && visit[row][col] == 0) {
                    island++;
                    dfs(grid, row, col, visit);
                }
            }
        }

        return island;
    }

    private static void dfs(char[][] grid, int row, int col, int[][] visit) {
        int ROWS = grid.length, COLS = grid[0].length;

        if (Math.min(row, col) < 0 || row == ROWS || col == COLS || visit[row][col] == 1
                || grid[row][col] == '0') {
            return;
        }

        visit[row][col] = 1;
        dfs(grid, row, col - 1, visit); // left
        dfs(grid, row, col + 1, visit); // right
        dfs(grid, row - 1, col, visit); // up
        dfs(grid, row + 1, col, visit); // down
    }

    private static int numIslandsBFS(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[][] visit = new int[ROWS][COLS];
        int island = 0;

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                // is island and not visited
                if (grid[row][col] == '1' && visit[row][col] == 0) {
                    island += 1;
                    bfs(grid, row, col, visit);
                }
            }
        }

        return island;
    }

    private static void bfs(char[][] grid, int row, int col, int[][] visit) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{row, col});
        visit[row][col] = 1;

        while (!deque.isEmpty()) {
            int[] first = deque.removeFirst(); // if deque.removeLast then this becomes iterative dfs
            row = first[0];
            col = first[1];

            int[][] neighbors = {
                    {row, col - 1}, // left
                    {row, col + 1}, // right
                    {row - 1, col}, // up
                    {row + 1, col}, // down
            };

            for (int i = 0; i < 4; i++) {
                int newRow = neighbors[i][0];
                int newCol = neighbors[i][1];
                if (Math.min(newRow, newCol) < 0 || newRow == ROWS || newCol == COLS ||
                        visit[newRow][newCol] == 1 || grid[newRow][newCol] == '0') {
                    continue;
                }

                visit[newRow][newCol] = 1;
                deque.add(new int[]{newRow, newCol});
            }
        }
    }
}
