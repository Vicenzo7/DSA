package stack;

import java.util.ArrayList;
import java.util.List;

public class MinStackSolution {
    static class MinStack {
        private final List<Integer> stack;
        private final List<Integer> minStack;

        public MinStack() {
            this.stack = new ArrayList<>();
            this.minStack = new ArrayList<>();
        }

        public void push(int val) {
            stack.add(val);

            if (stack.size() > 1) {
                minStack.add(Math.min(minStack.get(minStack.size() - 1), val));
            } else {
                minStack.add(val);
            }
        }

        public void pop() {
            stack.remove(stack.size() - 1);
            minStack.remove(minStack.size() - 1);
        }

        public int top() {
            return stack.get(stack.size() - 1);
        }

        public int getMin() {
            return minStack.get(minStack.size() - 1);
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
        System.out.println(minStack.stack);
        System.out.println(minStack.minStack);
    }
}
