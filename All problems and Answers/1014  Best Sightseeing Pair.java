class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int res = 0, imax = 0;
        for(int i = 0; i < A.length; ++i) {
            res = Math.max(res, imax + A[i] - i);
            imax = Math.max(imax, A[i] + i);
        }
        return res;
    }
}
