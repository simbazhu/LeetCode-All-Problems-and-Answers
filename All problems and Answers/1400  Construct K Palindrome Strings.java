class Solution {
    public boolean canConstruct(String s, int k) {
        int odd = 0, n = s.length(), count[] = new int[26];
        for (int i = 0; i < n; ++i) {
            count[s.charAt(i) - 'a'] ^= 1;
            odd += count[s.charAt(i) - 'a'] > 0 ? 1 : -1;
        }
        return odd <= k && k <= n;
    }
}
