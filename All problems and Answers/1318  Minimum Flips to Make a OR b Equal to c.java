class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0, ab = a | b, equal = ab ^ c;
        for (int i = 0; i < 31; ++i) {
            int mask = 1 << i;
            if ((equal & mask) > 0)  // ith bits of a | b and c are not same, need at least 1 flip.
             // ans += (ab & mask) < (c & mask) || (a & mask) != (b & mask) ? 1 : 2;
                ans += (a & mask) == (b & mask) && (c & mask) == 0 ? 2 : 1; // ith bits of a and b are both 1 and that of c is 0?
        }
        return ans;
    }
}
