class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    // int cnt=0;

    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        });
        
        minHeap = new PriorityQueue();
    }
    
    public void addNum(int num) {
        // cnt++;
        // maxHeap contains smaller half, minHeap contains larger half of integers
        if(maxHeap.size() == 0) {
            maxHeap.add(num);
        }
        else if(maxHeap.size() > minHeap.size()) {
            if (maxHeap.peek() > num) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }  
        }
        else {
            if(minHeap.peek() < num) {
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }
        }
    }
    
    public double findMedian() {
        return (maxHeap.size() + minHeap.size())%2 == 0 ? (maxHeap.peek() + minHeap.peek())/2.0 : maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */