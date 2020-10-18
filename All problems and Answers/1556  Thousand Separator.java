class Solution {
    public String thousandSeparator(int n) {
        String s= Integer.toString(n);
        int j=0;
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--)
        {
            if(j==3)
            {
                sb.append(".");
                j=0;
            }
            j++;
            sb.append(s.charAt(i));
        }
        return sb.reverse().toString();
    }
}
