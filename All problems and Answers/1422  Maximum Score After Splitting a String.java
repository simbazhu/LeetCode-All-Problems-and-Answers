class Solution {
    public int maxScore(String s) {
        int zeros = 0, ones = 0, max = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '0') zeros++; else ones++;
            if(i != s.length()-1) max = Math.max(zeros - ones, max);
        }
        return max + ones;
    }
}
