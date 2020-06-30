class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) != '-') {
                sb.append(sbLength % k == 0 && sbLength != 0 ? '-' : "").append(s.charAt(i));
                sbLength++;
            }
        return sb.reverse().toString().toUpperCase();
    } 
}
