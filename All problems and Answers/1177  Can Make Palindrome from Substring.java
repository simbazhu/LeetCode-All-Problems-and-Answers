class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> ans = new ArrayList<>(); 
        int[][] cnt = new int[s.length() + 1][26];
        for (int i = 0; i < s.length(); ++i) {
            cnt[i + 1] = cnt[i].clone(); // copy previous sum.
            ++cnt[i + 1][s.charAt(i) - 'a'];
        }
        for (int[] q : queries) {
            int sum = 0; 
            for (int i = 0; i < 26; ++i) {
                sum += (cnt[q[1] + 1][i] - cnt[q[0]][i]) % 2;
            }
            ans.add(sum / 2 <= q[2]);
        }
        return ans;
    }
}
