package graph.implementation;

import java.util.ArrayDeque;
import java.util.Deque;

public class MatrixBfs {

    /*
         Q. Find the length of the shortest path from top left of the grid to
         bottom right
     */
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 0}
        };
        System.out.println(bfs(grid));
    }


    // shortest path
    // TC = O(n.m)
    private static int bfs(int[][] grid) {

        int ROW = grid.length;
        int COLS = grid[0].length;
        int[][] visit = new int[ROW][COLS];
        Deque<int[]> deque = new ArrayDeque<>();

        deque.add(new int[2]); // Add {0,0}
        visit[0][0] = 1;

        int length = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] pair = deque.poll();
                int row = pair[0], col = pair[1];
                if (row == ROW - 1 && col == COLS - 1) {
                    return length;
                }

                // we can directly build the 4 neighbors
                int[][] neighbors = {
                        {row, col - 1}, // left
                        {row, col + 1}, // right
                        {row - 1, col}, // up
                        {row + 1, col}, // down
                };
                for (int j = 0; j < 4; j++) {
                    int newRow = neighbors[j][0];
                    int newCol = neighbors[j][1];

                    if (Math.min(newRow, newCol) < 0 || newRow == ROW || newCol == COLS ||
                            visit[newRow][newCol] == 1 || grid[newRow][newCol] == 1) {
                        continue;
                    }
                    deque.add(neighbors[j]);
                    visit[newRow][newCol] = 1;
                }
            }
            length += 1;
        }

        return length; // we never be called
    }
}
