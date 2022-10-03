class Solution {
    public boolean checkOnesSegment(String s) {
        int len = s.length();
        int count = 0, index = 0;
        while(index < len){
            while(index < len && s.charAt(index) == '0') index++;
            if(index < len){
                while(index < len && s.charAt(index) == '1') index++;
                count++;
            }
        }
        return count == 1;
    }
}
