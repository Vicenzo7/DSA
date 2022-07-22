package com.company;

import java.util.Arrays;

public class Heap_Implementation {

    int[] arr = new int[250];
    int size = 0;



    void insertIntoHeap(int value) {
        //we want to insert a value so size must increase
        size = size + 1;
        int index = size;

        //insert value
        arr[index] = value;

        //take value to  its right place
        while (index > 1) {
            int parentIndex = index / 2;

            if (arr[parentIndex] < arr[index]) {
                swap(arr,index,parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void deleteFromHeap(){
        if(size == 0){
            System.out.println("Heap is already empty");
            return;
        }
        //step1:
        swap(arr,1,size);

        //step2
        size--;

        //step3
        int index =1;

        while(index<= size){
            int largestIndex = index;
            int left = 2*index;
            int right = 2*index+1;
            if(left<=size && arr[left]> arr[largestIndex]){
                largestIndex = left;
            }
            if(right<=size && arr[right]> arr[largestIndex]){
                largestIndex = right;
            }

            if(largestIndex != index){
                swap(arr,largestIndex,index);
                index =largestIndex;
            }else{
                // we have arrived at a right place
                break;
            }
        }

    }

    void heapify(int[] arr,int n,int i){
        int largestindex = i;
        int left = 2*i;
        int right = 2*i +1;

        if(left <=n && arr[left]>=largestindex){
            largestindex = left;
        }
        if(right <=n && arr[right]>=largestindex){
            largestindex = right;
        }

        if(largestindex !=i){
            swap(arr,largestindex,i);
            heapify(arr,n,largestindex);
        }
    }

    void swap(int[] arr ,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args) {

        Heap_Implementation maxHeap = new Heap_Implementation();

//        maxHeap.insertIntoHeap(2);
//        maxHeap.insertIntoHeap(6);
//        maxHeap.insertIntoHeap(8);
//        maxHeap.insertIntoHeap(3);
//        maxHeap.insertIntoHeap(7);
//        maxHeap.print();
//
//
//        maxHeap.deleteFromHeap();
//        maxHeap.print();
//
//        maxHeap.deleteFromHeap();
//        maxHeap.print();
//
//        maxHeap.deleteFromHeap();
//        maxHeap.print();
//
//        maxHeap.deleteFromHeap();
//        maxHeap.print();
//
//        maxHeap.deleteFromHeap();
//        maxHeap.print();
//
//        maxHeap.deleteFromHeap();
//        maxHeap.print();


        int arr[] = {-1,2,6,8,3,7};

        //logic for buildHeap
        int n=5;
        for (int i = n/2; i >=1 ; i--) {
            maxHeap.heapify(arr,n,i);
        }

        System.out.println(Arrays.toString(arr));
    }
}
