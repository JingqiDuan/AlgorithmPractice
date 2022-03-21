class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0){
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int startStr = 0;
        int minLength = Integer.MAX_VALUE;
        while(right < s.length()){
            char rightChar = s.charAt(right);
            if(map.containsKey(rightChar)){
                map.put(rightChar, map.getOrDefault(rightChar, 0) - 1);
            }
            right ++;
            while(check(map)){
                if(right - left < minLength){
                    minLength = right - left;
                    startStr = left;
                }
                char leftChar = s.charAt(left);
                if(map.containsKey(leftChar)){
                    map.put(leftChar, map.getOrDefault(leftChar, 0) + 1);
                }
                left++;
            }
        }
        if(minLength == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(startStr, startStr + minLength);
    }

    private boolean check(HashMap<Character, Integer> map){
        //iterate through hash map
        for(int value : map.values()){
            if(value > 0){
                return false;
            }
        }
        return true;
    }
}
