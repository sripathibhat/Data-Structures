/*
You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and
you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock,
or -1 if it is impossible.
*/
class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> deadSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for(String d: deadends) {
            deadSet.add(d);
        }
        q.add("0000");
        visited.add("0000");
        if(deadSet.contains(target) || deadSet.contains("0000")) {
            return -1;
        }
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                String s = q.poll();
                if(s.equals(target)) {
                    return level;
                }
                for(int i = 0; i < 4; i++) {
                    String s1 = s.substring(0, i) + (s.charAt(i) == '0' ? 9 : s.charAt(i) - '0' - 1) + s.substring(i + 1);
                    if(!deadSet.contains(s1) && !visited.contains(s1)) {
                        q.add(s1);
                        visited.add(s1);
                    }
                    String s2 = s.substring(0, i) + (s.charAt(i) == '9' ? 0 : s.charAt(i) - '0' + 1) + s.substring(i + 1);
                    if(!deadSet.contains(s2) && !visited.contains(s2)) {
                        q.add(s2);
                        visited.add(s2);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}