class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> res = new ArrayList<>();
        List<String> firstRow = new ArrayList<>();
        firstRow.add("Table");
        TreeSet<String> set = new TreeSet<>();
        TreeMap<Integer,Map<String,Integer>> map = new TreeMap<>();
        for (List<String> order : orders) {
            String dish = order.get(2);
            set.add(dish);
            Integer table = Integer.parseInt(order.get(1));
            map.putIfAbsent(table,new HashMap<>());
            Map<String,Integer> m = map.get(table);
            m.put(dish,m.getOrDefault(dish,0)+1);
        }

        firstRow.addAll(set);
        res.add(firstRow);
        for (Map.Entry<Integer,Map<String,Integer>> entry : map.entrySet()) {
            List<String> list = new ArrayList<>();
            list.add(entry.getKey()+"");
            Map<String,Integer> m = entry.getValue();
            for (String dish : set) {
                list.add(m.getOrDefault(dish,0)+"");
            }
            res.add(list);
        }
        return res;

    }
}
