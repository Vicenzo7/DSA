package Backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities {
    public static void main(String[] args) {
        String tiles = "AAB";
        System.out.println(numTilePossibilities(tiles));
    }


    //using recursion
//    public static int numTilePossibilities(String tiles) {
//        Set<String>  result = new HashSet<>();
//        boolean[] visited = new boolean[tiles.length()];
//
//        solve(tiles,"",result,visited);
//        return result.size()-1;
//    }
//
//    private static void solve(String tiles, String output, Set<String> result, boolean[] visited) {
//        result.add(output);
//        for (int i = 0; i < tiles.length() ; i++) {
//            if(!visited[i])
//            {
//                visited[i]=true;
//                solve(tiles, output+tiles.charAt(i), result, visited);
//                visited[i] = false;
//            }
//        }
//    }

    // using back tracking
    public static int numTilePossibilities(String tiles) {
        Set<String>  result = new HashSet<>();
        StringBuilder output =new StringBuilder("");
        boolean[] visited = new boolean[tiles.length()];
        solve(tiles,output,result,visited);
        return result.size();
    }


    private static void solve(String tiles, StringBuilder output, Set<String> result, boolean[] visited) {

        for (int i = 0; i < tiles.length() ; i++) {
            if(!visited[i])
            {
                //take a char put it in string builder and mark the visited true
                char ch= tiles.charAt(i);
                output.append(ch);
                visited[i] = true;

                result.add(output.toString());
                solve(tiles,output,result,visited);

                //backtrack
                output.deleteCharAt(output.length()-1);
                visited[i] =false;
            }
        }
    }
}
