class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sa = 0, sb = 0;  // sum of A, B respectively
        for (int a : A) sa += a;
        for (int b : B) sb += b;
        int delta = (sb - sa) / 2;
        // if Alice gives x, she expects to receive x + delta
        
        Set<Integer> setB = new HashSet();
        for (int b : B) setB.add(b);
        
        for (int x : A)
            if (setB.contains(x + delta))
                return new int[]{x, x + delta};
        
        throw null;
    }
}
