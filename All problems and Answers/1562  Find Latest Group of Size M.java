class Solution {
    public int findLatestStep(int[] A, int m) {
        int res = -1, n = A.length;
        if (n == m) return n;
        int[] length = new int[n + 2];
        for (int i = 0; i < n; ++i) {
            int a = A[i], left = length[a - 1], right = length[a + 1];
            length[a - left] = length[a + right] = left + right + 1;
            if (left == m || right == m)
                res = i;
        }
        return res;
    }
}
