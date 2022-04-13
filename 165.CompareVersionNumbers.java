class Solution {
    public int compareVersion(String version1, String version2) {
        int len1 = version1.length();
        int len2 = version2.length();
        int i = 0;
        int j = 0;
        while(i < len1 || j < len2){
            int x = 0;
            int y = 0;
            for(; i < len1 && version1.charAt(i) != '.'; i++){
                x = x * 10 + version1.charAt(i) - '0';
            }
            i++;
            for(; j < len2 && version2.charAt(j) != '.'; j++){
                y = y * 10 + version2.charAt(j) - '0';
            }
            j++;
            if(x != y){
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }
}
