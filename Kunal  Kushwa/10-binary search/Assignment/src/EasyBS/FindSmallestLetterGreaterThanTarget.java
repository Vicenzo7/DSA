package EasyBS;

public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters={'c','f','j'};
        char target='d';
        System.out.println(nextGreatestLetter(letters,target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
       //brute force

        //taking ascii value of target
//        int value1=target;
//        int ans=Integer.MAX_VALUE;
//        for (int i = 0; i <letters.length ; i++) {
//            //taking ascii value of array element one by one
//            int value2=letters[i];
//            //comparing is greater
//            if(value2>value1)
//            {
//                //taking minimum because there may be more element that are greater and be want the smallest greater
//                ans=Math.min(ans,value2);
//            }
//        }
//        //if there is no character which is larger than target than return the first char of array
//        if(ans==Integer.MAX_VALUE)
//        {
//            ans=letters[0];
//        }
//        return (char) ans;


        //optimized using binarySearch

//
//        int start=0;
//        int end=letters.length-1;
//        int value1=target;
//        int ans=Integer.MAX_VALUE;
//
//        while(start<=end)
//        {
//            int mid= start+(end-start)/2;
//            int value2=letters[mid];
//            if(value2>value1)
//            {
//                ans=Math.min(ans,value2);
//                end=mid-1;
//            }else{
//                start=mid+1;
//            }
//        }
//        if(ans==Integer.MAX_VALUE)
//        {
//            ans=letters[0];
//        }
//
//        return (char)ans;


        int start=0;
        int end= letters.length-1;

        while(start<end)
        {
            int mid=start+(end-start)/2;
            if(letters[mid]<=target)
            {
                start=mid+1;
            }
            else{
                end=mid;
            }
        }

        return letters[start]>target ? letters[start]:letters[0];
    }
}
