class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<Integer> q = new LinkedList<>();
        if (grid[0][0] == 0) // if starting point not blocked. 
                q.offer(0);
        int n = grid.length;
        for (int steps = 1; !q.isEmpty(); ++steps) { // increase one per round of search.
            for (int sz = q.size(); sz > 0; --sz) { // breadth control.
                int x = q.peek() / n, y = q.poll() % n; // decode.
                if (x == n - 1 && y == n - 1) // find shortest path.
                    return steps; // return its length.
                for (int i = x - 1; i <= x + 1; ++i) {  // traverse 8 neighbors of (x, y)
                    for (int j = y - 1; j <= y + 1; ++j) { // (i, j) is neighbor's coordinates.
                        if (i >= 0 && i < n && j >= 0 && j < n && grid[i][j] == 0) {
                            q.offer(i * n + j); // add it into queue if it is valid, and not blocked or visited.
                            grid[i][j] = -1;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
