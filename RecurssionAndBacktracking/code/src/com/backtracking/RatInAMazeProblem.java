package com.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class RatInAMazeProblem {
    public static void main(String[] args) {
        int[][] m = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        int n = m.length;
        System.out.println(findPath(m,n));
    }

    public static ArrayList<String> findPath(int[][] m, int n) {

        ArrayList<String> ans = new ArrayList<>();
        // if the starting source is blocked
        if(m[0][0] == 0)
            return ans;

        StringBuilder output = new StringBuilder("");
        //initialise it to false
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                visited[i][j] = false;
            }
        }
        int srcx=0;
        int srcy =0;
        solve(m ,srcx,srcy,output,ans,visited);
        Collections.sort(ans);

        return ans;
    }

    public static void solve(int[][] m , int x,int y,StringBuilder output,ArrayList<String> ans,boolean[][] visited)
    {

        // we have reached x,y here
        // base case : if reached destination
        if(x == m.length-1 && y == m.length-1)
        {
            ans.add(output.toString());
            return ;
        }

        visited[x][y] =true;

        //4 choices :- DLRU

        //down
        int newX=x+1;
        int newY=y;
        if(isSafe(newX,newY,m,visited))
        {
            output.append('D');
            solve(m, newX, newY, output, ans, visited);
            output.deleteCharAt(output.length()-1);
        }

        //left
        newX=x;
        newY=y-1;
        if(isSafe(newX,newY,m,visited))
        {
            output.append('L');
            solve(m, newX, newY, output, ans, visited);
            output.deleteCharAt(output.length()-1);
        }

        //right
        newX=x;
        newY=y+1;
        if(isSafe(newX,newY,m,visited))
        {
            output.append('R');
            solve(m, newX, newY, output, ans, visited);
            output.deleteCharAt(output.length()-1);
        }

        //up
        newX=x-1;
        newY=y;
        if(isSafe(newX,newY,m,visited))
        {
            output.append('U');
            solve(m, newX, newY, output, ans, visited);
            output.deleteCharAt(output.length()-1);
        }
        visited[x][y]= false;


    }

    private static boolean isSafe(int newX, int newY, int[][] m, boolean[][] visited) {

        if((newX >= 0 && newX<m.length) && (newY >= 0 && newY<m.length) && !visited[newX][newY] && m[newX][newY] ==1 )
        {
            return true;
        }
        else{
            return false;
        }

    }
}