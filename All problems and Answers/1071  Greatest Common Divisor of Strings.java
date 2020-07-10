class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int m = str1.length(), n = str2.length(), d = gcd(m, n);
        String s = str1.substring(0, d), str = str1 + str2;
        for (int i = 0; i < m + n; i += d) {
            if (!str.startsWith(s, i)) 
                return "";        
        }
        return s;
    }
    private int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}
