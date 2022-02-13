public int mySqrt(int x) {
        if(x <= 0){
            return 0;
        }
        if(x == 1){
            return 1;
        }
        int left = 0, right = x;
        while(left <= right){
            int mid = left + (right - left)/2;
          //use division to avoid OFM if the number is too big
            if(mid < x / mid){
                left = mid + 1;
            }else if(x / mid == mid){
                return mid;
            }else{
                right = mid - 1;
            }
        }
        return right;
    }
