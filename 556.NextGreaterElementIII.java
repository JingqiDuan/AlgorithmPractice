class Solution {
    public int nextGreaterElement(int n) {
        if(n <= 11){
            return -1;
        }
        char[] numArr = String.valueOf(n).toCharArray();
        for(int i = numArr.length - 2; i >=0; i--){
            if(numArr[i] < numArr[i + 1]){
                swap(numArr, i);
                reverse(numArr, i + 1);
                StringBuilder sb = new StringBuilder();
                for(char c : numArr){
                    sb.append(c);
                }
                
                long number = Long.parseLong(sb.toString());
                if(number > Integer.MAX_VALUE){
                    return - 1;
                }else{
                    return (int)number;
                }
            }
        }
        return -1;
    }
    public void swap(char[] numArr, int index){
        for(int i = numArr.length - 1; i > index; i--){
            if(numArr[index] < numArr[i]){
                char tmp = numArr[index];
                numArr[index] = numArr[i]; 
                numArr[i] = tmp;
                break;
            }
        }
    }
    public void reverse(char[] numArr, int index){
        int left = index;
        int right = numArr.length - 1;
        while(left < right){
            char tmp = numArr[left];
            numArr[left] = numArr[right];
            numArr[right] = tmp;
            left++;
            right--;
        }
    }
}
