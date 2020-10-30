class Solution {
    public int specialArray(int[] nums) {
        int[] count = new int[1001];
        for (int num : nums) {
            count[num]++;
        }
        int number = nums.length;
		// the size of nums array is 100 at most
        for (int i = 0; i <= 100; i++) {
            if (number == i) {
                return i;
            }
            number -= count[i];
        }
        return -1;
    }
}
