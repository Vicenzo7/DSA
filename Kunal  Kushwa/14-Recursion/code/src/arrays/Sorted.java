package arrays;

public class Sorted {
    public static void main(String[] args) {

        int[] arr = {1,4,6,7,9,18};
        System.out.println(sorted(arr,0));
    }


//    static boolean sorted(int[] arr , int index){
//        if(index == arr.length-1){
//            return true;
//        }
//
//        if(arr[index] < arr[index+1]){
//            return sorted(arr,index+1);
//        }
//
//        return false;
//    }

    static boolean sorted(int[] arr , int index){
        if(index == arr.length-1){
            return true;
        }

        return arr[index] < arr[index+1] && sorted(arr,index+1);
    }
}
