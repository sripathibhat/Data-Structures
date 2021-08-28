class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        for(int i = 0; i < startTime.length; i++) {
            Job job = new Job(startTime[i], endTime[i], profit[i]);
            jobs.add(job);
        }
        Collections.sort(jobs, (a, b) -> a.end - b.end);
        int max = 0;
        // key - time, value - max profit till this time
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(Job job: jobs) {
            Integer maxProfitTillTime = map.floorKey(job.start);
            if(maxProfitTillTime == null) {
                maxProfitTillTime = 0;
            } else {
                maxProfitTillTime = map.get(maxProfitTillTime);
            }
            max = Math.max(max, maxProfitTillTime + job.profit);
            map.put(job.end, max);
        }
        return max;
    }
    
    private class Job {
        private int start;
        private int end;
        private int profit;
        
        Job(int s, int e, int p) {
            start = s;
            end = e;
            profit = p;
        }
    }
}