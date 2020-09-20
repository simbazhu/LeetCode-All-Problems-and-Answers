class Solution {
    public int maxSumRangeQuery(int[] A, int[][] req) {
        int res = 0, mod = (int)1e9 + 7, n = A.length;
        int[] count = new int[n];
        for (int[] r: req) {
            count[r[0]] += 1;
            if (r[1] + 1 < n)
                count[r[1] + 1] -= 1;
        }
        for (int i = 1; i < n; ++i)
            count[i] += count[i - 1];
        Arrays.sort(A);
        Arrays.sort(count);
        for (int i = 0; i < n; ++i)
            res = (res + A[i] * count[i]) % mod;
        return res;
    }
}
