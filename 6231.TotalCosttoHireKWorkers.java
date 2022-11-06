class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> heapL = new PriorityQueue<>();
        PriorityQueue<Integer> heapR = new PriorityQueue<>();
        int n = costs.length;
        if(n == 0) return costs[0];
        int left = 0, right = n - 1;
        while(heapL.size() < candidates){
            heapL.offer(costs[left++]);
        }
        while(heapR.size() < candidates){
            heapR.offer(left <= right ? costs[right--] : Integer.MAX_VALUE);
        }
        long result = 0L;
        for(int i = 0; i < k; i++){
            if(heapL.peek() <= heapR.peek()){
                result += heapL.poll();
                heapL.offer(left <= right ? costs[left++] : Integer.MAX_VALUE);
            }else{
                result += heapR.poll();
                heapR.offer(right >= left ? costs[right--] : Integer.MAX_VALUE);
            }
        }
        return result;
    }
}
