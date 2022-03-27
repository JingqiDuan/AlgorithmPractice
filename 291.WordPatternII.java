class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        return helper(pattern, s, map1, map2, 0, 0);
    }
    private boolean helper(String pattern, String s, HashMap<Character, String> map1, 
                            HashMap<String, Character> map2, int index1, int index2){
        if(index1 == pattern.length() || index2 == s.length()){
            if(index1 == pattern.length() && index2 == s.length()){
                return true;
            }
            return false;
        }
        for(int i = index2; i < s.length(); i++){
            String frac = s.substring(index2, i + 1);
            char ch = pattern.charAt(index1);
            if(!map1.containsKey(ch)){//havent seen ch
                if(map2.containsKey(frac)){//frac was mapped before eg. abab -> aaaa
                    continue;
                }
                //both havent been mapped
                map1.put(ch, frac);
                map2.put(frac, ch);
                if(helper(pattern, s, map1, map2, index1 + 1, i + 1)){
                    return true;
                }
                //back track
                map1.remove(ch);
                map2.remove(frac);
            }else{//seen ch
                if(!map1.get(ch).equals(frac)){//doesnt match
                    continue;
                }
                if(helper(pattern, s, map1, map2, index1 + 1, i + 1)){//match, continue search
                    return true;
                }
            }
        }
        return false;
    }
}
