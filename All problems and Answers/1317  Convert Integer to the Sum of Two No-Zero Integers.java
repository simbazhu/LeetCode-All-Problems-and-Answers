class Solution {
    public int[] getNoZeroIntegers(int n) {
        int A = 1, B = n-1;
        while(containsZero(B) || containsZero(A)) {
            B--;
            A++;
        }
        return new int[] {A, B};
    }

    public boolean containsZero(int num) {
        while(num!=0) {
            int t = num%10;
            if(t == 0) return true;
            num /= 10;
        }
        return false;
    }
}
