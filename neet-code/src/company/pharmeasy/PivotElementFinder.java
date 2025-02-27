package company.pharmeasy;

public class PivotElementFinder {
    public static int findPivot(int[] arr) {
        int n = arr.length;
        if (n < 3) return -1; // No valid pivot possible

        int[] leftMax = new int[n];
        int[] rightMin = new int[n];

        // Fill leftMax array
        leftMax[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i - 1]);
        }

        // Fill rightMin array
        rightMin[n - 1] = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i + 1]);
        }

        // Find the pivot element
        for (int i = 1; i < n - 1; i++) {
            if (leftMax[i] < arr[i] && arr[i] < rightMin[i]) {
                return arr[i];
            }
        }

        return -1; // No pivot element found
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 3, 6, 8, 10, 7, 9};
        int pivot = findPivot(arr);
        if (pivot != -1) {
            System.out.println("Pivot element: " + pivot);
        } else {
            System.out.println("No pivot element found.");
        }
    }
}
