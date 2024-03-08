

## DFS or BFS on entire grid only once

```
// DFS
public static int dfs(int[][] grid, int row, int col, int[][] visit) {  
    int ROWS = grid.length, COLS = grid[0].length;  
  
    if (Math.min(row, col) < 0 || row == ROWS || col == COLS ||  
            visit[row][col] == 1 || grid[row][col] == 1) {  
        return 0;  
    }  
  
    // check if reached the target  
    if (row == ROWS - 1 && col == COLS - 1) {  
        return 1;  
    }  
  
    visit[row][col] = 1;  
  
    int count = 0;  
    count += dfs(grid, row, col - 1, visit); // left  
    count += dfs(grid, row, col + 1, visit); // right  
    count += dfs(grid, row - 1, col, visit); // up  
    count += dfs(grid, row + 1, col, visit); // down  
  
    visit[row][col] = 0;  
    return count;  
}


// BFS
private static int bfs(int[][] grid) {  
  
    int ROW = grid.length;  
    int COLS = grid[0].length;  
    int[][] visit = new int[ROW][COLS];  
    Deque<int[]> deque = new ArrayDeque<>();  
  
    deque.add(new int[2]); // Add {0,0}  
    visit[0][0] = 1;  
  
    int length = 0;  
    while (!deque.isEmpty()) {  
        int size = deque.size();  
        for (int i = 0; i < size; i++) {  
            int[] pair = deque.poll();  
            int row = pair[0], col = pair[1];  
            if (row == ROW - 1 && col == COLS - 1) {  
                return length;  
            }  
  
            // we can directly build the 4 neighbors  
            int[][] neighbors = {  
                    {row, col - 1}, // left  
                    {row, col + 1}, // right  
                    {row - 1, col}, // up  
                    {row + 1, col}, // down  
            };  
            for (int j = 0; j < 4; j++) {  
                int newRow = neighbors[j][0];  
                int newCol = neighbors[j][1];  
  
                if (Math.min(newRow, newCol) < 0 || newRow == ROW || newCol == COLS ||  
                        visit[newRow][newCol] == 1 || grid[newRow][newCol] == 1) {  
                    continue;  
                }  
                deque.add(neighbors[j]);  
                visit[newRow][newCol] = 1;  
            }  
        }  
        length += 1;  
    }  
  
    return length; // we never be called  
}
```

## DFS or BFS on each element

```
public static int numIslands(char[][] grid) {  
    int island = 0;  
    int[][] visit = new int[grid.length][grid[0].length];  
    for (int row = 0; row < grid.length; row++) {  
        for (int col = 0; col < grid[0].length; col++) {  
            if (grid[row][col] == '1' && visit[row][col] == 0) {  
                island++;  
                dfs(grid, row, col, visit);  
            }  
        }  
    }  
  
    return island;  
}


private static int numIslandsBFS(char[][] grid) {  
    int ROWS = grid.length;  
    int COLS = grid[0].length;  
    int[][] visit = new int[ROWS][COLS];  
    int island = 0;  
  
    for (int row = 0; row < ROWS; row++) {  
        for (int col = 0; col < COLS; col++) {  
            // is island and not visited  
            if (grid[row][col] == '1' && visit[row][col] == 0) {  
                island += 1;  
                bfs(grid, row, col, visit);  
            }  
        }  
    }  
  
    return island;  
}
```

## DFS from boundary 

```
//  top and bottom boundary dfs  
for (int col = 0; col < COLS; col++) {  
    if (board[0][col] == 'O') {  
        dfs(0, col, board, visit);  
    }  
    if (board[ROWS - 1][col] == 'O') {  
        dfs(ROWS - 1, col, board, visit);  
    }  
}  
  
// left and right boundary dfs  
for (int row = 0; row < ROWS; row++) {  
    if (board[row][0] == 'O') {  
        dfs(row, 0, board, visit);  
    }  
    if (board[row][COLS - 1] == 'O') {  
        dfs(row, COLS - 1, board, visit);  
    }  
}
```

## BFS: Adding specific elements in deque prior and then doing bfs

```
private static int bfs(int[][] grid) {  
  
    Deque<int[]> deque = new ArrayDeque<>();  
    int freshOrange = 0;  
    for (int row = 0; row < ROWS; row++) {  
        for (int col = 0; col < COLS; col++) {  
            if (grid[row][col] == 2) {  
                deque.add(new int[]{row, col});  
            } else if (grid[row][col] == 1) {  
                freshOrange += 1;  
            }  
        }  
    }  
  
    int minimumTime = 0;  
  
    while (!deque.isEmpty() && freshOrange != 0) {  
        minimumTime += 1;  
        int size = deque.size();  
        for (int i = 0; i < size; i++) {  
            int[] rotten = deque.removeFirst();  
            int row = rotten[0];  
            int col = rotten[1];  
  
            int[][] neighbors = {{row, col - 1}, {row, col + 1}, {row - 1, col}, {row + 1, col}};  
            for (int j = 0; j < 4; j++) {  
                int newRow = neighbors[j][0];  
                int newCol = neighbors[j][1];  
  
                if (newRow >= 0 && newCol >= 0 && newRow < ROWS && newCol < COLS &&  
                        grid[newRow][newCol] == 1) {  
                    grid[newRow][newCol] = 2;  
                    deque.add(neighbors[j]);  
                    freshOrange -= 1;  
                }  
  
            }  
        }  
    }  
    return freshOrange == 0 ? minimumTime : -1;  
}
```

## Graph Cycle exist or not
```
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
     * 0: Unvisited     * 1: Currently visiting     * 2: Visited     */  
    // Check if it's possible to finish all courses    for (int i = 0; i < numCourses; i++) {  
        if (visit[i] == 0 && !dfs2(i, courseToPrerequisiteList, visit)) {  
            return false;  
        }  
    }  
  
    return true;  
}  
  
// Depth-first search to explore courses and their prerequisites  
private static boolean dfs2(int course, List<List<Integer>> courseToPrerequisiteList, int[] visit) {  
    // If the course is currently being visited in the cycle, return false  
    if (visit[course] == 1) {  
        return false; // detected a cycle  
    }  
  
    // If the course is already visited and determined to be completable, return  
    // true    if (visit[course] == 2) {  
        return true;  
    }  
  
    // If the course has no prerequisites, return true  
    List<Integer> prerequisites = courseToPrerequisiteList.get(course);  
    if (prerequisites.isEmpty()) {  
        return true;  
    }  
  
    // Mark the course as currently visiting  
    visit[course] = 1;  
  
    // Explore prerequisites through DFS  
    for (Integer prerequisite : prerequisites) {  
        // If the prerequisite cannot be completed, return false  
        if (!dfs2(prerequisite, courseToPrerequisiteList, visit)) {  
            return false;  
        }  
    }  
  
    // Remove the course from the currently visiting set  
    // Mark the course as visited    visit[course] = 2;  
    return true;  
}
```