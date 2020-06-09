class Solution {
    public String reorganizeString(String S) {
        int N = S.length();
        int[] counts = new int[26];
        for (char c: S.toCharArray()) counts[c-'a'] += 100;
        for (int i = 0; i < 26; i++) counts[i] += i;
        //Encoded counts[i] = 100*(actual count) + (i)
        Arrays.sort(counts);
        
        char[] ans = new char[N];
        int t = 0;
        for (int j = counts.length - 1; j >= 0; j--) {
            int code = counts[j];
            int ct = code / 100;
            char ch = (char) ('a' + (code % 100));
            if (ct > (N+1) / 2) return "";
            for (int i = 0; i < ct; i++) {
                if (t >= N) t = 1;
                ans[t] = ch;
                t += 2;
            }
        }
        
        return String.valueOf(ans);
    }
}
