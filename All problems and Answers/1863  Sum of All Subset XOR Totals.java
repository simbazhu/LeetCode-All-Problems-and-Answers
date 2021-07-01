class Solution {
    public int subsetXORSum(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res |= num;
        }
        return res * (1 << nums.length - 1);
    }
}
