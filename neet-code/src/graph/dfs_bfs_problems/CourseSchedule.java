package graph.dfs_bfs_problems;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {
                {0, 1},
                {0, 2},
                {1, 3},
                {1, 4},
                {3, 4}
        };

        int[][] prerequisites2 = {
                {1, 0},
                {0, 1},
        };
        System.out.println(canFinish(numCourses, prerequisites2));
        System.out.println(canFinishOptimised(numCourses, prerequisites2));
    }

    /*

        Good example is
        {
            {0,1}
            {0,2}
            {1,3}
            {1,4}
            {3,4}
        }


    */



        /*
            using just array and not map. More Optimised
            0: Unvisited
            1: Currently visiting
            2: Visited

   */


    public static boolean canFinishOptimised(int numCourses, int[][] prerequisites) {
        // List to store the prerequisites for each course
        List<List<Integer>> courseToPrerequisiteList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            courseToPrerequisiteList.add(new ArrayList<>());
        }

        // Populate the map with prerequisites
        for (int[] prerequisite : prerequisites) {
            courseToPrerequisiteList.get(prerequisite[0]).add(prerequisite[1]);
        }

        // Array to keep track of visited courses
        int[] visit = new int[numCourses];
        /*
         * 0: Unvisited
         * 1: Currently visiting
         * 2: Visited
         */

        // Check if it's possible to finish all courses
        for (int i = 0; i < numCourses; i++) {
            if (visit[i] == 0 && hasCycle(i, courseToPrerequisiteList, visit)) {
                return false;
            }
        }

        return true;
    }

    // Depth-first search to explore courses and their prerequisites
    private static boolean hasCycle(int course, List<List<Integer>> courseToPrerequisiteList, int[] visit) {
        // If the course is currently being visited in the cycle, return false
        if (visit[course] == 1) {
            return true; // detected a cycle
        }

        // If the course is already visited and determined to be completable, return
        // true
        if (visit[course] == 2) {
            return false;
        }

        // If the course has no prerequisites, return true
        List<Integer> prerequisites = courseToPrerequisiteList.get(course);
        if (prerequisites.isEmpty()) {
            return false;
        }

        // Mark the course as currently visiting
        visit[course] = 1;

        // Explore prerequisites through DFS
        for (Integer prerequisite : prerequisites) {
            // If the prerequisite cannot be completed, return false
            if (hasCycle(prerequisite, courseToPrerequisiteList, visit)) {
                return true;
            }
        }

        // Remove the course from the currently visiting set
        // Mark the course as visited
        visit[course] = 2;
        return false;
    }

    // Method to check if it's possible to finish all courses
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Map to store the prerequisites for each course
        Map<Integer, List<Integer>> courseToPrerequisiteMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            courseToPrerequisiteMap.put(i, new ArrayList<>());
        }

        // Populate the map with prerequisites
        for (int[] prerequisite : prerequisites) {
            List<Integer> list = courseToPrerequisiteMap.getOrDefault(prerequisite[0], new ArrayList<>());
            list.add(prerequisite[1]);
        }

        // Set to keep track of visited courses
        Set<Integer> visit = new HashSet<>();
        // Set to keep track of courses along the current DFS path
        Set<Integer> currentlyVisiting = new HashSet<>();

        // Check if it's possible to finish all courses
        for (int i = 0; i < numCourses; i++) {
            if (!visit.contains(i) && !dfs(i, courseToPrerequisiteMap, visit, currentlyVisiting)) {
                return false;
            }
        }

        return true;
    }

    // Depth-first search to explore courses and their prerequisites
    private static boolean dfs(int course, Map<Integer, List<Integer>> courseToPrerequisiteMap, Set<Integer> visit, Set<Integer> currentlyVisiting) {
        // If the course is currently being visited in the cycle, return false
        if (currentlyVisiting.contains(course)) {
            return false;
        }

        // If the course is already visited and determined to be completable, return true
        if (visit.contains(course)) {
            return true;
        }

        // If the course has no prerequisites, return true
        List<Integer> prerequisites = courseToPrerequisiteMap.get(course);
        if (prerequisites.isEmpty()) {
            return true;
        }

        // Mark the course as currently visiting
        currentlyVisiting.add(course);

        // Explore prerequisites through DFS
        for (Integer prerequisite : prerequisites) {
            // If the prerequisite cannot be completed, return false
            if (!dfs(prerequisite, courseToPrerequisiteMap, visit, currentlyVisiting)) {
                return false;
            }
        }

        // Remove the course from the currently visiting set
        currentlyVisiting.remove(course);
        // Mark the course as visited
        visit.add(course);
        // Reset prerequisites to an empty list, as all prerequisites are completed
        prerequisites = new ArrayList<>();

        return true;
    }
}
