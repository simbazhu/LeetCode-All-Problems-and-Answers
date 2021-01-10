class Solution {
    int[] c;
    public int createSortedArray(int[] A) {
        int res = 0, n = A.length, mod = (int)1e9 + 7;
        c = new int[100001];
        for (int i = 0; i < n; ++i) {
            res = (res + Math.min(get(A[i] - 1), i - get(A[i]))) % mod;
            update(A[i]);
        }
        return res;
    }

    public void update(int x) {
        while (x < 100001) {
            c[x]++;
            x += x & -x;
        }
    }

    public int get(int x) {
        int res = 0;
        while (x > 0) {
            res += c[x];
            x -= x & -x;
        }
        return res;
    }
}
