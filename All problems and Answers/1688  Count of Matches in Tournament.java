class Solution {
    public int numberOfMatches(int n) {
        int matchCount = 0;
        
        while(n!=1)
        {
            if((n & 1)==0)// checking n is even or not
            {
                matchCount += n/2;
                n = n/2;
            }
            else
            {
                matchCount += (n-1)/2;
                n = (n-1)/2 + 1;
            }
        }
        return matchCount;
    }
}
