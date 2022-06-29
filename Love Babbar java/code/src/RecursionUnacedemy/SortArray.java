package RecursionUnacedemy;

import java.util.ArrayList;

public class SortArray {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(1);
        list.add(6);
        list.add(9);
        list.add(2);

        sort(list);
        System.out.println(list);

    }


    static void sort(ArrayList<Integer> list) {

        // size one means single element so already sorted
        if (list.size() == 1)
            return;

        // store the last element in a varaible and remove from the list
        int temp = list.get(list.size() - 1);
        list.remove(list.size() - 1);

        //recursive call
        sort(list);

        // now insert the element in sorted format
        insert(list, temp);

    }


    static void insert(ArrayList<Integer> list, int temp) {
        //base case
        // if list size is 0 or last element in list is smaller or equal to the element we want to insert, insert it
        if (list.size() == 0 || list.get(list.size() - 1) <= temp) {
            list.add(temp);
            return;
        }

        //store and remove the last value
        int val = list.get(list.size()-1);
        list.remove(list.size()-1);

        //recursive call
        insert(list,temp);

        //backtracking
        list.add(val);
    }
}
