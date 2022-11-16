class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int result = 0;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        for(int[] box : boxTypes){
            int tmp = Math.min(box[0], truckSize);
            result += box[1] * tmp;
            truckSize -= tmp;
            if(truckSize == 0) break;
        }
        return result;
    }
}
