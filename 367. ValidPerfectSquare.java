class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 0){
            return false;
        }
        if( num == 0){
            return true;
        }
        int left = 1;
        int right = num;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mid == num / mid){
            //remember to use moduler when deviding
                return num % mid == 0;
            }else if(mid < num / mid){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        } 
        return false;
    }
}
