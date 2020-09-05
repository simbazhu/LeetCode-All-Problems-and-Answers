class Solution {
    private static final int[] d = {0, 1, 0, -1, 0};
    public int getMaximumGold(int[][] grid) {
        int ans = 0, n = grid[0].length;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < n; ++j) {
                ans = Math.max(ans, dfs(grid, i, j, n, 0, new HashSet<Integer>()));
            }
        }
        return ans;
    }
    private int dfs(int[][] g, int i, int j, int n, int sum, Set<Integer> seen) {
        if (i < 0 || i >= g.length || j < 0 || j >= n || g[i][j] == 0) return sum;
        if (!seen.add(i * n + j)) return sum; // mark (i, j) visited.
        sum += g[i][j];
        int mx = 0;
        for (int k = 0; k < 4; ++k) { // traverse 4 neighbors to get max value.
            mx = Math.max(mx, dfs(g, i + d[k], j + d[k + 1], n, sum, seen));
        }
        seen.remove(i * n + j); // reset to unvisited. 
        return mx;
    }
}
