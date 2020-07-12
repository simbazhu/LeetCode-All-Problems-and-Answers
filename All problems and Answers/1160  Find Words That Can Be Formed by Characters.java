class Solution {
    public int countCharacters(String[] words, String chars) {
        int cnt[] = new int[26], ans = 0;
        chars.chars().forEach(c -> ++cnt[c - 'a']); // count chars.
outer: 
        for (String w : words) {
            int[] count = cnt.clone();
            for (char c : w.toCharArray())
                if (--count[c - 'a'] < 0) // not enough, continue next word in words.
                    continue outer;
            ans += w.length();
        }
        return ans;
    }
}
