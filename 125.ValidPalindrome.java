class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder goodStr = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                goodStr.append(Character.toLowerCase(c));
            }
        }
        StringBuilder revStr = new StringBuilder(goodStr).reverse();
        return goodStr.toString().equals(revStr.toString());
    }
}
