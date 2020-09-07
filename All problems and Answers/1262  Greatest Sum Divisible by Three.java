class Solution {
    public int maxSumDivThree(int[] nums) {
        //init: dp[i] = max sum such that the remainder == i when sum / 3 
        //dp[0]=0: max sum such that the remainder == 0 when 0 / 3 is 0
        //dp[1]=-Inf: max sum such that the remainder == 1 when 0 / 3 does not exist
        //dp[2]=-Inf: max sum such that the remainder == 2 when 0 / 3 does not exist
        int[] dp = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for(int num : nums){
            int[] temp = new int[3];
            //dp transition
            for(int remainder=0; remainder<3; remainder++){
                //updating each remainder for current "num"
                temp[(num+remainder)%3] = Math.max(dp[(num+remainder)%3], dp[remainder]+num);
            }
            //rotating array
            dp = temp; 
        }
        //return: max sum such that the remainder == 0 when sum / 3 
        return dp[0];
    }
}
