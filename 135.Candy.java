class Solution {
    public int candy(int[] ratings) {
        int result = 0;
        int[] left = new int[ratings.length];
        for(int i = 0; i < ratings.length; i++){
            //more than it's neighbour
            if(i > 0 && ratings[i - 1] < ratings[i]){
                left[i] = left[i - 1] + 1;
            }else{
                left[i] = 1;
            }
        }

        int[] right = new int[ratings.length];
        for(int i = ratings.length - 1; i >= 0; i--){
            if(i < ratings.length - 1 && ratings[i] > ratings[i + 1]){
                right[i] = right[i + 1] + 1;
            }else{
                right[i] = 1;
            }
            result += Math.max(right[i], left[i]);
        }
        return result;
    }
}
