class Solution {
    public int numPrimeArrangements(int n) {
        int cnt = 1; // # of primes, first prime is 2.
        outer:
        for (int i = 3; i <= n; i += 2) { // only odd number could be a prime, if i > 2.
            for (int factor = 3; factor * factor <= i; factor += 2)
                if (i % factor == 0)
                    continue outer;
            ++cnt;
        }
        long ans = 1;
        for (int i = 1; i <= cnt; ++i) // (# of primes)!
            ans = ans * i % 1_000_000_007;
        for (int i = 1; i <= n - cnt; ++i) // (# of non-primes)!
            ans = ans * i % 1_000_000_007;
        return (int)ans;
    }
}
