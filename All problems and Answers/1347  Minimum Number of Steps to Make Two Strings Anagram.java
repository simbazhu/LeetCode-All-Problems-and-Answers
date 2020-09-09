class Solution {
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++count[s.charAt(i) - 'a']; // count the occurrences of chars in s.
            --count[t.charAt(i) - 'a']; // compute the difference between s and t.
        }
        return Arrays.stream(count).map(Math::abs).sum() / 2; // sum the absolute of difference and divide it by 2.
    }
}
