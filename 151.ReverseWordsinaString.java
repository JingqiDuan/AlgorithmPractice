class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        Stack<String> stack = new Stack<>();
        s = s.trim();
        //split multi space
        String[] strArr = s.split(" +");
        for(String str : strArr){
            stack.push(str);
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
            result.append(" ");
        }
        return result.toString().trim();
    }
}
