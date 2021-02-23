class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] cnt = new int[46]; 
        int max = 0;
        for (int i = lowLimit; i <= highLimit; ++i) {
            int num = i, sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            max = Math.max(++cnt[sum], max);
        }
        return max;
    }
}
