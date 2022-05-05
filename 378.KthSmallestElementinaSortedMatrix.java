class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        for(int i = 0; i < n; i++)
            minHeap.add(new int[]{matrix[i][0], i, 0});
        
        while(k != 0){
            int[] cur = minHeap.poll();
            k--;

            int curNumber = cur[0];
            if(k == 0){
                return curNumber;
            }
            if(cur[2] < n - 1){
                //cur[1] == OldX
                //cur[2] = OldY
                int index = cur[2] + 1;
                minHeap.add(new int[]{matrix[cur[1]][index], cur[1], index});
            }
        }

        return -1;
    }
}
