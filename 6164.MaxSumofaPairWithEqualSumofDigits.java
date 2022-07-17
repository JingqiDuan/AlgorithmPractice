class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int num : nums){
            int digitSum = helper(num);
            //putIfAbsent
            map.putIfAbsent(digitSum, new ArrayList<>());
            map.get(digitSum).add(num);
        }
        int result = -1;
        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()){
            ArrayList<Integer> valueList = entry.getValue();
            if(valueList.size() > 1){
                Collections.sort(valueList);
                int size = valueList.size();
                int currentSum = valueList.get(size - 1) + valueList.get(size - 2);
                result = Math.max(result, currentSum);
            }
        }
        return result;
    }
    public int helper(int num){
        int result = 0;
        while(num > 0){
            result += num % 10;
            num /= 10;
        }
        return result;
    }
}
