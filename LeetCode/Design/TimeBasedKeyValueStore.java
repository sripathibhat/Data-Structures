class TimeMap {

    // private Map<String, List<ValueTimestamp>> map;
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // Using TreeMap in java which provides floorEntry, floorKey etc. since it keeps the map sorted by natural ordering of its keys.
        TreeMap treeMap = map.getOrDefault(key, new TreeMap<>());
        treeMap.put(timestamp, value);
        map.put(key, treeMap);

        // Without TreeMap
        // List<ValueTimestamp> valueTimestampList = map.getOrDefault(key, new ArrayList<>());
        // valueTimestampList.add(new ValueTimestamp(value, timestamp));
        // map.put(key, valueTimestampList);
    }
    
    public String get(String key, int timestamp) {
        String value = "";
        // Using TreeMap
        if (map.containsKey(key)) {
            Map.Entry<Integer, String> entry = map.get(key).floorEntry(timestamp);
            if (entry != null) {
                value = entry.getValue();
            }
        }

        // Binary search
        // if (map.containsKey(key)) {
        //     List<ValueTimestamp> list = map.get(key);
        //     int start = 0;
        //     int end = list.size() - 1;
        //     while (start <= end) {
        //         int mid = start + (end - start) / 2;
        //         ValueTimestamp valueTimestamp = list.get(mid);
        //         if (valueTimestamp.timestamp == timestamp) {
        //             return valueTimestamp.value;
        //         }
        //         if (valueTimestamp.timestamp < timestamp) {
        //             value = valueTimestamp.value;
        //             start = mid + 1;
        //         } else {
        //             end = mid - 1;
        //         }
        //     }
        // }

        return value;
    }

    class ValueTimestamp {
        private String value;
        private int timestamp;

        ValueTimestamp(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
