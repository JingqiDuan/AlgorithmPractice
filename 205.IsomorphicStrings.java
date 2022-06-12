class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len1 = s.length();
        int len2 = s.length();
        if(len1 != len2){
            return false;
        }
        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();
        for(int i = 0; i < len1; i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(mapS.containsKey(sChar) && mapS.get(sChar) != tChar || mapT.containsKey(tChar) && mapT.get(tChar) != sChar){
                return false;
            }
            mapS.put(sChar, tChar);
            mapT.put(tChar, sChar);
        }
        return true;
    }
}
