package dp.onedimension.batchII;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
//        triangle.add(List.of(-10));

        triangle.add(List.of(2));
        triangle.add(List.of(3, 4));
        triangle.add(List.of(6, 5, 7));
        triangle.add(List.of(4, 1, 8, 3));

        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.isEmpty()) {
            return 0;
        }

        if(triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

//        return bruteForce(0, 0, triangle);
        return memoization(0, 0, triangle, new Integer[triangle.size()][triangle.size()]);
    }


    private static int bruteForce(int row, int index, List<List<Integer>> triangle) {
        if (row >= triangle.size()) {
            return 0;
        }

        int sum = triangle.get(row).get(index);

        // take the next row
        int option1 = bruteForce(row + 1, index, triangle);
        int option2 = bruteForce(row + 1, index + 1, triangle);

        return sum + Math.min(option1, option2);
    }

    private static int memoization(int row, int index, List<List<Integer>> triangle, Integer[][] cache) {

        if (row >= triangle.size()) {
            return 0;
        }

        if (cache[row][index] != null) {
            return cache[row][index];
        }

        int sum = triangle.get(row).get(index);

        // take the next row
        int option1 = memoization(row + 1, index, triangle, cache);
        int option2 = memoization(row + 1, index + 1, triangle, cache);

        return cache[row][index] = sum + Math.min(option1, option2);

    }
}
