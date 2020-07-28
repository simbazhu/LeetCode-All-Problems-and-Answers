class Solution {
    public double average(int[] salary) {
        double sum = 0;
        int M = Integer.MIN_VALUE, m = Integer.MAX_VALUE;
        for (int s : salary) {
            m = Math.min(m, s);
            M = Math.max(M, s);
            sum += s;
        }
        return (sum - m - M) / (salary.length - 2);
    }
}
