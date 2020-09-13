class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        
        for (int last = -1, i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (last != -1 && i - last  - 1 < k) return false;
                last = i;
            }
        }
        return true;
    }
}
