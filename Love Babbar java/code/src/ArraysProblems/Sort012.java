package ArraysProblems;

public class Sort012 {

    public static void main(String[] args) {
        int[] arr=new int[]{1,0,0,2,0,1,0,2,1,2,2,2,2,1,1,1,0,0,0};
        sort012(arr);
        for(int a:arr)
        {
            System.out.print(a+" ");
        }
    }

    private static void sort012(int[] arr) {
        int n= arr.length;
        int count0=0,count1=0,count2=0;
        for (int i = 0; i <n ; i++) {
            if(arr[i]==0)
            {
                count0++;
            }
            else if(arr[i]==1)
            {
                count1++;
            }
            else if(arr[i]==2)
            {
                count2++;
            }
        }
        System.out.println(count0 +" "+ count1 +" "+ count2);

        for (int i = 0; i <count0 ; i++) {
            arr[i]=0;
        }
        for (int i = count0; i <count0+count1 ; i++) {
            arr[i]=1;
        }
        for (int i = count0+count1; i <count0+count1+count2 ; i++) {
            arr[i]=2;
        }


//        int i=0;
//        while(count0--)
//        {
//            arr[i]=0;
//            i++;
//        }
//        while(count1--)
//        {
//            arr[i]=1;
//            i++;
//        }
//        while(count2--)
//        {
//            arr[i]=2;
//            i++;
//        }
    }

}
