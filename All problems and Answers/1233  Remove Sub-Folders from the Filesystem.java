class Solution {
    class Trie {
        Trie[] sub = new Trie[27];
        int index = -1;
    }
    public List<String> removeSubfolders(String[] folder) {
        Trie root = new Trie();
        for (int i = 0; i < folder.length; ++i) {
            Trie t = root;
            for (char c : folder[i].toCharArray()) {
                int idx = c == '/' ? 26 : c - 'a'; // correspond '/' to index 26.
                if (t.sub[idx] == null)
                    t.sub[idx] = new Trie();
                t = t.sub[idx];
            }
            t.index = i;
        }
        return bfs(root, folder);
    }
    private List<String> bfs(Trie t, String[] folder) {
        List<String> ans = new ArrayList<>();
        Queue<Trie> q = new LinkedList<>();
        q.offer(t);
        while (!q.isEmpty()) { // BFS search.
            t = q.poll();
            if (t.index >= 0) { // found a parent folder, but there might be more.
                ans.add(folder[t.index]);
            }
            for (int i = 0; i < 27; ++i)
                if (t.sub[i] != null && !(i == 26 && t.index >= 0)) // not yet found all parent folders in current trie branch.
                    q.offer(t.sub[i]);
        }
        return ans;
    }
}
