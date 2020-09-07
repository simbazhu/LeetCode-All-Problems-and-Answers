class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for (int digit = 1; digit < 9; ++digit) {
            int next = digit, n = next;
            while (n <= high && next < 10) {
                if (n >= low) {
                    res.add(n);
                }
                int n1 = n * 10 + ++next;
                if (n1 > n) {
                    n = n1;
                }else { // Integer overflow.
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;        
    }
}
