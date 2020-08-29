class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();
        int n = fronts.length;
        for (int i = 0; i < n; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (!set.contains(backs[i])) {
                min = Math.min(min, backs[i]);
            }
            if (!set.contains(fronts[i])) {
                min = Math.min(min, fronts[i]);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
