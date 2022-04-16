//对于每个房屋，要么用前面的暖气，要么用后面的，二者取近的，得到距离；
//对于所有的房屋，选择最大的上述距离。
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int result = 0;
        int i = 0;
        int j = 0;
        while(i < houses.length && j < heaters.length){
            //attention! it's >=
            while(j < heaters.length - 1 && 
                    Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])){
                j++;
            }
            result = Math.max(result, Math.abs(houses[i] - heaters[j]));
            i++;
        }
        return result;
    }
}
