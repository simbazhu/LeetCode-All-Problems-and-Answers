class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length, res = nums[0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.add(new int[] { nums[0], 0 });
        for(int i = 1; i < n; i++) {
            while(pq.peek()[1] < i - k) pq.poll();
            pq.add(new int[] { res = pq.peek()[0] + nums[i], i });
        }
        return res;
    }
}
