class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] result = new int[queries.length];
        //heap<{num, index}>
        PriorityQueue<String[]> maxHeap = new PriorityQueue<>((m, n) -> {
                if (n[0].compareTo(m[0]) == 0) {
                    return Integer.parseInt(n[1]) - Integer.parseInt(m[1]);
                }
                return n[0].compareTo(m[0]);
            });
        for (int i = 0; i < queries.length; i++) {
            maxHeap.clear();
            int kTh = queries[i][0];
            int trimIndex = queries[i][1];
            for(int j = 0; j < nums.length; j++){
                maxHeap.offer(new String[]{nums[j].substring(nums[0].length() - trimIndex), String.valueOf(j)});
                if(maxHeap.size() > kTh){
                    maxHeap.poll();
                }
            }
            result[i] = Integer.valueOf(maxHeap.poll()[1]);
        }
        return result;
    }
}
