class Solution {
    private static final int[] d = {0, 1, 0, -1, 0};
    private int m, n;
    
    public int closedIsland(int[][] grid) {
        int cnt = 0; 
        m = grid.length; n = m == 0 ? 0 : grid[0].length;
        Set<Integer> seenLand = new HashSet<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0 && seenLand.add(i * n + j)) { // (i, j) is land never seen before.
                    cnt += bfs(i, j, grid, seenLand);
                }
            }
        }    
        return cnt;
    }
    
    private int bfs(int i, int j, int[][] g, Set<Integer> seenLand) {
        int ans = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(i * n + j);
        while (!q.isEmpty()) {
            i = q.peek() / n; j = q.poll() % n;
            for (int k = 0; k < 4; ++k) { // traverse 4 neighbors of (i, j)
                int r = i + d[k], c = j + d[k + 1];
                if (r < 0 || r >= m || c < 0 || c >= n) { // out of boundary.
                    ans = 0; // set 0;
                }else if (g[r][c] == 0 && seenLand.add(r * n + c)) { // (r, c) is land never seen before.
                    q.offer(r * n + c);
                }
            }
        }
        return ans;
    }
}
