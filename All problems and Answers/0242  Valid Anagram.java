class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashmap.put(s.charAt(i), hashmap.getOrDefault(s.charAt(i), 0) + 1);
            hashmap.put(t.charAt(i), hashmap.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (Map.Entry<Character, Integer> entry : hashmap.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
