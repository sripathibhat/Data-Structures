class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        solve(s, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void solve(String s, int i, List<String> list, List<List<String>> res) {
        if(i == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int k = i; k < s.length(); k++) {
            if(isPalin(s, i, k)) {
                list.add(s.substring(i, k + 1));
                solve(s, k + 1, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isPalin(String s, int l, int h) {
        while(l < h) {
            if(s.charAt(l) != s.charAt(h)) {
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
}