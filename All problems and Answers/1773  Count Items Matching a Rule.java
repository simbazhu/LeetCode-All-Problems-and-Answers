class Solution {
    private static final Map<String, Integer> rule = Map.of("type", 0, "color", 1, "name", 2);
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int cnt = 0, index = rule.get(ruleKey);
        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue)) {
                ++cnt;
            }
        }
        return cnt;
    }
}
