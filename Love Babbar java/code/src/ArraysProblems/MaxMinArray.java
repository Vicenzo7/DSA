package ArraysProblems;

public class MaxMinArray {
    public static void main(String[] args) {
        int[] arr = new int[] {24, 5 ,54,63,98,45,78,42,88,77};
        maxMin(arr);

    }

    private static void maxMin(int[] arr) {
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max)
            {
                max=arr[i];
            }
            if(arr[i]<min)
            {
                min=arr[i];
            }
        }
        System.out.println("MAX : "+max+" MIN :"+min);
    }
}
