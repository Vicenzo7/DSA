package Easy;

import java.util.Arrays;

public class FlippingAnImage {
    public static void main(String[] args) {

        int[][] image = {
                {1,1,0},
                {1,0,1},
                {0,0,0}
        };
        for (int rows = 0; rows < image.length ; rows++) {
            System.out.println(Arrays.toString(image[rows]));
        }
        System.out.println();
        int[][] results = flipAndInvertImage(image);
        System.out.println();

        for(int[] a : results) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        for (int row = 0; row < image.length; row++) {
            int start=0,end=image.length-1;
                while(start<end){
                    int temp = image[row][start];
                    image[row][start]= image[row][end];
                    image[row][end] = temp;
                    start++;
                    end--;
                }
        }


        for(int[] a : image) {
            System.out.println(Arrays.toString(a));
        }

        for (int row = 0; row < image.length ; row++) {
            for (int col = 0; col < image[row].length; col++) {
                if(image[row][col] == 1){
                    image[row][col]=0;
                }
                else{
                    image[row][col]=1;
                }

            }

        }
        System.out.println();
        for(int[] a : image) {
            System.out.println(Arrays.toString(a));
        }
        return image;
    }
}
