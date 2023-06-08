package binarysearch.oneDArray;

public class KthElementOfTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {100, 112, 256, 349, 770};
        int[] nums2 = {72, 86, 113, 119, 265, 445, 892};
        int k = 7;
        System.out.println(kthElement(nums1, nums2, k));
        System.out.println(kthElement(nums1, nums2, nums1.length, nums2.length, k));
    }

    /*
        BruteForce
        Since we want the kth element, we can use the technique of merging two sorted arrays
        to find the kth element

        Merging Two sorted arrays

        step1: Run a while loop until one of the array exhaust
        step2: check if counter == k, if true break
                else check if element in array 1 is < element 0f array 2
                    if true , store that element in ans, increment array1 pointer and also the counter variable
                else it means array2 element < array1 element
                   if true , store that element in ans, increment array2 pointer and also the counter variable


        step3: Now when the loop exhausts,it can be because any one of the array exhausted, or the counter reached the
                value k;
                So check id counter == k, means we got an answer
                if not check which array didn't exhaust,
                the array which didn't exhaust contains answer
                array[k-counter]

        TC = O(k)
    */


    public static long kthElement(int[] nums1, int[] nums2, int k) {

        int counter = 0;
        int index1 = 0, index2 = 0;
        long answer = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (counter == k) break;
            if (nums1[index1] < nums2[index2]) {
                answer = nums1[index1];
                ++index1;
            } else {
                answer = nums2[index2];
                ++index2;
            }
            counter++;
        }

        if (counter != k) {
            if (index1 != nums1.length - 1) {
                answer = nums1[k - counter];
            } else {
                answer = nums2[k - counter];
            }
        }
        return answer;
    }

     /*

        Optimal solution

        nums1 = 1 3 4 7 10 12

        nums2 = 2 3 4 15

        k = 5

                  |
        1 2 3 3 4 | 6 7  10 12 15
                  |


       We need to find which element of num1 and num2 in left part and the last index of left part will always be our answer
      from num1
      1 3 4 last element l1 = 4

      from num2
      2 3 last element l2 = 3


     Therefore, ans is max(l1,l2) since both the array are sorted
     Now the question comes how many element we need to pick from first and second array so, we get our desired left part
     which is sorted

     The left part should have all the elements less than the right part, and left part will have elements equal to k.

     How to figure out all the elements on the left are smaller than all the elements on the right

         l1  r1
     1 3 4 | 7 10 12
      2 3 | 6 15
        l2 r2

        l1 <= r1 definitely because it's the same array
        l2 <= r2 definitely because it's the same array

    Case 1:
    we need to prove l1 <= r2 and l2 <= r1

        1 3   | 4 7 10 12
       2 3 6 | 15

    here l1 <= r2 but l2 <= r1 is false
         3  <= 15 but 6 <= 4 false

     so l2 must be small and r1 must be big
     in sort we should have more elements from the num1 and less element from num2
    1 3 4 | 7 10 12
      2 3 | 6 15

      To get this we need to go right


    Case 2:
    we need to prove l1 <= r2 and l2 <= r1

       1 3 4 7 | 10 12
           2 3 | 6 15

    here l1 <= r2 false  but l2 <= r1 is true
         7  <= 6 false but 3 <= 10 true

     so l1 must be small and r2 must be big
     in-short we should have fewer elements from the num1 and more element from num2
    1 3 4 | 10 12
      2 3 | 15

      To get this we need to go left


      So our binary Search will be on how many elements we want to pick from first array

      We will do binarySearch on array which has minimum element to reduce search space

        TC = O(log(min(n,m))  where n and m are length of two arrays

        Edge Cases

        suppose the smallest array is  7 12 14 15  and if k = 3
        1 2 3 4 9 11 second array
        min element you can pick from the smallest size array is 0
        max element you can pick from the smallest size array is 4 false because we want kth size element on the left

        edge case1; if k < size of smallest array
        so high = 3
        high = min(k,n) n is length of second array



        what if k = 7
        max element you can pick from the smallest size array is 4
        min element you can pick from the smallest size array is 0 false
        if we take 0 elements from first array and then elements in second array are 6 at max, but we need 7 elements to
        be on left part

        edge case2 : if k > size of largest array
        so low = 1
        low = max(0,k-m) m is length of largest array

        edges case 3
        cut1 is cut in the smallest array and cut2 is cut is the largest array
         l1 = num1[cut1-1]      r1 = num1[cut1]
         l2 = num1[cut2-1]      r2 = num1[cut2]

         cut |7 12 14 15
         cut |1 2 3 4 9 11

         if we do cut at marked position there is no value for l1 and l2 so at this position make l1 and l2 == Integer.MIN_VALUE

        edges case 4
        7 12 14 15 | cut
        1 2 3 4 9 11 | cut
        if we do cut at marked position there is no value for r1 and r2 so at this position make r1 and r2 == Integer.MAX_VALUE

    */


    public static long kthElement(int[] nums1, int[] nums2, int n, int m, int k) {
        // since we are going to do binary Search on the shortest array to reduce time complexity
        if (n > m) {
            return kthElement(nums2, nums1, m, n, k);
        }
        int low = Math.max(0, k - m); // min elements we can take from the smallest array is 0, but what if k > size of largest array we need to take at least one from the smallest array
        int high = Math.min(k, n); // max elements we can take from the smallest array is nums1.length ie all the element but what is k < nums1.length , then we can't take all element we need to take k no. of elements.

        while (low <= high) {
            int cut1 = low + (high - low) / 2; // number of elements taken from the smallest array
            int cut2 = k - cut1; // number of elements taken from the largest array

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];  // if cut1 = 0 there is no position for l1 so assign min
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];  // if cut2 = 0 there is no position for l2 so assign min
            int r1 = cut1 == n ? Integer.MAX_VALUE : nums1[cut1];      // if cut1 = n there is no position for l1 so assign max
            int r2 = cut2 == m ? Integer.MAX_VALUE : nums2[cut2];      // if cut1 = m there is no position for l2 so assign max


            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) { // we need to reduce number of elements of the smallest array
                high = cut1 - 1;
            } else {
                low = cut1 + 1;  // we need to reduce number of elements of the largest array
            }
        }

        return -1;
    }
}
