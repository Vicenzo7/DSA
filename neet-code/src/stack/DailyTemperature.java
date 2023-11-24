package stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
// 73
//    73 -> 74
//    74 -> 75
//    75 -> 76
//    71 -. 72
//    69 -> 72
//    72 -> 76
//    76 -> 0
//    73 -> 0


//    public static int[] dailyTemperatures(int[] temperatures) {
//        int[] result = new int[temperatures.length];
//
//        for (int i = 0; i < temperatures.length - 1; i++) {
//            for (int j = i + 1; j < temperatures.length; j++) {
//                if (temperatures[i] < temperatures[j]) {
//                    result[i] = j - i;
//                    break;
//                }
//            }
//        }
//
//        return result;
//    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        // in stack, we will store position -> reference next greater element
        for (int currentDay = 0; currentDay < temperatures.length; currentDay++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[currentDay]) {
                Integer prevDay = stack.pop();
                result[prevDay] = currentDay - prevDay;
            }
            stack.add(currentDay);
        }
        return result;
    }
}
