# DSA-Mastery
## 🗺️ Graph Challenges:
- [Fundamentals Of Graph Theory](https://www.geeksforgeeks.org/fundamentals-of-graph-theory/)

### Representation Of Graph:
- [Adjacency Matrix](https://www.geeksforgeeks.org/adjacency-matrix/)
- [Adjacency List](https://www.programiz.com/dsa/graph-adjacency-list)

### Graph Traversal:
- [BFS](https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/)
- [DFS](https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/)
- [BFS Practice Problem](https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1)
- [DFS Practice Problem](https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1)

### Shortest Path Problems:
- [Shortest Path in Matrix (BFS)](https://leetcode.com/problems/shortest-path-in-binary-matrix/)
- [Distance of Nearest Cell Having 1 (BFS)](https://www.geeksforgeeks.org/distance-of-nearest-cell-having-1-in-a-binary-matrix/)
- [All Nodes Distance K in Binary Tree (DFS/BFS)](https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/)
- [Map of Highest Peak (BFS)](https://leetcode.com/problems/map-of-highest-peak/)
- [Rotten Oranges (BFS)](https://leetcode.com/problems/rotting-oranges/)
- [As Far from Land as Possible (BFS)](https://leetcode.com/problems/as-far-from-land-as-possible/)
-[shortest path to get all keys](https://leetcode.com/problems/shortest-path-to-get-all-keys/?envType=study-plan-v2&envId=graph-theory)

### DFS Problems:
### Note : we can solve below patterns using bfs also but for better readbilty we will go through dfs technique
```java
class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        int[][] dir = new int[][]{
            {0 , -1} , {0 , +1} , {1 , 0} , {-1 , 0}
        };
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid , i , j , dir);
                }
            }
        }
        return count;
        
    }
    public void dfs(char[][] grid, int row, int col, int[][] dir) {
        grid[row][col] = '0'; // Mark the cell as visited

        for (int i = 0; i < 4; i++) {
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];

            // Check if the new coordinates are within bounds and if the cell is land ('1')
            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1') {
                dfs(grid, nr, nc, dir);
            }
        }
    }
}
```
- [Number of Islands](https://leetcode.com/problems/number-of-islands/)  
- [Surrounded Regions](https://leetcode.com/problems/surrounded-regions/)  
- [Number of Provinces](https://leetcode.com/problems/number-of-provinces/)  
- [Number of Enclaves](https://leetcode.com/problems/number-of-enclaves/)  
- [Max Area of Island](https://leetcode.com/problems/max-area-of-island/)  
- [Number Of Closed Islands](https://leetcode.com/problems/number-of-closed-islands/)  
- [Surrounded Regions](https://leetcode.com/problems/surrounded-regions/)  

### ToplLogical Sort
```java
class Solution
{
    // Function to return a list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // Step 1: Initialize an array to store the in-degree of each vertex
        int[] indegree = new int[V];
        
        // Calculate the in-degree of each vertex
        for(ArrayList<Integer> arr : adj) {
            for(int u : arr) {
                indegree[u]++; // Increment in-degree for each adjacent vertex
            }
        }

        // Step 2: Create a queue to hold all vertices with in-degree of 0
        Queue<Integer> queue = new LinkedList<>();
        
        // Add all vertices with in-degree 0 to the queue
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                queue.add(i); // Vertex with no incoming edges
            }
        }

        // Step 3: Initialize an array to store the topological order
        int[] topologicalOrder = new int[V];
        int j = 0; // Index for the topological order array
        
        // Process the queue until it's empty
        while(!queue.isEmpty()) {
            int size = queue.size(); // Get the number of vertices in the queue
            
            // Process each vertex in the current level
            for(int i = 0; i < size; i++) {
                int u = queue.poll(); // Remove a vertex from the queue
                topologicalOrder[j++] = u; // Add it to the topological order
                
                // Decrease the in-degree of all its adjacent vertices
                for(int v : adj.get(u)) {
                    indegree[v]--; // Reduce in-degree of vertex v
                    // If in-degree of v becomes 0, add it to the queue
                    if(indegree[v] == 0) {
                        queue.add(v);
                    }
                }
            }
        }
        
        // Return the final topological order
        return topologicalOrder;
    }
}
```
-[Topological Sorting](https://www.geeksforgeeks.org/problems/topological-sort/1)<br>
-[Direct Graph Cycle](https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1)<br>
-[Course Schedule](https://leetcode.com/problems/course-schedule/description/)<br>
-[Course Schedule ii](https://leetcode.com/problems/course-schedule-ii/description/?)<br>
-[Alien Dictionary](https://www.geeksforgeeks.org/problems/alien-dictionary/1)<br>
-[Largest color value in a directed graph](https://leetcode.com/problems/largest-color-value-in-a-directed-graph/description/)<br>

### Shortest Path Problem
-[Shortest path in undirected graph - having unit weight](https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1)<br>
-[Dijkstra Algorithm](https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1)<br>
-[Jumping Game](https://practice.geeksforgeeks.org/contest/gfg-weekly-169-rated-contest/problems)<br>
-[minimum cost path in grid](https://www.geeksforgeeks.org/problems/minimum-cost-path3833/1)<br>
-[Print Shortest Path](https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1)<br>
-[Path With Minimum Effort](https://leetcode.com/problems/path-with-minimum-effort/description/)<br>
-[Cheapest flights with k stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/description/)<br>
-[Number of ways to arrive the destination](https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/)<br>



## 🎯 Dynamic Programming Challenges

This section contains various problems categorized under dynamic programming (DP).

### 1D DP (Single Parameter):

- **Fibonacci Number** - [Fibonacci Number](https://leetcode.com/problems/fibonacci-number/description/)
- **Climbing Stairs** - [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/description/)
- **Counting Bits** - [Counting Bits](https://leetcode.com/problems/counting-bits/description/)
- **Tom And Jerry** - [Tom And Jerry](https://practice.geeksforgeeks.org/problems/tom-and-jerry1325/1)
- **House Robber** - [House Robber](https://leetcode.com/problems/house-robber/description/)
- **House Robber-ii** - [House Robber-ii](https://leetcode.com/problems/house-robber-ii/)
- **Delete And Earn** - [Delete And Earn](https://leetcode.com/problems/delete-and-earn/)

### Subset Sum and Knapsack Problems

- **Subset Sum Equal to K** - [Subset Sum Equal to K](https://www.geeksforgeeks.org/subset-sum-problem-dp-25/)
- **Partition Equal Subset Sum** - [Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)
- **Count Subset Sum with K** - [Count Subset Sum with K](https://www.geeksforgeeks.org/count-subsets-with-sum-equal-to-k/)
- **Partitions with Given Difference** - [Partitions with Given Difference](https://leetcode.com/problems/partition-equal-subset-sum/)
- **Target Sum** - [Target Sum](https://leetcode.com/problems/target-sum/)
- **0/1 Knapsack Problem** - [0/1 Knapsack Problem](https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/)
- **Coin Change** - [Coin Change](https://leetcode.com/problems/coin-change/)
- **Coin Change II** - [Coin Change II](https://leetcode.com/problems/coin-change-2/)
- **Unbounded Knapsack** - [Unbounded Knapsack](https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/)
- **Rod Cutting** - [Rod Cutting](https://www.geeksforgeeks.org/rod-cutting-dp-13/)


### DP On Grids (Two Parameter):

- **Ninjas Training** - [Ninjas Training](https://www.codingninjas.com/studio/problems/ninja-s-training_3621003)
- **Unique Paths** - [Unique Paths](https://leetcode.com/problems/unique-paths/)
- **Unique Paths II** - [Unique Paths II](https://leetcode.com/problems/unique-paths-ii/)
- **Triangle** - [Triangle](https://leetcode.com/problems/triangle/)
- **Minimum Falling Path Sum in Matrix** - [Minimum Falling Path Sum in Matrix](https://leetcode.com/problems/minimum-falling-path-sum/)

### Dp On Longest Common Subsequence

- **Longest Common Subsequence** - [Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/)
- **Print LCS** - [Print LCS](https://www.geeksforgeeks.org/print-longest-common-subsequence/)
- **Longest Common Substring** - [Longest Common Substring](https://www.geeksforgeeks.org/longest-common-substring-dp-29/)
- **Longest Palindromic Subsequence** - [Longest Palindromic Subsequence](https://leetcode.com/problems/longest-palindromic-subsequence/)
- **Minimum Insertions Required to Make Palindrome** - [Minimum Insertions](https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/)
- **Delete Operation for Two Strings** - [Delete Operation](https://leetcode.com/problems/delete-operation-for-two-strings/)
- **Length of Shortest Common Supersequence** - [Shortest Common Supersequence](https://leetcode.com/problems/shortest-common-supersequence/)
- **Shortest Common Supersequence** - [Shortest Common Supersequence](https://leetcode.com/problems/shortest-common-supersequence/)
- **Wildcard Matching** - [Wildcard Matching](https://leetcode.com/problems/wildcard-matching/)
- **Distinct Subsequences** - [Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences/)
- **Edit Distance** - [Edit Distance](https://leetcode.com/problems/edit-distance/)

### Stock Trading Problems

- **Best Time to Buy and Sell Stock** - [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
- **Best Time to Buy and Sell Stock II** - [Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)
- **Best Time to Buy and Sell Stock III** - [Best Time to Buy and Sell Stock III](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)
- **Best Time to Buy and Sell Stock with Cooldown** - [Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)
- **Best Time to Buy and Sell Stock with Transaction Fee** - [Best Time to Buy and Sell Stock with Transaction Fee](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)

### Longest Increasing Subsequence (LIS) Problems

- **Longest Increasing Subsequence (LIS)** - [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)
- **Minimum Number of Deletions to Make a Sorted Sequence** - [Minimum Number of Deletions](https://leetcode.com/problems/minimum-number-of-deletions-to-make-a-sorted-sequence/)
- **Maximum Sum Increasing Subsequence** - [Maximum Sum Increasing Subsequence](https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence/)
- **Longest Bitonic Subsequence** - [Longest Bitonic Subsequence](https://www.geeksforgeeks.org/longest-bitonic-subsequence/)
- **Longest String Chain** - [Longest String Chain](https://leetcode.com/problems/longest-string-chain/)
- **Number of Longest Increasing Subsequence** - [Number of Longest Increasing Subsequence](https://leetcode.com/problems/number-of-longest-increasing-subsequence/)

### Partition Pattern Problems

- **Palindromic Substrings** - [Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/)
- **Matrix Chain Multiplication (MCM)** - [Matrix Chain Multiplication](https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/)



   
