package arrays;

import java.util.ArrayList;

public class FindElement {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 4, 5};
        System.out.println(find(arr, 4, 0));
        System.out.println(findIndex(arr,4,0));
        System.out.println(findIndexLast(arr,4,arr.length-1));
        findAllIndex(arr,4,0);
        System.out.println(list);

        System.out.println(findAllIndex(arr,4,0,new ArrayList<>()));

        System.out.println(findAllIndex2(arr,4,0));
    }

//    static boolean find(int[] arr,int target, int index){
//        if(index == arr.length)
//            return false;
//
//        if(arr[index]== target){
//            return true;
//        }
//
//        return find(arr,target, index+1);
//    }

    static boolean find(int[] arr, int target, int index) {
        if (index == arr.length)
            return false;

        return arr[index] == target || find(arr, target, index + 1);
    }

    static int findIndex(int[] arr, int target, int index) {
        if (index == arr.length)
            return -1;

        if (arr[index] == target){
            return index;
        }

        return findIndex(arr, target, index + 1);
    }

    static int findIndexLast(int[] arr, int target, int index) {
        if (index == -1)
            return -1;

        if (arr[index] == target){
            return index;
        }

        return findIndexLast(arr, target, index - 1);
    }

    static ArrayList<Integer> list = new ArrayList<>();
    static void findAllIndex(int[] arr, int target, int index) {
        if (index == arr.length)
            return ;

        if (arr[index] == target){
            list.add(index);
        }
        findAllIndex(arr, target, index + 1);
    }


    static ArrayList<Integer> findAllIndex(int[] arr, int target, int index,ArrayList<Integer> list) {
        if (index == arr.length)
            return list ;

        if (arr[index] == target){
            list.add(index);
        }
        return findAllIndex(arr, target, index + 1,list);
    }



    // By taking the list in the body of function and not in the argument
    static ArrayList<Integer> findAllIndex2(int[] arr, int target, int index) {

        ArrayList<Integer> list = new ArrayList<>();

        if (index == arr.length)
            return list ;

        if (arr[index] == target){
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls = findAllIndex2(arr, target, index + 1);
        list.addAll(ansFromBelowCalls);

        return list;

    }
}
