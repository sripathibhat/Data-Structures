class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> stmap = new HashMap<>();
        Map<Character, Character> tsmap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
            if(stmap.containsKey(schar) && stmap.get(schar) != tchar) {
                return false;
            }
            if(tsmap.containsKey(tchar) && tsmap.get(tchar) != schar) {
                return false;
            }
            stmap.put(schar, tchar);
            tsmap.put(tchar, schar);
        }
        return true;
    }
}