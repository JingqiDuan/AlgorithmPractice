/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            if(isBadVersion(1)){
                return 1;
            }
        }
        int left = 1, right = n;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid) == true){
                right = mid - 1;
            }else if(isBadVersion(mid) == false){
                left = mid + 1;
            }
        }
        if(isBadVersion(left) == true){
            return left;
        }else{
            return 0;
        }
    }
}
