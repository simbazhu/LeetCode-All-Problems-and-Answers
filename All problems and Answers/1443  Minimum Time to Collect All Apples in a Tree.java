class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        dfs(graph, 0, hasApple, new boolean[n]);
        return count;
    }
    
    int count = 0;
    private boolean dfs(List<List<Integer>> graph, int curNode, List<Boolean> hasA, boolean[] visited) {
        if (visited[curNode]) return false;
        
        visited[curNode] = true;
        boolean res = hasA.get(curNode);
        for (int i = 0; i < graph.get(curNode).size(); i++) {
            if (dfs(graph, graph.get(curNode).get(i), hasA, visited)) {
                count += 2;
                res = true;
            }
        }
        
        return res;
    }
}
