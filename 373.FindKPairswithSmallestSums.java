class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> results = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> nums1[a[0]] + nums2[a[1]] - (nums1[b[0]] + nums2[b[1]]));
        int len1 = nums1.length;
        int len2 = nums2.length;
        for(int i = 0; i < Math.min(len1, k); i++){
            minHeap.offer(new int[]{i, 0});
        }
        while(k-- > 0 && !minHeap.isEmpty()){
            int[] indexPair = minHeap.poll();
            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[indexPair[0]]);
            pair.add(nums2[indexPair[1]]);
            results.add(pair);
            if(indexPair[1] + 1 < len2){
                minHeap.offer(new int[]{indexPair[0], indexPair[1] + 1});
            }
        }
        return results;
    }
}
