class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedList = new ArrayList<>();
        if(intervals.length == 0 || intervals[0].length == 0){
            return new int[][]{newInterval};
        }
        int leftNew = newInterval[0];
        int rightNew = newInterval[1];
        boolean used = false;
        for(int[] arr : intervals){
            if(rightNew < arr[0]){
                if(!used){
                    mergedList.add(new int[]{leftNew, rightNew});
                    used = true;
                }
                mergedList.add(arr);
            }else if(leftNew > arr[1]){
                mergedList.add(arr);
            }else{
                leftNew = Math.min(arr[0], leftNew);
                rightNew = Math.max(arr[1], rightNew);
            }
        }
        if(!used){
            mergedList.add(new int[]{leftNew, rightNew});
        }
        return mergedList.toArray(new int[mergedList.size()][2]);
    }
}

/*
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedList = new ArrayList<>();
        if(intervals.length == 0 || intervals[0].length == 0){
            return new int[][]{newInterval};
        }
        int left = 0;
        int leftBorder = -1, rightBorder = -1;
        while(left < intervals.length){
            if(newInterval[0] <= intervals[left][1]){
                leftBorder = Math.min(intervals[left][0], newInterval[0]);
                int right = left;
                while(right < intervals.length && newInterval[1] > intervals[right][1]){
                    right++;
                }
                if(right < intervals.length){
                    rightBorder = newInterval[1] < intervals[right][0] ? newInterval[1] : intervals[right][1];
                }else{
                    rightBorder = newInterval[1];
                }
                mergedList.add(new int[]{leftBorder, rightBorder});
                newInterval[0] = Integer.MAX_VALUE;
                newInterval[1] = Integer.MAX_VALUE;
                left = right;
            }else{
                if(intervals[left][1] != rightBorder){
                    mergedList.add(intervals[left]);
                }
                left++;
            }
        }
        if(newInterval[0] != Integer.MAX_VALUE){
            mergedList.add(newInterval);
        }
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}
*/
