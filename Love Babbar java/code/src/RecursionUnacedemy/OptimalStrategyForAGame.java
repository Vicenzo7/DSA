package RecursionUnacedemy;

public class OptimalStrategyForAGame {
    public static void main(String[] args) {
        int[] arr ={8,15,3,7};
        int i=0;
        int j= arr.length-1;
        System.out.println(optimalStratergy(arr,i,j));
    }

    public static int optimalStratergy(int[] arr,int i,int j)
    {
        if(i>j)
            return 0;

        int choice1 = arr[i]+ Math.min(optimalStratergy(arr,i+2,j),optimalStratergy(arr,i+1,j-1));
        int choice2 = arr[j]+ Math.min(optimalStratergy(arr,i+1,j-1),optimalStratergy(arr,i,j-2));

        return Math.max(choice1,choice2);
    }
}
