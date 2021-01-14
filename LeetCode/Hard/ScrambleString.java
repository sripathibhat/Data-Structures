// 87

class Solution {
    static HashMap<String, Boolean> lookup = new HashMap<>();
    
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
           return true;
        }
        if(s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        if (n <= 1) {
            return false;
        }
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        String sort_s1 = new String(a1);
        String sort_s2 = new String(a2);
        if (!sort_s1.equals(sort_s2)) {
            return false;
        }
        String key = s1 + "_" + s2;
        if (lookup.containsKey(key)) {
            return lookup.get(key);
        }
        for (int i = 1; i < n; i++) {
            if (isScramble(s1.substring(0,i), s2.substring(0,i)) &&
               isScramble(s1.substring(i,n), s2.substring(i,n))) {
                lookup.put(key, true);
                return true;
            }
            if (isScramble(s1.substring(0,i), s2.substring(n-i,n)) &&
               (isScramble(s1.substring(i,n), s2.substring(0,n-i)))) {
                lookup.put(key, true);
                return true;
            }
        }
        return false;
    }
}