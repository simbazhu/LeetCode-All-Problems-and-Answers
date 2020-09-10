class Solution {
    public int[] closestDivisors(int x) {
        for (int a = (int)Math.sqrt(x + 2); a > 0; --a) {
            if ((x + 1) % a == 0)
                return new int[]{a, (x + 1) / a};
            if ((x + 2) % a == 0)
                return new int[]{a, (x + 2) / a};
        }
        return new int[]{};
    }
}
