class Solution {
    public boolean wordBreak(String s, List<String> dict) {
      if (s == null || s.length() == 0) return false;

      int n = s.length();

      // dp[i] represents whether s[0...i] can be formed by dict
      boolean[] dp = new boolean[n];

      for (int i = 0; i < n; i++) {
        for (int j = 0; j <= i; j++) {
          String sub = s.substring(j, i + 1);

          if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
            dp[i] = true;
            break;
          }
        }
      }

      return dp[n - 1];
    }
}
