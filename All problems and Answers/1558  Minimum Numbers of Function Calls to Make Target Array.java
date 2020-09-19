class Solution {
    public int minOperations(int[] A) {
        int res = 0, maxLen = 1;
        for (int a : A) {
            int bits = 0;
            while (a > 0) {
                res += a & 1;
                bits++;
                a >>= 1;
            }
            maxLen = Math.max(maxLen, bits);
        }
        return res + maxLen - 1;
    }
}
