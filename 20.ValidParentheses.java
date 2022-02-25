class Solution {
    public boolean isValid(String s) {
        if(s == null || s.toCharArray().length == 1){
            return false;
        }
        Stack<Character> stackLeft = new Stack<>();
        for(char n : s.toCharArray()){
            if(n == '(' || n == '{' || n == '['){
                stackLeft.push(n);
            }else{
                //compare with top of stack
                if(stackLeft.empty() || !compare(stackLeft.peek(), n)){
                    return false;
                }
                stackLeft.pop();
            }
        }
        return stackLeft.empty();
    }
    private boolean compare(char left, char right){
        return left == '{' && right == '}' || left == '[' && right == ']' ||
                left == '(' && right == ')';
    }
}
