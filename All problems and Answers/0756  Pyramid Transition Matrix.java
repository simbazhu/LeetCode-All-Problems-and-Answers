class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
            Map<String, Set<Character>> m = new HashMap<>();
            for (String s : allowed) {
                String pre = s.substring(0, 2);
                m.putIfAbsent(pre, new HashSet<>());
                m.get(pre).add(s.charAt(2));
            }
            return dfs(bottom, "", m, 1);
        }

        boolean dfs(String row, String nextRow, Map<String, Set<Character>> allowed, int i) {
            if (row.length() == 1) return true;
            if (nextRow.length() + 1 == row.length())
                return dfs(nextRow, "", allowed, 1);
            for (Character c : allowed.getOrDefault(row.substring(i - 1, i + 1), new HashSet<>()))
                if (dfs(row, nextRow + c, allowed, i + 1))
                    return true;
            return false;
        }
}
