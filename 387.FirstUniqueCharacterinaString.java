class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0){
            return -1;
        }
        Map<Character, Boolean> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, !map.containsKey(c));//true -> unique
        }
        int index = 0;
        for(char c : s.toCharArray()){
            if(map.get(c)){
                return index;
            }
            index++;
        }
        return -1;
    }
}
