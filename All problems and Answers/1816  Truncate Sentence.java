class Solution {
    public String truncateSentence(String s, int k) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder(words[0]);
        for (int i = 1; i < k; ++i) {
            sb.append(" " + words[i]);
        }
        return sb.toString();
    }
}
