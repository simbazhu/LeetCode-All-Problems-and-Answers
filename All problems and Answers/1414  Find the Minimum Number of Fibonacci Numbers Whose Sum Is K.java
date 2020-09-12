class Solution {
    public int findMinFibonacciNumbers(int k) {
        if (k < 2) return k;
        TreeSet<Integer> set = new TreeSet<>();
        for (int a = 0, b = 1; b < k;) {
            int tmp = b; 
            b += a;
            a = tmp;
            set.add(b);
        }
        int res = 0;
        while (k > 0) {
            int fib = set.floor(k);
            k -= fib;
            res++;
        }
        return res;
    }
}
