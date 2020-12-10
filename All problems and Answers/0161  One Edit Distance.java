class Solution {
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++) {
            if (s.charAt(i) != t.charAt(j)) {
               return s.substring(i).equals(t.substring(j + 1)) ||
                   s.substring(i + 1).equals(t.substring(j)) ||
                   s.substring(i + 1).equals(t.substring(j + 1));
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}
