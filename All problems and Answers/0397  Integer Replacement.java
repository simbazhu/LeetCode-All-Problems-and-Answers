class Solution {
    public int integerReplacement(int n) {
        Queue<Long> queue = new LinkedList<>();
        queue.offer((long)n);
        int count = 0;
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Long num = queue.poll();
                if (num == 1) {
                    return count;
                }
                if (num % 2 == 0) {
                    queue.offer(num / 2);
                } else {
                    queue.offer(num + 1);
                    queue.offer(num - 1);
                }
            }
            count++;
        }
        return -1;
    }
}
