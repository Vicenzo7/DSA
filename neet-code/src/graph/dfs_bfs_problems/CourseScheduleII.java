package graph.dfs_bfs_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseScheduleII {
    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = {
                {0, 1},
                {0, 2},
                {1, 3},
                {1, 4},
                {3, 4}
        };
        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }


    static int counter = 0;

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] output = new int[numCourses];
        boolean result = canFinish(numCourses, prerequisites, output);
        return result ? output : new int[0];
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites, int[] output) {
        // list to store prerequisite of each course
        List<List<Integer>> coursesToPrerequisiteList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            coursesToPrerequisiteList.add(new ArrayList<>());
        }

        // Populate list with prerequisite
        for (int[] prerequisite : prerequisites) {
            coursesToPrerequisiteList.get(prerequisite[0]).add(prerequisite[1]);
        }

        // Array to keep track of visited courses
        int[] visit = new int[numCourses];
        /*
         * 0: Unvisited
         * 1: Currently visiting
         * 2: Visited
         */

        // check if it is possible to finish all courses
        for (int i = 0; i < numCourses; i++) {
            if (visit[i] == 0 && !dfs(i, coursesToPrerequisiteList, visit, output)) {
                return false;
            }
        }

        return true;
    }

    public static boolean dfs(int course, List<List<Integer>> coursesToPrerequisiteList, int[] visit, int[] output) {
        // if the course is currently being visited in cycle, return false
        if (visit[course] == 1) {
            return false;
        }

        // if the course is already visited and determined to be completed return true
        if (visit[course] == 2) {
            return true;
        }

        List<Integer> prerequisites = coursesToPrerequisiteList.get(course);

        // mark the course as currently visiting
        visit[course] = 1;
        for (int prerequisite : prerequisites) {
            if (!dfs(prerequisite, coursesToPrerequisiteList, visit, output)) {
                return false;
            }
        }

        // mark the course as completable
        visit[course] = 2;
        output[counter++] = course;
        return true;
    }
}
