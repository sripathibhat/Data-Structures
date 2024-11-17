class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        // Step 1
        DisjointSet disjointSet = new DisjointSet(n);
        Map<String, Integer> emailToIndexMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (emailToIndexMap.containsKey(email)) {
                    disjointSet.unionBySize(emailToIndexMap.get(email), i);
                } else {
                    emailToIndexMap.put(email, i);
                }
            }
        }

        // Step 2
        Set<String> emails = emailToIndexMap.keySet();
        for (String email: emails) {
            emailToIndexMap.put(email, disjointSet.findUltimateParent(emailToIndexMap.get(email)));
        }

        // Step 3
        Map<Integer, Set<String>> indexToEmailsMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry: emailToIndexMap.entrySet()) {
            String email = entry.getKey();
            int index = entry.getValue();
            Set<String> combinedEmails = indexToEmailsMap.getOrDefault(index, new TreeSet<>());
            combinedEmails.add(email);
            indexToEmailsMap.put(index, combinedEmails);
        }

        // Step 4
        List<List<String>> res = new ArrayList<>();
        int cnt = 0;
        for (Map.Entry<Integer, Set<String>> entry: indexToEmailsMap.entrySet()) {
            String name = accounts.get(entry.getKey()).get(0);
            res.add(new ArrayList<>());
            res.get(cnt).add(name);
            Set<String> combinedEmails = entry.getValue();
            for (String email: combinedEmails) {
                res.get(cnt).add(email);
            }
            cnt++;
        }
        return res;

    }

    class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>(); 

        DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                parent.add(i);
                size.add(1);
                rank.add(0);
            }
        }

        // 2 operations, union and find.
        // In union, 2 types - By rank and by size. 
        int findUltimateParent(int x) {
            if (parent.get(x) != x) {
                parent.set(x, findUltimateParent(parent.get(x)));
            }
            return parent.get(x);
        }

        void unionBySize(int x, int y) {
            int ulpX = findUltimateParent(x);
            int ulpY = findUltimateParent(y);
            if (ulpX == ulpY) {
                return;
            }
            if (size.get(ulpX) < size.get(ulpY)) {
                parent.set(ulpX, ulpY); 
                size.set(ulpX, size.get(ulpX) + size.get(ulpY)); 
            }
            else {
                parent.set(ulpY, ulpX); 
                size.set(ulpX, size.get(ulpX) + size.get(ulpY));
            }
        }
        
        void unionByRank(int x, int y) {
            int ulpX = findUltimateParent(x);
            int ulpY = findUltimateParent(y);
            if (ulpX == ulpY) {
                return;
            }
            if (rank.get(ulpX) < rank.get(ulpY)) {
                parent.set(ulpX, ulpY);
            } else if (rank.get(ulpY) < rank.get(ulpX)) {
                parent.set(ulpY, ulpX);
            } else {
                parent.set(ulpX, ulpY);
                rank.set(ulpX, rank.get(ulpX) + 1);
            }
        }
    }
}
