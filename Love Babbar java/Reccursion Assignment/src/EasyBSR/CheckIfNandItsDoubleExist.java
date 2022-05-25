package EasyBSR;

import java.util.Arrays;

class CheckIfNandItsDoubleExist {

    public static void main(String[] args) {
        int[] arr = {-8,-4,1,4,3};

//        Arrays.sort(arr);
//        int k=Arrays.binarySearch(arr,7);
//        System.out.println(k);
        System.out.println(checkIfExist(arr));
    }
    public static boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>=0 && binarySearch(arr,i+1,arr.length-1,2*arr[i]))
            {
                return true;
            }
            else if(arr[i]<0 && arr[i]%2==0 && binarySearch(arr,i+1,arr.length-1,arr[i]/2))
            {
                return true;
            }
        }
        return false;
    }
    
    public static boolean binarySearch(int[] arr,int start,int end,int target) {

        //base case
        if(start>end)
            return false;
        int mid = start + (end-start)/2;
    
        //BS conditions
        if(arr[mid] == target)
            return true;
        else if(arr[mid]<target)
        {
            return binarySearch(arr,mid+1,end,target);
        }
        else{
            return binarySearch(arr,start,mid-1,target);
        }
    }
}