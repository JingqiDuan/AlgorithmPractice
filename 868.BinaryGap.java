class Solution {
    public int binaryGap(int n) {
        int result = 0;
        int first = -1;
        int second = -1;
        int index = 0;
        while(n != 0){
            if((n & 1) == 1 && first < 0 && second < 0 ){
                first = index;
                second = index;
            }
            if((n & 1) == 1 && first >= 0 && second >= 0){
                first = second;
                second = index;
                result = Math.max(result, second - first);
            }
            n >>= 1;
            index++;
        }
        return result;
    }
}
