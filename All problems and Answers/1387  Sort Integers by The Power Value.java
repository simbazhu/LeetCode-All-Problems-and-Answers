class Solution {
    Map<Integer,Integer> map; // Store steps for each value to reach 1. So that it can be reused.

    public int getKth(int lo, int hi, int k) {
        map = new HashMap<>();
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a,b)-> b[1]!=a[1] ?a[1]-b[1]:a[0]-b[0]);
        for (int i=lo;i<=hi;i++) {
            pq.add(new int[]{i,util(i)});
        }
        while (!pq.isEmpty() && k-->1) { 
            pq.poll();
        }
        return pq.poll()[0];
    }

    private int util(int val) {
        if(val==1) {
            return 0;
        }
        if(map.containsKey(val)) {
            return map.get(val);
        }
        if((val&1)==0) {
            map.put(val,util(val/2)+1);
        } else {
            map.put(val,util(3*val+1)+1);
        }
        return map.get(val);
    }
}
