package graph;

import java.util.*;

// border DFS
public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        System.out.println(pacificAtlantic(heights));
    }


    static int ROWS = 0;
    static int COLS = 0;

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;

        boolean[][] pacificOcean = new boolean[ROWS][COLS];
        boolean[][] atlanticOcean = new boolean[ROWS][COLS];
        List<List<Integer>> result = new ArrayList<>();

        // iterate from the ocean end and find the end from where the water flows
        // iterate the border
        for (int col = 0; col < COLS; col++) {
            dfs(0, col, pacificOcean, heights[0][col], heights);
            dfs(ROWS - 1, col, atlanticOcean, heights[ROWS - 1][col], heights);
        }

        for (int row = 0; row < ROWS; row++) {
            dfs(row, 0, pacificOcean, heights[row][0], heights);
            dfs(row, COLS - 1, atlanticOcean, heights[row][COLS - 1], heights);
        }

        // now find the intersection of those end which meet both pacific and atlantic
        // ocean
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (pacificOcean[row][col] && atlanticOcean[row][col]) {
                    result.add(List.of(row, col));
                }
            }
        }
        return result;
    }

    public static void dfs(int row, int col, boolean[][] visit, int previousHeight, int[][] heights) {
        // not out of bound, not already visited and since we are starting from ocean
        // end water can only flow if previousHeight <= currentHeight
        if (Math.min(row, col) < 0 || row == ROWS || col == COLS || visit[row][col] ||
                previousHeight > heights[row][col]) {
            return;
        }

        visit[row][col] = true;
        dfs(row, col - 1, visit, heights[row][col], heights); // left
        dfs(row, col + 1, visit, heights[row][col], heights); // right
        dfs(row - 1, col, visit, heights[row][col], heights); // up
        dfs(row + 1, col, visit, heights[row][col], heights); // down
    }
}
