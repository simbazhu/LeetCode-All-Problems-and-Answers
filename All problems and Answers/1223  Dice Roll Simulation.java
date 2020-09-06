class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        long p = 1_000_000_007;
        long[][] dp = new long[n + 1][6];
        long[] sum = new long[n+1];
        sum[0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < 6; ++j)  {
                for (int k = 1; k <= rollMax[j] && i - k >= 0; ++k)
                    dp[i][j] = (dp[i][j] + sum[i-k] - dp[i-k][j] + p) % p;
                sum[i] = (sum[i] + dp[i][j]) % p;
            }                
        }
        
        return (int) sum[n];
    }
}
