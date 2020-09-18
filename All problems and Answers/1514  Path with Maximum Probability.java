class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<int[]>> g = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            int a = edges[i][0], b = edges[i][1];
            g.computeIfAbsent(a, l -> new ArrayList<>()).add(new int[]{b, i});    
            g.computeIfAbsent(b, l -> new ArrayList<>()).add(new int[]{a, i});    
        }
        double[] p = new double[n];
        p[start] = 1d;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingDouble(i -> -p[i]));
        pq.offer(start);
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            if (cur == end) {
                return p[end];
            }
            for (int[] a : g.getOrDefault(cur, Collections.emptyList())) {
                int neighbor = a[0], index = a[1];
                if (p[cur] * succProb[index] > p[neighbor]) {
                    p[neighbor] = p[cur] * succProb[index];
                    pq.offer(neighbor);
                }
            }
        }
        return 0d;
    }
}
