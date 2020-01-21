class Solution {
    public int[] sortArrayByParityII(int[] A) {
        for (int even = 0, odd = 1; even < A.length; even += 2) {
            if (A[even] % 2 == 1) {
                while (A[odd] % 2 == 1) {
                    odd += 2;
                }
                
                // Swap A[even] and A[odd]
                int tmp = A[even];
                A[even] = A[odd];
                A[odd] = tmp;
            }
        }
        
        return A;
    }
}
