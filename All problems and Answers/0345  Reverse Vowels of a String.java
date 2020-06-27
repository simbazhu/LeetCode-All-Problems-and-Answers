class Solution {
    public String reverseVowels(String s) {
        if (s.length() == 0) return s;
        
        Set<Character> set = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] a = s.toCharArray();
        
        int j = s.length() - 1, i = 0;
        while (i < j) {
            while (i < j && !set.contains(a[i])) {
                i++;
            }
            
            while (i < j && !set.contains(a[j])) {
                j--;
            }
            
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        
        return String.valueOf(a);
    }
}
