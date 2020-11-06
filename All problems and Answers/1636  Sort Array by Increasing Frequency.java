class Solution {
    public int[] frequencySort(int[] nums) {
        var freq = new HashMap<Integer, Integer>();
        for (int n : nums) {
            freq.put(n, 1 + freq.getOrDefault(n, 0));
        }
        var pq = new PriorityQueue<Integer>((i, j) -> freq.get(i) == freq.get(j) ? j - i : freq.get(i) - freq.get(j));
        for (int n : nums) {
            pq.offer(n);
        }
        int i = 0;
        int[] ans = new int[nums.length];
        while(!pq.isEmpty()) {
            ans[i++]= pq.poll();
        }
        return ans;
    }
}
