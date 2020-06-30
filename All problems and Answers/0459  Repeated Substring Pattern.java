class Solution {
    public boolean repeatedSubstringPattern(String str) {
            int len = str.length();
            for(int i=len/2 ; i>=1 ; i--) {
                if(len%i == 0) {
                    int m = len/i;
                    String subS = str.substring(0,i);
                    int j;
                    for(j=1;j<m;j++) {
                        if(!subS.equals(str.substring(j*i,i+j*i))) break;
                    }
                    if(j==m)
                        return true;
                }
            }
            return false;
    }
}
