class Solution {
    public int maxArea(int[] height) {
        int volume = 0;
        if(height.length == 0 || height == null){
            return volume;
        }
        int left = 0, right = height.length - 1;
      //as distance along x-axis is decreasing along each attemps, 
      //keeping the longer bar while moving the shorter bar to caltulate the area.
        while(left < right){
            volume = Math.max(Math.min(height[left], height[right]) * (right - left), volume);
            if(height[left] < height[right]){
                left ++;
            }else{
                right --;
            }
        }
        return volume;
    }
}
