package Problems;

public class ImplementTwoStacksInAnArray {
    int[] arr;
    int top1;
    int top2;
    int size;
    // Initialize TwoStack.
    public ImplementTwoStacksInAnArray(int s) {
        // Write your code here
        size = s;
        top1 =-1;
        top2 = s;
        arr = new int[size];
    }

    // Push in stack 1.
    public void push1(int num) {
        //atleast 1 space present
        if(top2-top1>1){
            top1++;
            arr[top1] = num;
        }

    }

    // Push in stack 2.
    public void push2(int num) {
        //atleast 1 space present
        if(top2-top1>1){
            top2--;
            arr[top2] = num;
        }

    }

    // Pop from stack 1 and return popped element.
    public int pop1() {
        //atleast one element present to pop
        if(top1 >=0){
            int ans = arr[top1];
            top1--;
            return ans;
        }else{
            return -1;
        }

    }

    // Pop from stack 2 and return popped element.
    public int pop2() {
        //atleast one element present to pop
        if(top2 < size){
            int ans = arr[top2];
            top2++;
            return ans;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        ImplementTwoStacksInAnArray obj = new ImplementTwoStacksInAnArray(10);
        obj.push1(3);
        obj.push2(4);
        obj.push1(5);
        System.out.println(obj.pop1());
        System.out.println(obj.pop2());
    }
}
