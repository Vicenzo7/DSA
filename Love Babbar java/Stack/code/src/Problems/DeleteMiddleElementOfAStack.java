package Problems;

import java.util.Stack;

public class DeleteMiddleElementOfAStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(5);
        System.out.println(s);
        deleteMiddle(s,s.size(),0);
        System.out.println(s);
    }


    public static void deleteMiddle(Stack<Integer> s, int n, int count) {
        if (count == n) {
            return;
        }

        int topElement = s.peek();
        s.pop();

        deleteMiddle(s, n, count + 1);

        if (count != n / 2)
            s.push(topElement);
    }
}
