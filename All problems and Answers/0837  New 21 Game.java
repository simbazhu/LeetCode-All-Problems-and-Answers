class Solution {
    public double new21Game(int N, int K, int W) {
        if (K == 0 || N >= K + W) {
            return 1;
        }

        double result = 0;
        double Wsum = 1;
        double dp[] = new double[N + 1];
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            dp[i] = Wsum / W;
            // when points is less than K, all previous card could go to current i by only drawing one card
            if (i < K) {
                Wsum += dp[i];
            }
            // when points is equal to or more than K, all probability will be accumulated to results
            else {
                result += dp[i];
            }

            // when i is over than W, then we need to move the window
            if (i - W >= 0) {
                Wsum -= dp[i - W];
            }
        }
        return result;
    }
}
