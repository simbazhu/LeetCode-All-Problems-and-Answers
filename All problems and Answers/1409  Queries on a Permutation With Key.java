class Solution {
    public int[] processQueries(int[] qs, int m) {
        LinkedList<Integer> l = new LinkedList<>();  // Interface is LinkedList other than list
        for (int i = 1; i <= m; i++) l.add(i);
        int[] res = new int[qs.length];
        for (int i = 0; i < qs.length; i++) {
            int idx = l.indexOf(qs[i]);
            l.remove(idx);
            l.addFirst(qs[i]);
            res[i] = idx;
        }
        return res;
    }
}
