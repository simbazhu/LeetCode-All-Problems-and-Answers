class Solution {
    public String freqAlphabets(String s) {
      String res = "";
      for (int i = 0; i < s.length(); ++i) {
        if (i < s.length() - 2 && s.charAt(i + 2) == '#') {
          res += (char)('j' + (s.charAt(i) - '1') * 10 + s.charAt(i + 1) - '0');
          i += 2;
        }
        else res += (char)('a' + (s.charAt(i) - '1'));
      }
      return res;
    }
}
