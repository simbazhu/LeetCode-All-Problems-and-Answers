class Solution {
    public int sumOfUnique(int[] nums) {
        int[] cnt = new int[101];
        for (int n : nums) {
            ++cnt[n];
        }
        int sum = 0;
        for (int i = 1; i <= 100; ++i) {
            if (cnt[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }
}
