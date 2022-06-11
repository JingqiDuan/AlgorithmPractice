class Solution {
    public boolean canReach(int[] arr, int start) {
        return helper(arr, start);
    }
    public boolean helper(int[] arr, int start){
        if(start < 0 || start >= arr.length || arr[start] == -1){
            return false;
        }
        int step = arr[start];
        arr[start] = -1;
        return step == 0 || helper(arr, start + step) || helper(arr, start - step);
    }
}

/*

class Solution {
    public boolean canReach(int[] arr, int start) {
        int len = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int depth = 0;
        boolean[] visited = new boolean[len];
        while(!queue.isEmpty()){
            int index = queue.poll();
            visited[index] = true;
            int steps = arr[index];
            if(steps == 0){
                return true;
            }
            if(index + steps < len && !visited[index + steps]){
                queue.offer(index + steps);
            }
            if(index - steps >= 0 && !visited[index - steps]){
                queue.offer(index - steps);
            }
        }
        return false;
    }
}

*/
