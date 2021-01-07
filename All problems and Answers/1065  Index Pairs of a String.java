class Solution {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> result = new ArrayList<int[]>();
        // build Trie
        Trie root = new Trie();
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            Trie r = root;
            for(char c: word.toCharArray()) {
                if(r.children[c-'a']==null) {
                    r.children[c-'a'] = new Trie();
                }
                r = r.children[c-'a'];
            }
            r.isWord = true;
        }
        // use Trie to search word
        for(int i=0; i<text.length(); i++) {
            Trie r = root;
            if(r.children[text.charAt(i) - 'a'] != null) {
                int j=i;
                while(j < text.length() && r.children[text.charAt(j) - 'a'] != null) {
                    r = r.children[text.charAt(j) - 'a'];
                    if(r.isWord) {
                        result.add(new int[]{i, j});
                    }
                    j += 1;
                }
            }
        }
        return result.toArray(new int[0][]);
    }
    
    class Trie {
        Trie[] children = new Trie[26];
        boolean isWord = false;
    }
}
