class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet();
        for(String word: wordList) {
            set.add(word);
        }
        if(!set.contains(endWord)) {
            return 0;
        }
        Queue<String> q = new LinkedList();
        q.add(beginWord);
        int level = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                char[] wordChar = q.poll().toCharArray();
                for(int j = 0; j < wordChar.length; j++) {
                    char orgChar = wordChar[j];
                    for(char c = 'a'; c <= 'z'; c++) {
                        wordChar[j] = c;
                        if(c == orgChar) {
                            continue;
                        }
                        String newStr = String.valueOf(wordChar);
                        if(endWord.equals(newStr)) {
                            return level+1;
                        }
                        if(set.contains(newStr)) {
                            q.add(newStr);
                            set.remove(newStr);
                        }
                    }
                    wordChar[j] = orgChar;
                }
            }
            level++;
        }
        return 0;
    }
}