class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--) {
                ret.set(j, ret.get(j - 1) + ret.get(j));
            }
            ret.add(1);
        }
        return ret;
    }
}
