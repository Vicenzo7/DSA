package ArraysProblems;

public class ArrayPalindrome {
    public static void main(String[] args) {
        int[] arr ={3, 6, 0, 6, 3,};
        boolean flag=true;
        int n= arr.length;
        for (int i =0; i <n/2; i++) {
            if (arr[i] != arr[n - i - 1]) {
                flag = false;
                break;
            }
        }

        if(flag==true)
        {
            System.out.println("palindrome");
        }
        else
        {
            System.out.println("not palindrome");
        }
    }
}
