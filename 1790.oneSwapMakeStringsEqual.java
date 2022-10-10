class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int len = s1.length();
        int index = -1, count = 0;
        boolean check = false;
        for(int i = 0; i < len; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(count < 1) index = i;
                count++;
            }
            if(count == 2 && !check){
                check = true;
                if(s1.charAt(index) != s2.charAt(i) || s2.charAt(index) != s1.charAt(i)) return false;
            }
            if(count > 2) return false;
        }
        return count == 2 || count == 0;
    }
}
