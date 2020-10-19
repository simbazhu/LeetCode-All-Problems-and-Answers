class Solution {
    public List<Integer> mostVisited(int n, int[] A) {
        List<Integer> res = new ArrayList<>();
        for (int i = A[0]; i <= A[A.length - 1]; ++i)
            res.add(i);
        if (res.size() > 0) return res;
        for (int i = 1; i <= A[A.length - 1]; ++i)
            res.add(i);
        for (int i = A[0]; i <= n; ++i)
            res.add(i);
        return res;
    }
}
