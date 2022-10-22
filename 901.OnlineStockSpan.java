class StockSpanner {
    private int index;
    Stack<int[]> stack;
    public StockSpanner() {
        this.index = -1;
        this.stack = new Stack<>();
        stack.push(new int[]{index, Integer.MAX_VALUE});
    }
    
    public int next(int price) {
        index++;
        while(price >= stack.peek()[1]) stack.pop();
        int result = index - stack.peek()[0];
        stack.push(new int[]{index, price});
        return result;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
