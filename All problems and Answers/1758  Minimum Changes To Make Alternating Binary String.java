class Solution {
    public int minOperations(String s) {
        int n = s.length(), a = 0, b = 0;
        for (int i = 0; i < n; ++i) {
         //if (s.charAt(i) - '0' == i % 2) {
           if (s.charAt(i) == '0' + i % 2) {
                ++a;
            }else {
                ++b;
            }
        }
        return Math.min(a, b);
    }
}
