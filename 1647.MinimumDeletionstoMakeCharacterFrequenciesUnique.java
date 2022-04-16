class Solution {
    public int minDeletions(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        int result = 0;
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c : map.keySet()){
            int number = map.get(c);
            while(set.contains(number)){
                number--;
                result++;
            }
            if(number != 0){
                set.add(number);
            }
        }
        return result;
    }
}
