class Solution {
    public boolean equalFrequency(String word) {
        int n = word.length();
        for(int i = 0; i < n; i++){
            Map<Character, Integer> map = new HashMap<>();
            for(int j = 0; j < n; j++){
                char cur = word.charAt(j);
                if(i != j) map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
            Set<Integer> set = new HashSet<>();
            for(Map.Entry<Character, Integer> entry : map.entrySet()){
                set.add(entry.getValue());
            }
            if(set.size() == 1) return true;
        }
        return false;
    }
}
