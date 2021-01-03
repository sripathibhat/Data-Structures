// 218
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList();
        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length * 2];
        int i = 0;
        for(int[] building: buildings) {
            BuildingPoint b = new BuildingPoint();
            b.x = building[0];
            b.height = building[2];
            b.isStart = true;
            buildingPoints[i] = b;
            
            b = new BuildingPoint();
            b.x = building[1];
            b.height = building[2];
            b.isStart = false;
            buildingPoints[i+1] = b;
            
            i += 2;
        }
        Arrays.sort(buildingPoints);
        
        TreeMap<Integer, Integer> map = new TreeMap();
        // PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        map.put(0, 1);
        // pq.add(0);
        int prevMaxHt = 0;
        for(BuildingPoint b: buildingPoints) {
            if(b.isStart) {
                map.put(b.height, map.getOrDefault(b.height, 0)+1);
                // pq.add(b.height);
            } 
            else {
                // pq.remove(b.height);
                int cnt = map.get(b.height);
                if(cnt == 1) {
                    map.remove(b.height);
                }
                else {
                    map.put(b.height, cnt-1);
                }
            }
            int currentMaxHt = map.lastKey(); // pq.peek(); 
            if(prevMaxHt != currentMaxHt) {
                res.add(Arrays.asList(b.x, currentMaxHt));
                prevMaxHt = currentMaxHt;
            }
        }
        
        return res;
    }
    
    class BuildingPoint implements Comparable<BuildingPoint> {
        int x;
        int height;
        boolean isStart;
        
        public int compareTo(BuildingPoint o) {
            if(this.x != o.x) {
                return this.x - o.x;
            }
            return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
        }
    }
}

