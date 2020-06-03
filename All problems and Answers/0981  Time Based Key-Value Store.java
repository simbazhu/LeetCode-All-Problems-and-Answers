class TimeMap {
    Map<String, TreeMap<Integer, String>> M;

    /** Initialize your data structure here. */
    public TimeMap() {
        M = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!M.containsKey(key))
            M.put(key, new TreeMap());
        
        M.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!M.containsKey(key)) return "";
        
        TreeMap<Integer, String> tree = M.get(key);
        Integer t = tree.floorKey(timestamp);
        return t != null ? tree.get(t) : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
