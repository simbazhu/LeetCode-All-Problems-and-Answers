class RLEIterator {
    int[] A;
    int index;
    
    public RLEIterator(int[] A) {
        this.A = A;
        index = 0;
    }
    
    public int next(int n) {
        while (index < A.length) {
            if (n > A[index]) {
                n -= A[index];
                A[index] = 0;
                index += 2;
            } else {
                A[index] -= n;
                return A[index+1];
            }
        }
        
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */
