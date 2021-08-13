class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String cur: strs) {
            char[] chArr = cur.toCharArray();
            Arrays.sort(chArr);
            String s = new String(chArr);
            if(!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(cur);
        }
        res.addAll(map.values());
        return res;
    }
}