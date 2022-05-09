class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        for(int i = Math.min(len1, len2); i >= 1; i--){
            if(len1 % i == 0 && len2 % i == 0){
                String tmp = str1.substring(0, i);
                if(check(tmp, str1) && check(tmp, str2)){
                    return tmp;
                }
            }
        }
        return "";
    }
    public boolean check(String tmp, String str){
        int tLen = tmp.length();
        int sLen = str.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sLen / tLen; i++){
            sb.append(tmp);
        }
        return sb.toString().equals(str);
    }
}
