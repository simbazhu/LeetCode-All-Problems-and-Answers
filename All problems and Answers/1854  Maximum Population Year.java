class Solution {
    public int maximumPopulation(int[][] logs) {
        int pop[] = new int[2051], res = 0;
        for (var l : logs) {
            ++pop[l[0]];
            --pop[l[1]];
        }
        for (int i = 1950; i < 2050; ++i) {
            pop[i] += pop[i - 1];
            res = pop[i] > pop[res] ? i : res;
        }
        return res;
    }
}
