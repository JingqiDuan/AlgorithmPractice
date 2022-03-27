/*class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length()){
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
        //don't use int
        //int值在[-128,127]范围内是使用缓存中的对象，超过这个范围就创建新的Integer对象。
        for(Integer i = 0; i < words.length; i++){
            if(map.put(pattern.charAt(i), i) != map.put(words[i], i)){
                return false;
            }
        }
        return true;
    }
}*/

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length()){
            return false;
        }
        HashMap<String, Character> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            if(map.containsKey(word)){
                if(map.get(word) != pattern.charAt(i)){
                    return false;
                }
            }else{
                if(map.containsValue(pattern.charAt(i))){
                    return false;
                }else{
                    map.put(word, pattern.charAt(i));
                }
            }
        }
        return true;
    }
}
