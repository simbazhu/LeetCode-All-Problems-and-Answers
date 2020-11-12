class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int[] r : roads) {
            g.computeIfAbsent(r[0], s -> new HashSet<>()).add(r[1]);
            g.computeIfAbsent(r[1], s -> new HashSet<>()).add(r[0]);
        }
        int mx = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                Set<Integer> set1 = g.getOrDefault(i, Collections.emptySet()),
                             set2 = g.getOrDefault(j, Collections.emptySet());
                int duplicate = set1.contains(j) ? 1 : 0;
                mx = Math.max(mx, set1.size() + set2.size() - duplicate);
            }
        }
        return mx;
    }
}
