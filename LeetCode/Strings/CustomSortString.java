class Solution {
    public String customSortString(String order, String str) {
        String res = "";
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(char ch: order.toCharArray()) {
            if(map.containsKey(ch)) {
                int cnt = map.get(ch);
                for(int i = 0; i < cnt; i++) {
                    res += ch;
                }
                map.remove(ch);
                
            }
        }
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            char ch = entry.getKey();
            int cnt = entry.getValue();
            for(int i = 0; i < cnt; i++) {
                res += ch;
            }
        }
        return res;
    }
}