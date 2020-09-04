class Solution {
    public int maxRepOpt1(String text) {
        if (text == null || text.length() == 0) return 0;
        int[] freq = new int[26];
        List<int[]> locs = new ArrayList<>();
        int left = 0;
        // record all pairs of character and length
        for (int i = 0; i <= text.length(); i++) {
            if (i < text.length()) freq[text.charAt(i) - 'a']++;
            if (i == text.length() || text.charAt(i) != text.charAt(left)) {
                locs.add(new int[]{text.charAt(left), i - left});
                left = i;
            }
        }
        int res = 0;
        for (int i = 0; i < locs.size(); i++) {
            int len = locs.get(i)[1];
            // if the character of the ith segment is the same as the (i + 2)th segment and the length
            // of the (i + 1) segment is 1, then combine the ith and (i + 2)th segments
            if (i + 2 < locs.size() && locs.get(i + 2)[0] == locs.get(i)[0] && locs.get(i + 1)[1] == 1) {
                len += locs.get(i + 2)[1];
            }
            res = Math.max(res, len + (len < freq[locs.get(i)[0] - 'a'] ? 1 : 0));
        }
        return res;
    }
}
