class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> factorList = new ArrayList<>();
        for (int factor = 1; factor * factor <= n; ++factor) {
            if (n % factor == 0) {
                if (factor * factor != n) {
                    factorList.add(factor);
                }
                if (--k == 0) {
                    return factor;
                }
            }
        }
        int size = factorList.size();
        return k > size ? -1 : n / factorList.get(size - k);
    }
}
