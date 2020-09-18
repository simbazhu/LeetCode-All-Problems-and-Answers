class Solution {
    public int minFlips(String target) {
        char prev = '0';
        int res = 0;
        for (char c : target.toCharArray()) {
            if (c != prev) {
                res++;
                prev = c;
            }
        }
        return res;
    }
}
