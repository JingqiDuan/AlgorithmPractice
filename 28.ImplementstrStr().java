class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() != 0 && haystack.length() == 0){
            return -1;
        }
        if(haystack == null || haystack.length() == 0){
            return 0;
        }
        if(needle == null || needle.length() == 0){
            return 0;
        }
        for(int i = 0; i < haystack.length() + 1 - needle.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0) && containStr(i, haystack, needle)){
                return i;
            }
        }
        return -1;
    }

    private boolean containStr(int start, String haystack, String needle){
        int i = 0;
        while(i < needle.length() && start < haystack.length() && 
                haystack.charAt(start) == needle.charAt(i)){
                    i++;
                    start++;
        }
        return i == needle.length();
    }
}
