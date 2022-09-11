class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->a-b);
        for(int[]interval:intervals){
            if(!queue.isEmpty() && queue.peek()<interval[0]){
                queue.poll();
            }
            queue.offer(interval[1]);
        }
        return queue.size();
    }
}
