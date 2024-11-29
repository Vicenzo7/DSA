package company.blackBuck;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[temperatures.length];

        for (int currentDay = 0; currentDay < temperatures.length; currentDay++) {
            while (!stack.empty() && temperatures[stack.peek()] <= temperatures[currentDay]) {
                Integer previousDay = stack.pop();
                output[previousDay] = currentDay - previousDay;
            }
            stack.add(currentDay);
        }

        return output;
    }


}
