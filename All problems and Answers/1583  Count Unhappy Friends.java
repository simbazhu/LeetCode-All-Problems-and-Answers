class Solution {
    public int unhappyFriends(int n, int[][] ps, int[][] pairs) {
        int res = 0, pair[] = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int[] p : pairs) {
            pair[p[0]] = p[1];
            pair[p[1]] = p[0];
        }
        for (int[] p : pairs) {
            for (int x : p) {
                for (int u : ps[x]) {
                    if (u == pair[x]) break; // count before y;
                    for (int x0 : ps[u]) {
                        if (x0 == pair[u]) break; // count before v;
                        if (x0 == x) {   // find x;
                            set.add(x);
                        }
                    }
                }
            }
        }
        return set.size();
    }
}
