class Solution {
    public int superpalindromesInRange(String L, String R) {
        List<Long> palindromes = new ArrayList<>();
        long low = Long.parseLong(L);
        long high = Long.parseLong(R);
        int res = 0;
        for (long i = 1; i <= 9; i++) {
            palindromes.add(i);
        }
        for (long i = 1; i < 10000; i++) {
            String left = Long.toString(i);
            String right = new StringBuilder(left).reverse().toString();
            palindromes.add(Long.parseLong(left + right));
            for (long d = 0; d < 10; d++) {
                palindromes.add(Long.parseLong(left + d + right));
            }
        }
        for (long palindrome : palindromes) {
            long square = palindrome * palindrome;
            if (!isPalindrome(Long.toString(square))) {
                continue;
            }
            if (low <= square && square <= high) {
                res++;
            }
        }
        return res;
    }
    
    private boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
