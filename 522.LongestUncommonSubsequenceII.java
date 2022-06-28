class Solution {
    public int findLUSlength(String[] strs) {
        int result = -1;
        for(int i = 0; i < strs.length; i++){
            boolean valid = true;
            for(int j = 0; j < strs.length; j++){
                if(i != j && isSubseq(strs[i], strs[j])){
                    valid = false;
                    break;
                }
            }
            if(valid) result = Math.max(result, strs[i].length());
        }
        return result;
    }

    public boolean isSubseq(String s, String t) {
        int pS = 0;
        int pT = 0;
        while(pS < s.length() && pT < t.length()){
            if(s.charAt(pS) == t.charAt(pT)){
                pS++;
            }
            pT++;
        }
        return pS == s.length();
    }
}
