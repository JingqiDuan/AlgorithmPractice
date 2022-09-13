class Solution {
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int len = arr.length;
        int maxIndex = len - 1;
        int index1 = -1;
        int index2 = -1;
        for(int i = len - 1; i >= 0; i--){
            if(arr[i] > arr[maxIndex]){
                maxIndex = i;
            }else if(arr[i] < arr[maxIndex]){
                index1 = i;
                index2 = maxIndex;
            }
        }
        if(index1 >= 0){
            return swap(arr, index1, index2);
        }
        return num;
    }
    
    public int swap(char[] arr, int i, int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        String ans = new String(arr);
        return Integer.parseInt(ans);
    }
}
