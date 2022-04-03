class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs.length == 0 || strs == null){
            return result;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            map.put(key, map.getOrDefault(key, new ArrayList<String>()));
            map.get(key).add(str);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
}
