class Solution {
    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        int i = 0;
        int j = 0;
        while(j < len){
            if(arr[i] == 0){
                j += 2;
            }else{
                j++;
            }
            i++;
        }
        j--;
        i--;
        while(j >= 0){
            if (j < len){
                arr[j] = arr[i];
            }
            if (arr[i] == 0 && --j >= 0){
                arr[j] = 0;
            }
            i--;
            j--;
        }
    }
}
