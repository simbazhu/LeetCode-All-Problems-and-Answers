class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0, minPrefixSum = 0;
        for (int n : nums) {
            sum += n;
            minPrefixSum = Math.min(sum, minPrefixSum);
        }
        return 1 - minPrefixSum;
    }
}
