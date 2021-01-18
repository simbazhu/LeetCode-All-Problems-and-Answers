class Solution {
    public int maxOperations(int[] nums, int k) {
        if (nums.length <= 1) {
            return 0;
        }
        int res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            if (count.getOrDefault(k - num, 0) > 0) {
                count.put(k - num, count.get(k - num) - 1);
                ++res;
            } else {
                count.put(num, 1 + count.getOrDefault(num, 0));
            }
        }
        return res;
    }
}
