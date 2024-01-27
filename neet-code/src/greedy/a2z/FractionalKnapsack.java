package greedy.a2z;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int N = 3, W = 21;
        int[] value = {8, 2, 10, 1, 9, 7, 2, 6, 4, 9};
        int[] weight = {10, 1, 7, 7, 5, 1, 8, 6, 8, 7};

        Item[] items = new Item[value.length];
        for (int i = 0; i < value.length; i++) {
            items[i] = new Item(value[i], weight[i]);
        }

        System.out.println(fractionalKnapsack(W, items, N));
    }

    public static double fractionalKnapsack(int W, Item[] arr, int n) {

        Arrays.sort(arr, (o1, o2) -> Double.compare((double) o2.value / o2.weight, (double) o1.value / o1.weight));

        double maxValue = 0;
        int i = 0;
        while (i < arr.length && W >= 0) {
            Item item = arr[i];
            if (item.weight <= W) {
                W -= item.weight;
                maxValue += item.value;
            } else {
                maxValue += ((double) item.value / item.weight) * W;
                W -= W;
            }
            i++;
        }
        return maxValue;
    }

    public static class Item {
        int value, weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }
}
