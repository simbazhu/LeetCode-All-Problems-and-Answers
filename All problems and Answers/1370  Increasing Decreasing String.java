class Solution {
    public String sortString(String s) {
        StringBuilder ans = new StringBuilder();
        int[] count = new int[26];
        for (char c : s.toCharArray())
            ++count[c - 'a'];
        while (ans.length() < s.length()) {
            add(count, ans, true);
            add(count, ans, false);
        }
        return ans.toString();
    }
    private void add(int[] cnt, StringBuilder ans, boolean asc) {
        for (int i = 0; i < 26; ++i) {
            int j = asc ? i : 25 - i;
            if (cnt[j]-- > 0)
                ans.append((char)(j + 'a'));
        }
    }
}
