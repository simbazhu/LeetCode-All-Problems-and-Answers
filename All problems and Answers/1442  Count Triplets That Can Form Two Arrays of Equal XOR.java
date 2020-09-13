class Solution {
    public int countTriplets(int[] A) {
        int n = A.length + 1, res = 0, prefix[] = new int[n];
        for (int i = 1; i < n; ++i)
            prefix[i] = A[i - 1] ^ prefix[i - 1];
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j < n; ++j)
                if (prefix[i] == prefix[j])
                    res += j - i - 1;
        return res;
    }
}
