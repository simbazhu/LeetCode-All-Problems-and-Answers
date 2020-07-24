class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int sub_sum = 0, total_sum = 0;
        for (int n : nums) {
            pq.offer(n);
            total_sum += n;
        }
        while (sub_sum <= total_sum / 2) {
            res.add(pq.peek());
            sub_sum += pq.poll();
        }    
        return res;
    }
}
