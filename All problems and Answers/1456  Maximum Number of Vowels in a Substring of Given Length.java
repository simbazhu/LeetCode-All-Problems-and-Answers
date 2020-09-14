class Solution {
    public int maxVowels(String s, int k) {
        int ans = 0;
        // Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        var vowels = Set.of('a', 'e', 'i', 'o', 'u'); // Java 11 Collection factory method, credit to @Sithis
        for (int i = 0, winCnt = 0; i < s.length(); ++i) {
            if (vowels.contains(s.charAt(i))) {
                ++winCnt; 
            }
            if (i >= k && vowels.contains(s.charAt(i - k))) {
                --winCnt;
            }
            ans = Math.max(winCnt, ans);
        }
        return ans;
    }
}
