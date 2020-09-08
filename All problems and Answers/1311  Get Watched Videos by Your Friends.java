class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        boolean[] visited = new boolean[n];
        visited[id] = true;
        while (level-- > 0) {
            int size = q.size();
            while (size-- > 0) {
                for (int f : friends[q.poll()]) {
                    if (!visited[f]) {
                        visited[f] = true;
                        q.offer(f);
                    }
                }
            }
        }

        HashMap<String, Integer> freq = new HashMap<>();
        while (!q.isEmpty()) {
            for (String s : watchedVideos.get(q.poll()))
                freq.put(s, freq.getOrDefault(s, 0) + 1);
        }
        List<String> ans = new ArrayList<>(freq.keySet());
        ans.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int f1 = freq.get(s1), f2 = freq.get(s2);
                if (f1 == f2) return s1.compareTo(s2);
                return f1 - f2;
            }
        });
        return ans;
    }
}
