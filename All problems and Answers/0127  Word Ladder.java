class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<String>();
        for(String w : wordList) {
            words.add(w);
        }
        if(!words.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.remove();
                if(cur.equals(endWord)) return level + 1;
                for(int j = 0; j < cur.length(); j++){
                    char[] word = cur.toCharArray();
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        word[j] = ch;
                        String check = new String(word);
                        if(!check.equals(cur) && words.contains(check)){
                            queue.add(check);
                            words.remove(check);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
