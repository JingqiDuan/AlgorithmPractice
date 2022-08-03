class MyCircularQueue {
    private int head, tail, k;
    private int[] nums;
    public MyCircularQueue(int k) {
        this.k = k;
        this.nums = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        nums[tail % k] = value;
        return ++tail >= 0;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        return ++head >= 0;
    }
    
    public int Front() {
        return isEmpty() ? -1 : nums[head % k];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : nums[(tail - 1) % k];
    }
    
    public boolean isEmpty() {
        return head == tail;
    }
    
    public boolean isFull() {
        return tail - head == k;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
