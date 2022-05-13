class Solution {
    public boolean oneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        if(len1 > len2){
            return oneEditAway(second, first);
        }
        if(len2 - len1 > 1){
            return false;
        }
        int i = 0;
        int j = 0;
        int count = 0;
        while(i < len1 && j < len2 && count < 2){
            char char1 = first.charAt(i);
            char char2 = second.charAt(j);
            if(char1 == char2){
                i++;
                j++;
            }else{
                if(len1 == len2){
                    i++;
                    j++;
                    count++;
                }else{
                    j++;
                    count++;
                }
            }
        }
        return count <= 1;
    }
}
