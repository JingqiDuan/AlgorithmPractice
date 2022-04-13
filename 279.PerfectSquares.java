class Solution {
    public int numSquares(int n) {
        if(n <= 0){
            return 0;
        }
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while(!queue.isEmpty()){
            int size = queue.size();
            result++;
            for(int i = 0; i < size; i++){
                int remainder = queue.poll();
                for(int j = 1; j < n; j++){
                    int newRemainder = remainder - j * j;
                    if(newRemainder > 0){
                        queue.offer(newRemainder);
                    }else if(newRemainder == 0){
                        return result;
                    }else{
                        break;
                    }
                }
            }
        }
        return result;
    }
}
