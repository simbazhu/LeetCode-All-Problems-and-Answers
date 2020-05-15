class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int N = A.length;
        
        int ans = A[0], cur = A[0];
        for (int i = 1; i < N; i++) {
            cur = A[i] + Math.max(cur, 0);
            ans = Math.max(ans, cur);
        }
        
        // ans is the answer for 1-interval subarrays.
        // Now, let's consider all 2-interval subarrays.
        // For each i, we want to know
        // the maximum of sum(A[j:]) with j >= i+2
        
        // rightsums[i] = A[i] + A[i+1] + ... + A[N-1]
        int[] rightsums = new int[N];
        rightsums[N-1] = A[N-1];
        for (int i = N-2; i >= 0; i--)
            rightsums[i] = rightsums[i+1] + A[i];
        
        // maxright[i] = max_{j >= i} rightsums[j]
        int[] maxright = new int[N];
        maxright[N-1] = A[N-1];
        for (int i = N-2; i >= 0; i--)
            maxright[i] = Math.max(maxright[i+1], rightsums[i]);
        
        int leftsum = 0;
        for (int i = 0; i < N-2; i++) {
            leftsum += A[i];
            ans = Math.max(ans, leftsum + maxright[i+2]);
        }
        
        return ans;
    }
}
