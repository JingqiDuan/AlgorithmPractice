class Solution {
    public String multiply(String num1, String num2) {
        /**
        num1的第i位(高位从0开始)和num2的第j位相乘的结果在乘积中的位置是[i+j, i+j+1]
        **/
        int len1 = num1.length();
        int len2 = num2.length();
        if(len1 == 0 || len2 == 0){
            return "";
        }
        int[] result = new int[len1 + len2];
        for(int i = len1 - 1; i >= 0; i--){
            for(int j = len2 - 1; j >= 0; j--){
                int prod = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                //add carry first
                prod += result[i + j + 1];
                result[i + j] += prod / 10;
                //it's '=' here
                result[i + j + 1] = prod % 10;
            }
        }
        StringBuilder ans = new StringBuilder();
        int index = 0;
        while(index <= result.length - 2 && result[index] == 0){
            index++;
        }
        for(int i = index; i < result.length; i++){
            ans.append(result[i]);
        }
        return ans.toString();
    }
}
