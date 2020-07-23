class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int a : arr) {
            freq.put(a, 1 + freq.getOrDefault(a, 0)); // Accumulate the occurrence of a.
        }
        int ans = -1;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            if (e.getKey() == e.getValue()) {
                ans = Math.max(ans, e.getKey());
            }
        }
        return ans;
    }
}
