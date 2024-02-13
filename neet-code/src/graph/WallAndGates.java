package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class WallAndGates {

    public static void main(String[] args) {
        int[][] room = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}};

        wallsAndGates(room);
        for (int[] ints : room) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /*
        Add all the treasure in the queue and do a bfs from each treasure to an island and update their
        distance from the treasure.

    */

    public static void wallsAndGates(int[][] rooms) {
        int ROWS = rooms.length;
        int COLS = rooms[0].length;
        Deque<int[]> deque = new ArrayDeque<>();

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (rooms[row][col] == 0) {
                    deque.add(new int[]{row, col});
                }
            }
        }


        while (!deque.isEmpty()) {
            int[] room = deque.removeFirst();
            int row = room[0];
            int col = room[1];

            int[][] neighbors = {{row, col - 1}, {row, col + 1}, {row - 1, col}, {row + 1, col}};
            for (int i = 0; i < 4; i++) {
                int newRow = neighbors[i][0];
                int newCol = neighbors[i][1];
                if (Math.min(newRow, newCol) < 0 || newRow == ROWS || newCol == COLS
                        || rooms[newRow][newCol] != Integer.MAX_VALUE) {
                    continue;
                }

                rooms[newRow][newCol] = rooms[row][col] + 1;
                deque.add(new int[]{newRow, newCol});
            }
        }
    }
}
