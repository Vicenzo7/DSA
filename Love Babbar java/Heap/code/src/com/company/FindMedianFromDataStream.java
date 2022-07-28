package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); //1st half (left half)
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();//2nd half (Right half)
    public void addNum(int num) {
        int lsize = maxHeap.size();
        int rsize = minHeap.size();

        // this also means rsize is zero
        if(lsize == 0)//num is the 1st element in stream
        {
            maxHeap.add(num);
        }else if (lsize == rsize){ //Push one element in maxheap for sure
            if(num < minHeap.peek()){ //num can be pushed to maxheap (1st half) to maintain order
                maxHeap.add(num);
            }else{ //Push root of minheap to maxheap (Push num to 2nd half)
                int temp = minHeap.peek();//Save root of minheap
                minHeap.remove(); //Pop the root from minheap
                minHeap.add(num); //Push num in minheap
                maxHeap.add(temp); //Push the previous saved root of minheap in the maxheap
            }
        }else{  ///We assume that maxheap can be larger than minheap by a max of 1 element only
            if(minHeap.size()==0){
                 if(num >maxHeap.peek()){ //Push num to 2nd half
                     minHeap.add(num);
                 }else{
                     int temp = maxHeap.peek();
                     maxHeap.remove();
                     maxHeap.add(num);
                     minHeap.add(temp);
                 }
            }
            else if (num >= minHeap.peek()){   //Push the element directly in minheap (2nd half)
                minHeap.add(num);
            }
            else{ //Push root of maxheap to minheap
                if(num < maxHeap.peek()){
                    int temp = maxHeap.peek();  //Save root of maxheap
                    maxHeap.remove(); //Pop root of maxheap
                    maxHeap.add(num);   //Push num to maxheap
                    minHeap.add(temp); //Push previous saved root of maxheap to minheap
                }else{
                    //Push num to 2nd half
                    minHeap.add(num);
                }
            }
        }
    }

    public double findMedian() {
        int lsize = maxHeap.size();
        int rsize = minHeap.size();

        // for odd case maxheap will have only one extra element
        if(lsize>rsize)
            return (double) maxHeap.peek();
        else
            return ((double)maxHeap.peek() + (double)minHeap.peek())/2;
    }

    public static void main(String[] args) {
        FindMedianFromDataStream obj = new FindMedianFromDataStream();

        obj.addNum(5);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
        obj.addNum(4);
        System.out.println(obj.findMedian());
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(6);
        System.out.println(obj.findMedian());

    }
}
