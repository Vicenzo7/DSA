package company.wayfair;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinimumMoves {


    /*

    QUESTION 1 - Minimum Moves

    There is a maze in HackerPlay where children play for recreation.
    The maze is represented as a (nm) grid of cells, where each cell is either empty (denoted by 0), or contains an
    obstacle (denoted by 1). HackerMan is currently standing at cell (0, 0) and wishes to reach th cell (n-1, m-1).
    For a jump parameter denoted by k, in one move, HackerMan can move to any of the following cells:

    (i + x, j) where 1 ≤x≤ k, provided cell (i + x, j) lies in the maze and there are no cells containing obstacles
     in the range (i, j) (i + 1, j)... → (i + x, j).

    (i, j + x) where 1 ≤x≤k, provided cell (i, j + x) lies in the maze and there are no cells containing obstacles
    in the range (i, j) → (i, j + 1) → ... → (i,j + x).

    (i-x, j) where 1 ≤x≤k, provided cell (i - x, j) lies in the maze and there are no cells containing obstacles
    in the range (i, j) → (i - 1, j) → ... → (i - x, j).

    (i, j-x) where 1 ≤x≤k, provided cell (i, j - x) lies in the maze and there are no cells containing obstacles
    in the range (i, j) → (i, j - 1) → ... → (i, j - 1).

    Find the minimum number of moves in which HackerMan can reach the cell (n-1, m-1) starting from (0, 0), or -1
    if it is impossible to reach that cell.

    Example
    Consider n = 2, m = 2, jump parameter k = 2, and maze = [[0, 0], [1, 0]]
    Output - 2

    */


    public static void main(String[] args) {
        int[][] maze = {{0, 0}, {1, 0}};
        int k = 2;

        System.out.println(minimumMoves(maze, k));
    }


    public static int minimumMoves(int[][] maze, int k) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> deque = new ArrayDeque<>();
        // row , col , jumps
        deque.add(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!deque.isEmpty()) {
            int[] poll = deque.poll();
            int row = poll[0];
            int col = poll[1];
            int jump = poll[2];

            if (row == m - 1 && col == n - 1) {
                return jump;
            }

            int[][] directions = {{row, col + 1}, {row, col - 1}, {row + 1, col}, {row - 1, col}};


            for (int[] direction : directions) {
                for (int nextJump = 1; nextJump <= k; nextJump++) {
                    int newRow = direction[0] + nextJump;
                    int newCol = direction[1] + nextJump;

                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n
                            && maze[newRow][newCol] == 0 && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        deque.add(new int[]{newRow, newCol, jump + 1});
                    } else if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n
                            && maze[newRow][newCol] == 1) {
                        break;
                    }

                }
            }
        }
        return -1;
    }
}
