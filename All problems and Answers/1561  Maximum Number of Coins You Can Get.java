class Solution {
    public int maxCoins(int[] A) {
        Arrays.sort(A);
        int res = 0, n = A.length;
        for (int i = n / 3; i < n; i += 2)
            res += A[i];
        return res;
    }
}
