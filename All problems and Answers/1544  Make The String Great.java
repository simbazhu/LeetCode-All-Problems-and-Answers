class Solution {
    public String makeGood(String s) {
        var ans = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (ans.length() > 0 && (ans.charAt(ans.length() - 1) ^ 32) == c) {
                ans.deleteCharAt(ans.length() - 1);
            } else {
                ans.append(c);
            }
        }
        return ans.toString();       
    }
}
