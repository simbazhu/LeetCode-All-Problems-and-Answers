class Solution {
    int[] prts;  //parents for union-find
    public int minCostConnectPoints(int[][] ps) {
        int m = ps.length, islands = m, res = 0, dist[][] = new int[m][m];  // dist is cache for distance of each edge.
        prts = new int[m];
        for (int i = 0;  i < m; i++) prts[i] = i;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> dist[a[0]][a[1]] - dist[b[0]][b[1]]);
        for (int i = 0; i < m; i++) 
            for (int j = i + 1; j < m; j++) {
                dist[i][j] = Math.abs(ps[i][0] - ps[j][0]) + Math.abs(ps[i][1] - ps[j][1]);
                pq.offer(new int[]{i, j});
            }
        while (!pq.isEmpty() && islands > 1) {
            int[] p = pq.poll();
            if (union(p[0], p[1])) {
                res += dist[p[0]][p[1]];
                islands--;
            }
        }
        return res;
    }
    
    private boolean union(int i, int j) {
        int ip = find(i), jp = find(j);
        if (ip == jp) return false;
        prts[ip] = jp;
        return true;
    }
    
    private int find(int i) {
        int ip = prts[i];
        if (ip != i) {
            prts[i] = find(ip);
        }
        return prts[i];
    }
}
