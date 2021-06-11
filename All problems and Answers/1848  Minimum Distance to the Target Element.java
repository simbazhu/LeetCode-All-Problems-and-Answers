class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        return IntStream.range(0, nums.length).map(i -> nums[i] == target ? Math.abs(i - start) : 1000).min().getAsInt();
    }
}
