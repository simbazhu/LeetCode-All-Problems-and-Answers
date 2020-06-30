class Solution {
	public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE, sum = 0;
        for (int n : nums) {
            sum += n;
            min = Math.min(min, n);
        }
        return sum - min * nums.length;
    }
}
