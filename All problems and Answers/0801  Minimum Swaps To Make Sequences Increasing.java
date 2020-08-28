class Solution {
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        
        /* 
		 state[i][0] is min swaps too make A[0..i] and B[0..i] increasing if we do not swap A[i] and B[i]; 
		 state[i][1] is min swaps too make A[0..i] and B[0..i] increasing if we swap A[i] and B[i].
         */
        int[][] state = new int[n][2];
        state[0][1] = 1;
        
        for (int i = 1; i < n; i++) {
            boolean areBothSelfIncreasing = A[i - 1] < A[i] && B[i - 1] < B[i];
            boolean areInterchangeIncreasing = A[i - 1] < B[i] && B[i - 1] < A[i];
            
            if (areBothSelfIncreasing && areInterchangeIncreasing) {
                state[i][0] = Math.min(state[i - 1][0], state[i - 1][1]);
                state[i][1] = Math.min(state[i - 1][0], state[i - 1][1]) + 1;
            } else if (areBothSelfIncreasing) {
                state[i][0] = state[i - 1][0];
                state[i][1] = state[i - 1][1] + 1;
            } else { // if (areInterchangeIncreasing)
                state[i][0] = state[i - 1][1];
                state[i][1] = state[i - 1][0] + 1;
            }
        }
        
        return Math.min(state[n - 1][0], state[n - 1][1]);
    }
}
