class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] s1Bucket = new int[26];
        int[] s2Bucket = new int[26];
        int index = 0, count1 = 0, count2 = 0;
        boolean smallerS1 = false, smallerS2 = false;
        for (int i = 0; i < s1.length(); i++) {
            s1Bucket[s1.charAt(i) - 'a']++;
            s2Bucket[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            count1 += s1Bucket[i];
            count2 += s2Bucket[i];
            if (count1 > count2) {
                if (smallerS2) {
                    return false;
                }         
                smallerS1 = true;
            }
            else if (count2 > count1) {
                if (smallerS1) {
                    return false;
                }
                smallerS2 = true;
            }                
        }
        return true;
    }
}
