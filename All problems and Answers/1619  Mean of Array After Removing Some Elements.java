class Solution {
    public double trimMean(int[] arr) {
        int l = arr.length, trim = l / 20, sum = 0;
        double div = l - 2 * trim;
        PriorityQueue<Integer> hq = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> lq = new PriorityQueue<>((a, b) -> b - a);
        for (int i : arr) {
            hq.offer(i);
            if (hq.size() > trim) {
                lq.offer(hq.poll());
                if (lq.size() > trim) sum += lq.poll();
            }            
        }
        return sum / div;
    }
}
