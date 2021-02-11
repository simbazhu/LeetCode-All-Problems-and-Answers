class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int alphabet = 0, cnt = 0;
        for (int i = 0; i < allowed.length(); ++i) {
            int shift = allowed.charAt(i) - 'a';
            alphabet |= 1 << shift;
        } 
        outer:
        for (String w : words) {
            for (int i = 0; i < w.length(); ++i) {
                if ((alphabet & (1 << w.charAt(i) - 'a')) == 0) {
                    continue outer;
                }
            }
            ++cnt;
        }
        return cnt;
    }
}
