class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, TreeSet<Integer>> nameToTime = new HashMap<>();
        for (int i = 0; i < keyName.length; ++i) {
            int time = Integer.parseInt(keyTime[i].substring(0, 2)) * 60 + Integer.parseInt(keyTime[i].substring(3));
            nameToTime.computeIfAbsent(keyName[i], s -> new TreeSet<>()).add(time);
        }
        TreeSet<String> names = new TreeSet<>();
        for (Map.Entry<String, TreeSet<Integer>> e : nameToTime.entrySet()) {
            List<Integer> list = new ArrayList<>(e.getValue());
            for (int i = 2; i < list.size(); ++i) {
                if (list.get(i) - list.get(i - 2) <= 60 ) {
                    names.add(e.getKey());
                    break;
                }
            }
        }
        return new ArrayList<>(names);
    }
}
