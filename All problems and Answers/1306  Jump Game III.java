class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>(Arrays.asList(start));
        Set<Integer> seen = new HashSet<>(q);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (arr[cur] == 0) return true;
            for (int child : new int[]{cur - arr[cur], cur + arr[cur]})
                if (0 <= child  && child < arr.length && seen.add(child))
                    q.offer(child);
        }
        return false;
    }
}
