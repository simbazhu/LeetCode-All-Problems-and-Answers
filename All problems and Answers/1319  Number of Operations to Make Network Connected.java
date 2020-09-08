class Solution {
    private int[] root; // components roots.
    private int count; // # of components. 
    public int makeConnected(int n, int[][] connections) {
        count = n; // # of nodes.
        root = IntStream.range(0, n).toArray(); // Initialization of the roots of the nodes to themselves.
        for (int[] c : connections) { union(c[0], c[1]); } //  if the 2 connected nodes are NOT in the same component yet, merge their components. 
        return connections.length < n - 1 ? -1 : count - 1;
    }
    private int find(int x) {
        while (x != root[x]) x = root[x];
        return x;
    }
    private void union(int x, int y) {
        int rx = find(x), ry = find(y);
        if (rx == ry) return;
        root[rx] = ry; 
        --count;
    }
}
