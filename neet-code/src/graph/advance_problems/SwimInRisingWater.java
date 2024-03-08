package graph.advance_problems;

import java.util.*;

public class SwimInRisingWater {
    /*
     What question actually means
     find the maximum height in a path, which should be minimum max height in all the path
    */


    public static void main(String[] args) {
//        int[][] grid = {
//                {0, 2}, // 0
//                {1, 3} // 1
//        };

        int[][] grid = {
                {0, 1, 2, 3, 4}, // 0
                {24, 23, 22, 21, 5}, // 1
                {12, 13, 14, 15, 16}, //2
                {11, 17, 18, 19, 20}, // 3
                {10, 9, 8, 7, 6} // 4
        };

        System.out.println(swimInWater(grid));
    }

    public static int swimInWater(int[][] grid) {
        // using modified Dijkstra's algo
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Set<String> visit = new HashSet<>();

        // (time or maxHeight along that path,row ,col)
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        // add the initial source and mark as visited
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visit.add(0 + "-" + 0);

        while (!minHeap.isEmpty()) {
            int[] nodeInfo = minHeap.poll();
            int time = nodeInfo[0];
            int row = nodeInfo[1];
            int col = nodeInfo[2];

            // check if we reached the destination
            if (row == ROWS - 1 && col == COLS - 1) {
                return time;
            }

            // visit its neighbours
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // check if out of bound or already visited
                if (Math.min(newRow, newCol) < 0 || newRow == ROWS || newCol == COLS
                        || visit.contains(newRow + "-" + newCol)) {
                    continue;
                }

                // add to visit
                visit.add(newRow + "-" + newCol);
                // add to minHeap with maxHeight along that path
                minHeap.offer(new int[]{Math.max(time, grid[newRow][newCol]), newRow, newCol});
            }
        }
        return -1;
    }
}
