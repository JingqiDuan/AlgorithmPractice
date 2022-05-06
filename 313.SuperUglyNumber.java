class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 1){
            return 1;
        }
        int len = primes.length;
        int[] pointers = new int[len];
        int[] nums = new int[n];
        nums[0] = 1;
        for(int i = 1; i < n; i++){     
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();       
            for(int j = 0; j < len; j++){
                minHeap.offer(nums[pointers[j]] * primes[j]);
            }
            nums[i] = minHeap.poll();
            for(int j = 0; j < len; j++){
                if(nums[pointers[j]] * primes[j] == nums[i]){
                    pointers[j]++;
                }
            }
        }
        return nums[n - 1];
    }
}
