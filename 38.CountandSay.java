class Solution {
    public String countAndSay(int n) {
        String str = "1";
        for(int i = 2; i <= n ; i++){
            int left = 0;
            int right = 0;
            StringBuilder sb = new StringBuilder();
            while(right < str.length()){
                while(right < str.length() && str.charAt(left) == str.charAt(right)){
                    right++;
                }
                sb.append(right - left).append(str.charAt(left));
                left = right;
            }
            str = sb.toString();
        }
        return str;
    }
}
