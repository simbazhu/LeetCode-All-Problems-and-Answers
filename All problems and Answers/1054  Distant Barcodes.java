class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> m = new HashMap<>(); // {key==value}: {code==frequency} 
        for (int c : barcodes) { m.put(c, 1 + m.getOrDefault(c, 0)); }
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> m.get(j) - m.get(i));
        pq.addAll(m.keySet());
        int[] ans = new int[barcodes.length];
        int index = 0;
        while (!pq.isEmpty()) {
            int code = pq.poll(), freq = m.remove(code); // get current most frequent code and its frequency. 
            while (freq-- > 0) { // fill ans with the code for freq times.
                if (index >= barcodes.length) { index = 1; } // if even indices depleted, start to use odd ones.
                ans[index] = code;
                index += 2;
            } 
        }   
        return ans;
    }
}
