package binarysearch.bsInSearchSpace;

public class AllocatedBooks {
    public static void main(String[] args) {
        int n = 4, students = 2;
        int[] pages = {12, 34, 67, 90};
        System.out.println(findPages(pages, n, students));
    }

    /*
        Optimal Approach : BinarySearch
        Search range
        low = 0 to high = sumOfPages
        calculate the and check if mid is an answer.
        If mid is an answer store it and move towards the left because we need minimum.
        Or else move towards right.

        How to check if mid is a possible answer.
        keep a student count and also keep count of pages allocated

        if sumOfPages + page <= maxPages
            sunOfPages += page;
        else
            studentCount++
            sumOfPage = page;


        Later check if studentCount == student


    */

    public static int findPages(int[] pages, int N, int students) {
        // each student should get at least one  book allocated but if number of books are less than student,
        // then we cannot allocate at least one book.
        if(pages.length < students) return -1;

        int ans = -1;
        int sumOfPages = 0;
        // finding search space
        for (int page : pages) {
            sumOfPages += page;
        }

        int low = 0, high = sumOfPages;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // calculate mid and check if it's a possible answer
            if (isPossibleAllocation(pages, students, mid)) {
                ans = mid;// if mid is an answer store it and move towards left, because we need minimum
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isPossibleAllocation(int[] books, int students, int maxPages) {
        int studentCount = 1;
        int sumOfPages = 0;
        for (int page : books) {
            if (sumOfPages + page <= maxPages) {
                sumOfPages += page;
            } else {
                sumOfPages = page;
                studentCount++;
                if (studentCount > students || page > maxPages) {
                    return false;
                }
            }
        }
        return studentCount <= students;
    }


}
