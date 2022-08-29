class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0; i < garbage.length; i++){
            for(char ch : garbage[i].toCharArray()){
                result++;
                int prev = map.getOrDefault(ch, 0);
                if(prev < i) result += helper(travel, prev, i);
                map.put(ch, i);
            }
        }
        return result;
    }
    
    public int helper(int[] travel, int start, int end){
        if(start == end) return 0;
        int total = 0;
        for(int i = start; i < end; i++){
            total += travel[i];
        }
        return total;
    }
}
