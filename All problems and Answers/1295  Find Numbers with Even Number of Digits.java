class Solution {
    public int findNumbers(int[] nums) {
        int cnt = 0;
        for (int n : nums)
            cnt += 1 - Integer.toString(n).length() % 2;
        return cnt;
    }
}
