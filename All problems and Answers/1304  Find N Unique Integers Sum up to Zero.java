class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        for (int start = 0, end = n - 1; start < end; ++start, --end) {
            ans[start] = -end;
            ans[end] = end;
        }
        return ans;
    }
}
