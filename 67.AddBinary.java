class Solution {
    public String addBinary(String a, String b) {
        int len = Math.max(a.length(), b.length()) + 1;
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(indexA >= 0 || indexB >= 0 || carry != 0 ){
            int digitA = indexA >= 0 ? a.charAt(indexA--) - '0' : 0;
            int digitB = indexB >= 0 ? b.charAt(indexB--) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1 : 0;
            sb.append(sum % 2);
        }
        return sb.reverse().toString();
    }
}
