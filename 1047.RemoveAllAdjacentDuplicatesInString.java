class Solution {
    public String removeDuplicates(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(sb.length() == 0 || sb.charAt(sb.length() - 1) != s.charAt(i)){
                sb.append(s.charAt(i));
            }else{
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
