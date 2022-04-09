class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        for(int i = 0; i < len; i++){
            leftMax[i] = i == 0 ? height[i] : Math.max(leftMax[i - 1], height[i]);
        }
        for(int i = len - 1; i >= 0; i--){
            rightMax[i] = i == len - 1 ? height[i] : Math.max(rightMax[i + 1], height[i]);
        }
        int result = 0;
        for(int i = 0; i < len; i++){
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return result;
    }
    /*public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int result = 0;
        while(left < right){
            if(leftMax < rightMax){
                result += leftMax - height[left];
                leftMax = Math.max(leftMax, height[++left]);
            }else{
                result += rightMax - height[right];
                rightMax = Math.max(rightMax, height[--right]);
            }
        }
        return result;
    }*/
}
