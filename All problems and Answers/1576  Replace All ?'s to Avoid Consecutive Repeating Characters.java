class Solution {
    public String modifyString(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == '?') {
                for (char c = 'a'; c <= 'c'; c++) {
                    if (i > 0 && arr[i-1] == c) continue;
                    if (i + 1 < n && arr[i + 1] == c) continue;
                    arr[i] = c;
                    break;
                }
            }
        }
        return String.valueOf(arr);
    }
}
