class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        //int[]{number, frequency}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((int[] a, int[] b) -> (a[1] - b[1]));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int number = entry.getKey();
            int freq = entry.getValue();
            if(minHeap.size() == k){
                if(minHeap.peek()[1] < freq){
                    minHeap.poll();
                    minHeap.offer(new int[]{number, freq});
                }
            }else{
                minHeap.offer(new int[]{number, freq});
            }
        }
        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i--){
            result[i] = minHeap.poll()[0];
        }
        return result;
    }
}
