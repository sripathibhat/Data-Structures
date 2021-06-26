// 127
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> s = new HashSet();
        for(String word: wordList) {
            s.add(word);
        }
        
        if(!s.contains(endWord)) {
            return 0;
        }
        
        // BFS 
        Queue<String> q = new LinkedList();
        q.add(beginWord);
        int level = 1;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                String word = q.poll();
                char wordChar[] = word.toCharArray();
                for(int j=0; j<word.length(); j++) {
                    char ch = word.charAt(j);
                    for(char c='a'; c<='z'; c++) {
                        if(ch == c) {
                            continue;
                        }
                        wordChar[j] = c;
                        String newWord = String.valueOf(wordChar);
                        if(newWord.equals(endWord)) {
                            return level + 1;
                        }
                        if(s.contains(newWord)) {
                            q.add(newWord);
                            s.remove(newWord);
                        }
                    }
                    wordChar[j] = ch;
                }
            }
            level++;
        }
        return 0;
    }
}