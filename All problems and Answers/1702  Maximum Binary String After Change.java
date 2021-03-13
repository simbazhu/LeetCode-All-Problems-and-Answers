class Solution {
    public String maximumBinaryString(String s) {
        int ones = 0, zeros = 0, n = s.length();
        StringBuilder res = new StringBuilder("1".repeat(n));
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '0')
                zeros++;
            else if (zeros == 0)
                ones++;
        }
        if (ones < n)
            res.setCharAt(ones + zeros - 1, '0');
        return res.toString();
    }
}
