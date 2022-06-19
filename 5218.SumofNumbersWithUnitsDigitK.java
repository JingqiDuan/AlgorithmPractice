class Solution {
    public int minimumNumbers(int num, int k) {
        if(num == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < 10; i++){
            set.add((k * i) % 10);
        }
        if(!set.contains(num % 10) || num < k){
            return -1;
        }
        int result = 1;
        while(num % 10 != k){
            result++;
            num -= k;
            if(num < 0){
                return -1;
            }
        }
        return result;
    }
}
