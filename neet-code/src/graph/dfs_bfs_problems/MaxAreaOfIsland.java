package graph.dfs_bfs_problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        System.out.println(maxAreaOfIsland(grid));
        System.out.println(maxAreaOfIslandDFS(grid));
    }


    static int ROWS = 0;
    static int COLS = 0;


    private static int maxAreaOfIslandDFS(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int[][] visit = new int[ROWS][COLS];
        int maxArea = 0;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                // if island and not visited
                if (grid[row][col] == 1 && visit[row][col] == 0) {
                    int area = dfs(grid, row, col, visit);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private static int dfs(int[][] grid, int row, int col, int[][] visit) {
        if (Math.min(row, col) < 0 || row == ROWS || col == COLS ||
                visit[row][col] == 1 || grid[row][col] == 0) {
            return 0;
        }

        visit[row][col] = 1;
        int area = 1;
        area += dfs(grid, row, col - 1, visit);
        area += dfs(grid, row, col + 1, visit);
        area += dfs(grid, row - 1, col, visit);
        area += dfs(grid, row + 1, col, visit);

        return area;
    }


    public static int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int[][] visit = new int[ROWS][COLS];
        int maxArea = 0;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                // if island and not visited
                if (grid[row][col] == 1 && visit[row][col] == 0) {
                    int area = bfs(grid, row, col, visit);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private static int bfs(int[][] grid, int row, int col, int[][] visit) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{row, col});
        visit[row][col] = 1;

        int area = 1;
        while (!deque.isEmpty()) {
            int[] first = deque.removeFirst();
            row = first[0];
            col = first[1];

            // create direct neighbor
            int[][] neighbor = {
                    {row, col - 1},
                    {row, col + 1},
                    {row - 1, col},
                    {row + 1, col},
            };

            for (int i = 0; i < 4; i++) {
                int newRow = neighbor[i][0];
                int newCol = neighbor[i][1];

                if (Math.min(newRow, newCol) < 0 || newRow == ROWS || newCol == COLS ||
                        visit[newRow][newCol] == 1 || grid[newRow][newCol] == 0) {
                    continue;
                }

                visit[newRow][newCol] = 1;
                deque.add(neighbor[i]);
                area += 1;
            }
        }
        return area;
    }
}
