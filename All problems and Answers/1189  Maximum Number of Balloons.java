class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] cnt = new int[26], cntBaloon = new int[26];
        for (int i = 0; i < text.length(); ++i)
            ++cnt[text.charAt(i) - 'a'];
        int min = text.length();
        for (char c : "balloon".toCharArray())
            ++cntBaloon[c - 'a'];
        for (char c : "balloon".toCharArray())
            min = Math.min(min, cnt[c - 'a'] / cntBaloon[c - 'a']);
        return min;
    }
}
