package graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class RottingOranges {
    public static void main(String[] args) {
//        int[][] grid = {
//                {2, 1, 1},
//                {1, 1, 1},
//                {0, 1, 2}
//        };

        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int[][] grid2 = {{0, 2, 2}};
        System.out.println(orangesRotting(grid));
    }


    static int ROWS = 0;
    static int COLS = 0;

    public static int orangesRotting(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        return bfs(grid);
    }

    /*
        Approach Explanation:
        To efficiently simulate the rotting process of oranges, start by identifying all initial rotten oranges and storing them in a deque.
        Concurrently, calculate the total count of fresh oranges in the grid.


        Now, proceed with the simulation: in each minute, all the oranges in the deque can potentially rot adjacent oranges.
        While updating the grid, decrement the count of fresh oranges. This avoids unnecessary time calculations when there are no fresh oranges left.

        The process continues until either all fresh oranges are rotted or the deque becomes empty.

    */

    // TC = O(row.col)

    private static int bfs(int[][] grid) {

        Deque<int[]> deque = new ArrayDeque<>();
        int freshOrange = 0;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (grid[row][col] == 2) {
                    deque.add(new int[]{row, col});
                } else if (grid[row][col] == 1) {
                    freshOrange += 1;
                }
            }
        }

        int minimumTime = 0;

        while (!deque.isEmpty() && freshOrange != 0) {
            minimumTime += 1;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] rotten = deque.removeFirst();
                int row = rotten[0];
                int col = rotten[1];

                int[][] neighbors = {{row, col - 1}, {row, col + 1}, {row - 1, col}, {row + 1, col}};
                for (int j = 0; j < 4; j++) {
                    int newRow = neighbors[j][0];
                    int newCol = neighbors[j][1];

                    if (newRow >= 0 && newCol >= 0 && newRow < ROWS && newCol < COLS &&
                            grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        deque.add(neighbors[j]);
                        freshOrange -= 1;
                    }

                }
            }
        }
        return freshOrange == 0 ? minimumTime : -1;
    }
}
