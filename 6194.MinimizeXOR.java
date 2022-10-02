class Solution {
    public int minimizeXor(int num1, int num2) {
        int count2 = Integer.bitCount(num2);
        int count1 = Integer.bitCount(num1);
        if(count1 == count2) return num1;
        int x = 0, countX = 0;
        for(int i = 31; i >= 0; i--){
            if(countX < count2){
                if(((num1 >> i) & 1) == 1){
                    x += (1 << i);
                    countX++;
                } 
            }else{
                break;
            }
        }
        int pos = 0;
        while(countX < count2){
            if(((x >> pos) & 1) == 0){
                x += (1 << pos);
                countX++;
            }
            pos++;
        }
        return x;
    }
}
