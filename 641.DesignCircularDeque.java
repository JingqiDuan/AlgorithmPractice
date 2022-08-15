class MyCircularDeque {
    int[] arr;
    int front, rear;
    int count;
    int k;
    public MyCircularDeque(int k) {
        this.arr = new int[k];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
        this.k = k;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        front = (front + k - 1) % k;
        arr[front] = value;
        count++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        arr[rear] = value;
        rear = (rear + 1) % k;
        count++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        front = (front + 1) % k;
        count--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        rear = (rear + k - 1) % k;
        count--;
        return true;
    }
    
    public int getFront() {
        return isEmpty() ? -1 : arr[front];
    }
    
    public int getRear() {
        return isEmpty() ? -1 : arr[(rear + k - 1) % k];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == k;
    }
}
