class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int ast : asteroids){
            boolean isValid = true;
            while(isValid && !stack.isEmpty() && stack.peek() > 0 && ast < 0){
                int a = stack.peek();
                int b = -ast;
                if(a <= b) stack.pop();
                if(a >= b) isValid = false; 
            }
            if(isValid) stack.push(ast);
        }
        int[] result = new int[stack.size()];
        for(int i = stack.size() - 1; i >= 0; i--){
            result[i] = stack.pop();
        }
        return result;
    }
}
