// 140
class Solution {
    // Map<String, List<String>> m = new HashMap();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> map = new HashMap();
        return solve(s, 0, wordDict, map);
        
        // if(m.containsKey(s)) {
        //     return m.get(s);
        // }
        // List<String> res = new ArrayList();
        // if(wordDict.contains(s)) {
        //     res.add(s);
        // }
        // for(int i=1; i<s.length(); i++) {
        //     String left = s.substring(0, i);
        //     if(wordDict.contains(left)) {
        //         List<String> temp = wordBreak(s.substring(i), wordDict);
        //         for(String t: temp) {
        //             res.add(left + " " + t);
        //         }
        //     }
        // }
        // m.put(s, res);
        // return res;
    }
    
    private List<String> solve(String s, int index, List<String> dict, Map<Integer, List<String>> map) {
        if(index == s.length()) {
            // can't break s further
            return Arrays.asList("");
        }
        if(map.containsKey(index)) {
            return map.get(index);
        }
        List<String> res = new ArrayList();
        for(String word: dict) {
            if(s.indexOf(word, index) == index) {
                List<String> temp = solve(s, index+word.length(), dict, map);
                for(String t: temp) {
                    res.add(t.equals("") ? word : word + " " + t);
                }
            }
        }
        map.put(index, res);
        return res;
    }
}