class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int sum = 0;
        for(int i = 0; i < s.length() - 1; i++){
            int curVal = map.get(s.charAt(i));
            int nextVal = map.get(s.charAt(i + 1));
            if(curVal >= nextVal){
                sum += curVal;
            }else{
                sum -= curVal;
            }
        }
        sum = sum + map.get(s.charAt(s.length() - 1));
        return sum;
    }
}
