class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        int count = columnTitle.length() - 1;
        for(int i = 0; i < columnTitle.length(); i++){
            result += Math.pow(26, count--) * (columnTitle.charAt(i) - 'A' + 1);
        }
        return result;
    }
}
