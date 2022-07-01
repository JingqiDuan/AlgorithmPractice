class Solution {
    public boolean isSubsequence(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        int pS = 0, pT = 0;
        while(pS < lenS && pT < lenT){
            if(s.charAt(pS) == t.charAt(pT)){
                pS++;
            }
            pT++;
        }
        return pS == lenS;
    }
}
