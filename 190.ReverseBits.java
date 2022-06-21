public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        //n != 0
        for(int i = 0; i < 32 && n != 0; i++){
            //31
            result |= (1 & n) << (31 - i);
            n >>= 1;
        }
        return result;
    }
}
