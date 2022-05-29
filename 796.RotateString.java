class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        if(s.length() == 1){
            return s.equals(goal);
        }
        int len = s.length();
        boolean flag;
        for(int i  = 0; i < len; i++){
            flag = true;
            for(int j = 0; j < len; j++){
                if(s.charAt((i + j) % len) != goal.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }
        return false;
    }
}

/*
class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
*/
