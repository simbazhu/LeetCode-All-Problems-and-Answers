class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> index = new HashMap();
        for (int i = 0; i < order.length(); i++)
            index.put(order.charAt(i), i);
        
        search: for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            
            // Find the first difference word1[k] != word2[k].
            for (int k = 0; k < Math.min(word1.length(), word2.length()); k++) {
                if (word1.charAt(k) != word2.charAt(k)) {
                    // If they compare badly, it's not sorted.
                    if (index.get(word1.charAt(k)) > index.get(word2.charAt(k)))
                        return false;
                    continue search;
                }
            }
            
            // If we didn't find a first difference, the
            // words are like ("app", "apple").
            if (word1.length() > word2.length())
                return false;
        }
        
        return true;
    }
}
