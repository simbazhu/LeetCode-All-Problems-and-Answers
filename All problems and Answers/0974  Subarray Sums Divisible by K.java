class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int N = A.length;
        int[] P = new int[N+1];
        for (int i = 0; i < N; i++)
            P[i+1] = P[i] + A[i];
        
        int[] count = new int[K];
        for (int x: P)
            count[(x % K + K) % K]++;
        
        int ans = 0;
        for (int v: count)
            ans += v * (v - 1) / 2;
        return ans;
    }
}
