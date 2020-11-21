class Solution {
    public int atMostNGivenDigitSet(String[] D, int N) {
        int result = 0;
        for(int i=1;i<=Integer.toString(N).length();i++){
            result += helper(D,i,Integer.toString(N));
        }
        return result;
    }
    
    //exactly N digit
    public int helper(String[] D, int K, String smax){
        if (smax.equals("0")) {
            return 0;
        }
        // String smax = Integer.toString(max);
        if(smax.length()>K){
            return (int)Math.pow(D.length,K);
        }
        int count=0;
        for(int i=0;i<D.length;i++){
            int char0 = smax.charAt(0) - '0';
            if(Integer.parseInt(D[i])<char0){
                count += helper(D,K-1,smax);
            }
            if(Integer.parseInt(D[i])==char0){
                if (smax.length() > 1) {
                    int charRem = Integer.parseInt(smax.substring(1, 2)) == 0 ? 0 : Integer.parseInt(smax.substring(1));
                    count += helper(D, K - 1, Integer.toString(charRem));
                } else {
                    count++;
                }

            }
        }
        return count;
    }
}
