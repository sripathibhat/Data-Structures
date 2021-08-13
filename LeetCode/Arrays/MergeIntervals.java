class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) {
            return intervals;
        }
        List<Interval> intervalsList = new ArrayList<Interval>();
        for(int i=0; i<intervals.length; i++) {
            Interval interval = new Interval();
            interval.setStart(intervals[i][0]);
            interval.setEnd(intervals[i][1]);
            intervalsList.add(interval);
        }
        // Greedy
        Collections.sort(intervalsList, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.getStart()-b.getStart();
            }
        });
        List<Interval> uniqueIntervals = new ArrayList<Interval>();
        Interval curInterval = intervalsList.get(0);
        uniqueIntervals.add(curInterval);
        for(int i=1; i<intervalsList.size(); i++) {
            Interval nextInterval = intervalsList.get(i);
            if(curInterval.getEnd()>= nextInterval.getStart()) {
                // overlapping, update curInterval
                curInterval.setEnd(Math.max(curInterval.getEnd(), nextInterval.getEnd()));
            } else {
                curInterval = nextInterval;
                uniqueIntervals.add(curInterval);
            }
        }
        int res[][] = new int[uniqueIntervals.size()][2];
        for(int k=0; k<uniqueIntervals.size(); k++) {
            //System.out.println(t.getStart() + " " + t.getEnd());
            res[k][0] = uniqueIntervals.get(k).getStart();
            res[k][1] = uniqueIntervals.get(k).getEnd();
        }
        return res;
    }
    
    class Interval {
        private int start; 
        private int end;
        
        public int getStart() {
            return start;
        }
        public int getEnd() {
            return end;
        }        
        public void setStart(int start) {
            this.start = start;
        }
        public void setEnd(int end) {
            this.end = end;
        }
    }
}