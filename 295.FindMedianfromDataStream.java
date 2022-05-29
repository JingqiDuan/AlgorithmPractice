class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        if(!minHeap.isEmpty()){
            if(minHeap.peek() > num){
                maxHeap.offer(num);
                if(maxHeap.size() - minHeap.size() == 2){
                    minHeap.offer(maxHeap.poll());
                }
            }else{
                minHeap.offer(num);
                if(minHeap.size() - maxHeap.size() == 2){
                    maxHeap.offer(minHeap.poll());
                }
            }
        }else{
            minHeap.offer(num);
        }
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()){
            double result = (double) (minHeap.peek() + maxHeap.peek()) / 2;
            return result; 
        }
        return (double) minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
