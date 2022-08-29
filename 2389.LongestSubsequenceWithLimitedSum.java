class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] result = new int[queries.length];
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        int preSum = 0;
        for(int i = 0; i < nums.length; i++){
            preSum += nums[i];
            map.put(preSum, i + 1);
            set.add(preSum);
        }
        for(int i = 0; i < queries.length; i++){
             if(set.floor(queries[i]) != null){
                 int tmp = set.floor(queries[i]);
                 result[i] = map.get(tmp);
             }else{
                 result[i] = 0;
             }
        }
        return result;
    }
}
