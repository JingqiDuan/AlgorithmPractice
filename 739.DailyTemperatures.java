class Solution {
    public int[] dailyTemperatures(int[] temperatures){
        if(temperatures == null || temperatures.length == 0){
            return new int[0];
        }
        int[] result = new int[temperatures.length];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < temperatures.length; i++){
            while(!deque.isEmpty() && temperatures[deque.peekLast()] < temperatures[i]){
                int prevIndex = deque.pollLast();
                result[prevIndex] = i - prevIndex;
            }
            deque.offerLast(i);
        }
        return result;
    }

    /*public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            for(int j = i + 1; j < temperatures.length; j++){
                if(temperatures[j] > temperatures[i]){
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }*/
}
