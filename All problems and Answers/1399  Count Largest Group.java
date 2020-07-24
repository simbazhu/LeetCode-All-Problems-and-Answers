class Solution {
    int dsum(int n) {
        return n == 0 ? 0 : n % 10 + dsum(n / 10);
    }
    public int countLargestGroup(int n) {
        ArrayList<Integer> cnt = new ArrayList<>(Collections.nCopies(37, 0));
        for (int i = 1; i <= n; ++i) {
            int c = dsum(i);
            cnt.set(c, cnt.get(c) + 1);
        }
        return Collections.frequency(cnt, Collections.max(cnt));
    }
}
