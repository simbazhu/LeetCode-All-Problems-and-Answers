class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>(Arrays.asList(0));
        int prefixSum = 0, count = 0;
        for (int num : nums) {
            prefixSum += num;
            if (seen.contains(prefixSum - target)) {
                ++count;
                prefixSum = 0;
                seen = new HashSet<>();
            }
            seen.add(prefixSum);
        }
        return count;
    }
}
