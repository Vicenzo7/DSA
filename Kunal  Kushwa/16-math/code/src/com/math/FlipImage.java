package com.math;

import java.util.Arrays;

// https://leetcode.com/problems/flipping-an-image/
public class FlipImage {


    public static void main(String[] args) {
       int[][] image = {{1,1,0},
               {1,0,1},
               {0,0,0}};


        flipAndInvertImage(image);

        for (int [] rows:image){
            System.out.println(Arrays.toString(rows));
        }
    }
    public static int[][] flipAndInvertImage(int[][] image) {
//        for(int row=0; row<image.length; row++){
//            int start=0, end= image.length-1;
//            while(start<end){
//                int temp = image[row][start];
//                image[row][start] = image[row][end];
//                image[row][end] = temp;
//                start++;
//                end--;
//            }
//        }
//
//        for(int row=0; row< image.length; row++){
//            for(int col=0; col< image.length;col++){
//                 if(image[row][col] == 1){
//                    image[row][col] = 0;
//                }
//                else{
//                     image[row][col] = 1;
//                }
//            }
//
//        }


        // better and faster using xor
        for(int row=0; row<image.length; row++){
            int start=0, end= image.length-1;
            while(start<=end){
                int temp = image[row][start] ^1;
                image[row][start] = image[row][end]^1;
                image[row][end] = temp;
                start++;
                end--;
            }
        }

        return image;
    }
}