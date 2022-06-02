package RecursionUnacedemy;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,5,9};
        int[] nums2 = {2,3,6,7};

        System.out.println(findMedianSortedArrays(nums1,nums2));
    }


    public static  double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int k=0;

        int[] merged = new int[nums1.length + nums2.length];

        while(i<nums1.length && j<nums2.length)
        {
            if(nums1[i]<nums2[j])
            {
                merged[k++] = nums1[i++];
            }else{
                merged[k++] = nums2[j++];
            }
        }

        while(i<nums1.length)
        {
            merged[k++] = nums1[i++];
        }

        while(j<nums2.length)
        {
            merged[k++] = nums2[j++];
        }

        double median =0;
        int mid = merged.length/2;

        if(merged.length%2 == 1)
        {
            median = merged[mid];
        }else{
            median = (merged[mid] + merged[mid-1])/2.0;
        }

        return median;
    }
}

