class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        // Each vertex has 2 values for starting from red and blue edges, respectively.
        int[][] steps = new int[2][n];
        // Initialized with MAX values, except that 2 starting points initialized with 0.
        Arrays.fill(steps[0], 1, n, Integer.MAX_VALUE);
        Arrays.fill(steps[1], 1, n, Integer.MAX_VALUE);
        // DFS
        dfs(0, 0, 0, steps, red_edges, blue_edges);
        dfs(0, 1, 0, steps, red_edges, blue_edges);
        // Compare the 2 paths for each vertex and choose the shorter one.
        for (int i = 1; i < n; ++i) {
            int shorter = Math.min(steps[0][i], steps[1][i]);
            steps[0][i] = shorter == Integer.MAX_VALUE ? -1 : shorter;
        }
        return steps[0];
    }
    private void dfs(int v, int color, int cnt, int[][] steps, int[][] red_edges, int[][] blue_edges) {
        int[][] edges = color == 0 ? red_edges : blue_edges;
        for (int[] vertex : edges) {
            if (v == vertex[0] && steps[1 - color][vertex[1]] > cnt + 1) {
                steps[1 - color][vertex[1]] = cnt + 1;
                dfs(vertex[1], 1 - color, cnt + 1, steps, red_edges, blue_edges);
            }
        }
    }
}
