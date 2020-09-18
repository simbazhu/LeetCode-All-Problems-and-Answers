class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            g.computeIfAbsent(e[0], l -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], l -> new ArrayList<>()).add(e[0]);
        }
        int[] ans = new int[n];
        dfs(g, 0, -1, labels, ans);
        return ans;
    }
    private int[] dfs(Map<Integer, List<Integer>> g, int node, int parent, String labels, int[] ans) {
        int[] cnt = new int[26];
        char c = labels.charAt(node);
        for (int child : g.getOrDefault(node, Collections.emptyList())) {
            if (child != parent) {
                int[] sub = dfs(g, child, node, labels, ans);
                for (int i = 0; i < 26; ++i) {
                    cnt[i] += sub[i];
                }
            }
        }
        ++cnt[c - 'a'];
        ans[node] = cnt[c - 'a'];
        return cnt;
    }
}
