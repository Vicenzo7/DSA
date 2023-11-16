package twopointer;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    /*
        Optimal solution:
        TC = O(n)  SC = O(1)

        1. Use two pointer approach
        2. Calculate the minimum height between the two ends
        3. Calculate the maximum container area by using the minimum height and the distance between the two end points.
        4. Move the pointer which has less height, as we want maximum container area.

    */


    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxContainerArea = 0;
        while (left < right) {
            int minimumHeight = Math.min(height[left], height[right]);

            maxContainerArea = Math.max(maxContainerArea, minimumHeight * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxContainerArea;
    }
}
