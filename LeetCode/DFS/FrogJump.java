/*

    A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone.
    The frog can jump on a stone, but it must not jump into the water.

    Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone.
    Initially, the frog is on the first stone and assumes the first jump must be 1 unit.

    If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.

*/

class Solution {
    public boolean canCross(int[] stones) {
        for(int i = 3; i < stones.length; i++) {
            if(stones[i] > stones[i - 1] * 2) {
                return false;
            }
        }
        
        Stack<JumpPosition> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for(int stone: stones) {
            set.add(stone);
        }
        stack.add(new JumpPosition(0, 0));
        visited.add("0-0");
        int lastStone = stones[stones.length - 1];
        
        while(!stack.isEmpty()) {
            JumpPosition jp = stack.pop();
            int curJump = jp.jump;
            int curPos = jp.pos;
            for(int nextJump = curJump - 1; nextJump <= curJump + 1; nextJump++) {
                if(nextJump <= 0) {
                    continue;  // can only jump forwards
                }
                int nextPos = curPos + nextJump;
                if(nextPos == lastStone) {
                    return true;
                }
                String key = nextPos + "-" + nextJump;
                if(set.contains(nextPos) && !visited.contains(key)) {
                    stack.add(new JumpPosition(nextJump, nextPos));
                    visited.add(key);
                }
            }
        }
        return false;
    }
    
    private class JumpPosition {
        int jump;
        int pos;
        JumpPosition(int j, int p) {
            jump = j;
            pos = p;
        }
    }
}