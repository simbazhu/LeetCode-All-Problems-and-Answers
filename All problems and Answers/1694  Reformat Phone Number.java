class Solution {
    public String reformatNumber(String number) {
        StringBuilder s = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        for(char c : number.toCharArray())
            if(Character.isDigit(c))//exclude all non-digit characters
                s.append(c);

        int n = s.length(), i = 0;

        while(i < n){
            int j = (n - i == 4) ? i + 2 : i + 3;//if we have remaining 4 digits then break it into 2 group of 2 digits otherwise 1 group of 3 digits

            while(i < n && i < j)
                sb.append(s.charAt(i++));
            if(i != n)
                sb.append('-');
        }
        return sb.toString();
    }
}
